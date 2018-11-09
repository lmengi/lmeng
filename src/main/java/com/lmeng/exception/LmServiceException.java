package com.lmeng.exception;

public interface LmServiceException {
    /**
     * 获取异常编码
     */
    Integer getCode();

    /**
     * 获取异常信息
     */
    String getMessage();
}
