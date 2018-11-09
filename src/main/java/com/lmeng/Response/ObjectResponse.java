package com.lmeng.Response;

import com.lmeng.Response.base.BaseResponse;

public class ObjectResponse<T> extends BaseResponse {
    protected T result;

    public ObjectResponse() {
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}

