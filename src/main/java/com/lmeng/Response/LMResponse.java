package com.lmeng.Response;

import com.lmeng.Response.base.BaseResponse;
import com.lmeng.utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

public class LMResponse extends BaseResponse {

    private static final Map<?,?> emptyMap = new HashMap();
    private Object result;

    public LMResponse() {
        this.timestamp = System.currentTimeMillis();
    }

    public LMResponse(boolean success, String code, String message, Object result) {
        this();
        this.success = success;
        this.code = code;
        this.message = message;
        if(result == null) {
            result = emptyMap;
        } else if(result instanceof String && (result == null || "".equals((String)result))) {
            result = emptyMap;
        }

        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String debugName() {
        return JsonUtils.toJson(this, true);
    }
}
