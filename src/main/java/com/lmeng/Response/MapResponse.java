package com.lmeng.Response;

import com.lmeng.Response.base.BaseResponse;

import java.util.Map;

public class MapResponse extends BaseResponse {
    private Map<String, Object> result;

    public MapResponse() {
    }

    public Map<String, Object> getResult() {
        return this.result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
}
