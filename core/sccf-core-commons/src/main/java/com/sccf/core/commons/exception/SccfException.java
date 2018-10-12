package com.sccf.core.commons.exception;

/**
 * @author qianguobing
 * @date 2018-09-12 18:28
 */
public class SccfException extends RuntimeException {
    public SccfException(Throwable e) {
        super(e);
    }

    public SccfException(String message) {
        super(message);
    }

    public SccfException(String message, Throwable cause) {
        super(message, cause);
    }
}
