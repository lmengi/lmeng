package com.lmeng.enums;

public enum  RoleTypeEnum {
    //0=普通用户,1=管理员
    USER(0, "user"),
    ADMIN(1,"admin");
    Integer code;
    String message;

    RoleTypeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
