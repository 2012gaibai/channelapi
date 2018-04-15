package com.channel.api.entity;

import java.util.Date;

/**
 * Created by gq on 2018/4/15.
 */
public class CallbackLog {
    private String idfa;
    private String adverterCode;
    private String appCode;
    private String ip;
    private String callback;
    private Integer isCall;
    private Integer isFinish;
    private Integer isBalance;
    private Date createTime;
    private Date updateTime;

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getAdverterCode() {
        return adverterCode;
    }

    public void setAdverterCode(String adverterCode) {
        this.adverterCode = adverterCode;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public Integer getIsCall() {
        return isCall;
    }

    public void setIsCall(Integer isCall) {
        this.isCall = isCall;
    }

    public Integer getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Integer isFinish) {
        this.isFinish = isFinish;
    }

    public Integer getIsBalance() {
        return isBalance;
    }

    public void setIsBalance(Integer isBalance) {
        this.isBalance = isBalance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "CallbackLog{" +
                "idfa='" + idfa + '\'' +
                ", adverterCode='" + adverterCode + '\'' +
                ", appCode='" + appCode + '\'' +
                ", ip='" + ip + '\'' +
                ", callback='" + callback + '\'' +
                ", isCall=" + isCall +
                ", isFinish=" + isFinish +
                ", isBalance=" + isBalance +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
