package com.sccf.core.commons.base;

import org.springframework.http.HttpStatus;

/**
 * @author qianguobing
 * @date 2018-09-18 08:59
 */
public abstract class RestBaseController {

    protected <T> RestResponse<T> wrap(T obj) {
        RestResponse rr = new RestResponse();
        rr.setStatus(HttpStatus.OK.value());
        rr.setMessage(HttpStatus.OK.getReasonPhrase());
        rr.setResult(obj);
        return rr;
    }

    protected <T> RestResponse<T> wrap(HttpStatus status, String message) {
        RestResponse rr = new RestResponse();
        rr.setStatus(status.value());
        rr.setMessage(message);
        return rr;
    }

    protected <T> RestResponse<T> wrap(HttpStatus status, String message, T result) {
        RestResponse rr = new RestResponse();
        rr.setStatus(status.value());
        rr.setMessage(message);
        rr.setResult(result);
        return rr;
    }

}
