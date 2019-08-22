package com.shop.system.common.exception;

public class CheckException extends RuntimeException {
    public CheckException(String msg) {
        super(msg);
    }

    public CheckException() {
        super();
    }
}
