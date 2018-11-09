package com.lmeng.enums;

public enum AdminUserStatusEnum {
    //0=禁用,1=有效
    FREEZED(0, "冻结"),
    VALID(1,"有效");
    int code;
    String message;

    AdminUserStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }
}
