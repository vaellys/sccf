package com.sccf.core.commons.exception;

/**
 * @author qianguobing
 * @date 2018-09-12 18:27
 */
public class NotFoundException extends SccfException {
    public NotFoundException(Throwable e) {
        super(e);
    }

    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException(String msg, Throwable exp) {
        super(msg, exp);
    }
}
