package com.lmeng.Response;

import com.lmeng.Response.base.BaseResponse;

public class StringResponse extends BaseResponse {
    private String result;

    public StringResponse() {
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

