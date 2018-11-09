package com.lmeng.Response;

import com.lmeng.Response.base.BaseResponse;

import java.util.List;

public class ListResponse<T> extends BaseResponse {
    private List<T> result;

    public ListResponse() {
    }

    public List<T> getResult() {
        return this.result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
