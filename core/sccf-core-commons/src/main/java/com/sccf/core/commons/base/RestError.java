package com.sccf.core.commons.base;

/**
 * @author qianguobing
 * @date 2018-09-15 15:42
 */
public class RestError {
    String message;

    RestError(String message)
    {
        this.message = message; }
    public static RestErrorBuilder builder() { return new RestErrorBuilder(); }
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message)
    {
        this.message = message; }
    public static class RestErrorBuilder { private String message;

        public RestErrorBuilder message(String message) { this.message = message; return this; }
        public RestError build() { return new RestError(this.message); }
        public String toString() { return "RestError.RestErrorBuilder(message=" + this.message + ")"; }

    }
}
