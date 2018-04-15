package com.channel.api.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by gq on 2018/4/13.
 */
public class ReportLogForm {

    @NotEmpty
    private String idfa;
    @NotEmpty
    private String ref;
    @NotEmpty
    private String callback;
    @NotEmpty
    private String appid;
    private String ip;

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
