package com.sccf.common.handler;

import com.sccf.api.feign.exception.FeignErrorException;
import com.sccf.core.commons.base.RestBaseController;
import com.sccf.core.commons.base.RestResponse;
import com.sccf.core.commons.exception.ForbiddenException;
import com.sccf.core.commons.exception.InvalidRequestFieldsException;
import com.sccf.core.commons.exception.NotFoundException;
import com.sccf.core.commons.exception.UnauthorizedException;
import feign.FeignException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author qianguobing
 * @date 2018-09-15 15:41
 */
@Order(Integer.MIN_VALUE)
@ControllerAdvice
public class RestExceptionHandler extends RestBaseController {

    @ExceptionHandler({FeignException.class})
    @ResponseBody
    public RestResponse handleFeignException(FeignException e) {
        return wrap(HttpStatus.valueOf(e.status()), e.getMessage());
    }

    @ExceptionHandler({FeignErrorException.class})
    @ResponseBody
    public RestResponse handleFeignErrorException(FeignErrorException e) {
        return wrap(HttpStatus.valueOf(e.status()), e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public RestResponse handleException(Exception e) {
        HttpStatus httpStatus;
        if ((e instanceof InvalidRequestFieldsException)) {
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            if ((e instanceof UnauthorizedException)) {
                httpStatus = HttpStatus.UNAUTHORIZED;
            } else {
                if ((e instanceof ForbiddenException)) {
                    httpStatus = HttpStatus.FORBIDDEN;
                } else {
                    if ((e instanceof NotFoundException)) {
                        httpStatus = HttpStatus.NOT_FOUND;
                    } else
                        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                }
            }
        }
        return wrap(httpStatus, e.getMessage());
    }
}
