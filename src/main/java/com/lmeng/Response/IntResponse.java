package com.lmeng.Response;

import com.lmeng.Response.base.BaseResponse;

public class IntResponse extends BaseResponse {
    private int result;

    public IntResponse() {
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
