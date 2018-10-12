package com.sccf.api.feign.exception;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.Response;
import feign.Util;

import java.io.IOException;

public class FeignErrorException extends HystrixBadRequestException {

    private int status;

    public FeignErrorException(int status, String message) {
        super(message);
        this.status = status;
    }

    public static FeignErrorException errorStatus(String methodKey, Response response) {
        String message = "";
        try {
            if (response.body() != null)
                message = Util.toString(response.body().asReader());
        } catch (IOException localIOException) {
        }
        return new FeignErrorException(response.status(), message);
    }

    public int status() {
        return this.status;
    }
}
