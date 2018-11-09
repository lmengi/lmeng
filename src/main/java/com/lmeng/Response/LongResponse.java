package com.lmeng.Response;

import com.lmeng.Response.base.BaseResponse;

public class LongResponse extends BaseResponse {
    private long result;

    public LongResponse() {
    }

    public long getResult() {
        return this.result;
    }

    public void setResult(long result) {
        this.result = result;
    }
}

