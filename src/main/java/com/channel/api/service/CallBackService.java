package com.channel.api.service;

import com.channel.api.entity.CallbackLog;

import java.util.Date;
import java.util.List;

/**
 * Created by gq on 2018/4/15.
 */
public interface CallBackService {

    List<CallbackLog> findList(CallbackLog log,Date startTime, Date endTime,int offset,int limit);

    int updateStatus(CallbackLog callbackLog);
}
