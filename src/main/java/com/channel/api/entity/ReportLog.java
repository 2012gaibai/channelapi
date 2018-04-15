package com.channel.api.entity;

import java.util.Date;

/**
 * Created by gq on 2018/4/11.
 */
public class ReportLog {

    private String idfa;
    private String adverterCode;
    private String appCode;
    private String clickId;
    private String callback;
    private Date reportTime;

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

    public String getClickId() {
        return clickId;
    }

    public void setClickId(String clickId) {
        this.clickId = clickId;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    @Override
    public String toString() {
        return "ReportLog{" +
                "idfa='" + idfa + '\'' +
                ", adverterCode='" + adverterCode + '\'' +
                ", appCode='" + appCode + '\'' +
                ", clickId='" + clickId + '\'' +
                ", callback='" + callback + '\'' +
                ", reportTime=" + reportTime +
                '}';
    }
}
