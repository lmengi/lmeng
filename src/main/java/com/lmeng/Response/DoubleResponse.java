package com.lmeng.Response;

import com.lmeng.Response.base.BaseResponse;

public class DoubleResponse extends BaseResponse {
    private double result;
    public DoubleResponse() {
    }

    public double getResult() {
        return this.result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}