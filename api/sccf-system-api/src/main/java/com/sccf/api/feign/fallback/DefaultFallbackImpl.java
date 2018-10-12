package com.sccf.api.feign.fallback;

import com.sccf.core.commons.base.RestBaseController;
import com.sccf.core.commons.base.RestResponse;
import org.springframework.http.HttpStatus;

/**
 * @author qianguobing
 * @date 2018-09-12 18:59
 */
public class DefaultFallbackImpl extends RestBaseController {

    protected <T> RestResponse<T> getDefaultResponse() {
        return wrap(HttpStatus.SERVICE_UNAVAILABLE, null);
    }
}
