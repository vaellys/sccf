package com.sccf.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.sccf.common.EnableAuthClient;
import com.sccf.common.config.AuthServerConfiguration;
import com.sccf.common.util.ApiSigner;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author qianguobing
 * @date 2018-09-21 10:22
 */
@Configuration
@ConditionalOnBean(annotation = {EnableAuthClient.class})
public class ClientFeignInterceptor implements RequestInterceptor {
    @Autowired
    AuthServerConfiguration authServerConfiguration;

    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("appKey", authServerConfiguration.getClientId());
        Request request = requestTemplate.request();
        byte[] body = request.body();
        Map<String, Object> map = JSONObject.parseObject(new String(body, Charset.forName("utf-8")), Map.class);
        try {
            requestTemplate.header("sign", buildSign(map));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String buildSign(Map<String, Object> paramMap) throws Exception {
        //构建签名
        paramMap.put("appKey", authServerConfiguration.getClientId());
        return ApiSigner.buildSign(paramMap, authServerConfiguration.getClientSecret());
    }
}
