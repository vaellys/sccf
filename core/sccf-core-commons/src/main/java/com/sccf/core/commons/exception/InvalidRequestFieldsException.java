package com.sccf.core.commons.exception;

/**
 * @author qianguobing
 * @date 2018-09-15 15:58
 */
public class InvalidRequestFieldsException  extends SccfException {
    public InvalidRequestFieldsException(Throwable e)
    {
        super(e);
    }

    public InvalidRequestFieldsException(String msg) {
        super(msg);
    }

    public InvalidRequestFieldsException(String msg, Throwable exp) {
        super(msg, exp);
    }
}
