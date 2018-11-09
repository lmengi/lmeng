package com.lmeng.exception;

public class LmException extends RuntimeException {
    private Integer code;

    private String message;

    public LmException(LmServiceException lm) {
        this.code = lm.getCode();
        this.message = lm.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
