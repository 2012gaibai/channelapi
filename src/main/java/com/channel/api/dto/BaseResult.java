package com.channel.api.dto;

import com.channel.api.enums.ErrorCode;

import java.io.Serializable;

/**
 * Created by gq on 2018/4/11.
 */
public class BaseResult<T> implements Serializable{
    private int code;
    private String msg;
    private T data;

    public BaseResult() {
    }

    public BaseResult(int code) {
        this.code = code;
        this.msg = ErrorCode.get(code).getMsg();
    }

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResult(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
