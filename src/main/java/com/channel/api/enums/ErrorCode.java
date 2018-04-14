package com.channel.api.enums;

/**
 * User:甘琪 DateTime: 2016/4/22.
 */
public enum ErrorCode {
    E200(200, "操作成功"),
    E500(500, "系统错误");

    private int code;
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ErrorCode get(int code) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.getCode()==code)
                return errorCode;
        }
        return E500;
    }
}
