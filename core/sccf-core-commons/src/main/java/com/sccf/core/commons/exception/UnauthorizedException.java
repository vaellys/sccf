package com.sccf.core.commons.exception;

/**
 * @author qianguobing
 * @date 2018-09-12 18:29
 */
public class UnauthorizedException extends SccfException {
    public UnauthorizedException() {
        super("未经授权或授权过期");
    }

    public UnauthorizedException(Throwable e) {
        super(e);
    }

    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException(String msg, Throwable exp) {
        super(msg, exp);

    }
}
