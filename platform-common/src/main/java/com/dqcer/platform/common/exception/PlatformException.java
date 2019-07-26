package com.dqcer.platform.common.exception;

/**
 * 自定义：统一异常类
 * @Author dongqin
 * @Description
 * @Date 10:14 2019/7/26
 */
public class PlatformException extends RuntimeException {

    public PlatformException() {
    }

    public PlatformException(String message) {
        super(message);
    }

    public PlatformException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlatformException(Throwable cause) {
        super(cause);
    }

    public PlatformException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
