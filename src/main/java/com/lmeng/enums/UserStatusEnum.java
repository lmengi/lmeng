package com.lmeng.enums;

public enum UserStatusEnum {

   //0=假删,1=禁用,2=游客,3=注册用户
   DELETED(0, "删除"),
    FREEZED(1, "冻结"),
    VISITOR(2, "游客"),
    REGISTER(3, "注册用户"),;

    int code;
    String message;

    UserStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
