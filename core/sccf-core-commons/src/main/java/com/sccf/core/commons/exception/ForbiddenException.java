package com.sccf.core.commons.exception;

/**
 * @author qianguobing
 * @date 2018-09-15 15:59
 */
public class ForbiddenException extends SccfException {

    public ForbiddenException()
    {
        super("您没有权限进行当前操作");
    }

    public ForbiddenException(Throwable e) {
        super(e);
    }

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }
}
