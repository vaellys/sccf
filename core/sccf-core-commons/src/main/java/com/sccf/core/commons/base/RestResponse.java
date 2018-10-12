package com.sccf.core.commons.base;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author qianguobing
 * @date 2018-09-18 08:54
 */
public class RestResponse<T> implements Serializable {

    private static final long serialVersionUID = 4365194255638955813L;

    private int status = HttpStatus.OK.value();
    private String message = HttpStatus.OK.getReasonPhrase();
    private T result;

    public int getStatus()
    {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
