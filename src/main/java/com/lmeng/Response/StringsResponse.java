package com.lmeng.Response;

import com.lmeng.Response.base.BaseResponse;

import java.util.List;

public class StringsResponse extends BaseResponse {
    private List<String> result;

    public StringsResponse() {
    }

    public List<String> getResult() {
        return this.result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

}

