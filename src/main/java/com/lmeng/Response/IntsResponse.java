package com.lmeng.Response;

import com.lmeng.Response.base.BaseResponse;

import java.util.List;

public class IntsResponse extends BaseResponse {
    private List<Integer> result;

    public IntsResponse() {
    }

    public List<Integer> getResult() {
        return this.result;
    }

    public void setResult(List<Integer> result) {
        this.result = result;
    }
}
