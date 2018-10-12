package com.sccf.common.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.sccf.common.config.AuthServerConfiguration;
import com.sccf.common.util.ApiSigner;
import com.sccf.core.commons.exception.UnauthorizedException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qianguobing
 * @ClassName: AuthenticationInterceptor
 * @Description: 接口签名认证
 * @date 2018年8月27日 上午10:41:12
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private AuthServerConfiguration configuration;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String appKey = configuration.getClientId();
        String appSecret = configuration.getClientSecret();
        if (StringUtils.isBlank(appKey) || StringUtils.isBlank(appSecret)) {
            throw new UnauthorizedException("应用appKey和appSecret未初始化！");
        }
        //获取APPKEY和客户端传过来的签名
        String reqAppKey = request.getHeader("appKey");
        String reqSign = request.getHeader("sign");
        //检查appKey
        if (StringUtils.isBlank(reqAppKey) || !StringUtils.lowerCase(reqAppKey).equals(appKey)) {
            throw new UnauthorizedException("无效的AppKey！");
        }
        //构建签名
//		Map<String, Object> paramMaps = RequestUtil.convertRequestParamsToMap(request);
        Map<String, Object> paramMaps = new HashMap<>();
        List<String> listStr = IOUtils.readLines(request.getInputStream(), "utf-8");
        if (null != listStr && !listStr.isEmpty()) {
            listStr.get(0);
            paramMaps = JSONObject.parseObject(listStr.get(0), Map.class);
        }
        paramMaps.put("appKey", appKey);
        String buildSign = ApiSigner.buildSign(paramMaps, appSecret);
        if (!ApiSigner.verify(buildSign, reqSign)) {
            throw new UnauthorizedException("无效的签名！");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
    }

}
