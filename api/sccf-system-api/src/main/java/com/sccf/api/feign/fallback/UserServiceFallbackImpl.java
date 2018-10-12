package com.sccf.api.feign.fallback;

import com.sccf.api.feign.IUserFeignService;
import com.sccf.api.feign.dto.UserDto;
import com.sccf.core.commons.base.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;


@Slf4j
@Component("userFeignServiceFallback")
public class UserServiceFallbackImpl extends DefaultFallbackImpl implements IUserFeignService {

    @Override
    public RestResponse<Boolean> add(UserDto userDto) {
        log.error(String.format("调用保存用户信息接口失败%s", userDto.toString()));
        return getDefaultResponse();
    }

    @Override
    public RestResponse<Boolean> delete(String id) {
        log.error(String.format("调用删除用户信息接口失败%s", id));
        return getDefaultResponse();
    }

    @Override
    public RestResponse<Boolean> edit(UserDto userDto) {
        log.error(String.format("调用修改用户信息接口失败%s", userDto.toString()));
        return getDefaultResponse();
    }

    /**
     * 查询获得用户信息最新的版本号
     *
     * @param id
     * @return
     */
    @Override
    public RestResponse<Map<String, Integer>> getLastVersion(String id) {
        log.error(String.format("调用查询用户信息最新版本号接口失败%s", id));
        return getDefaultResponse();
    }
}
