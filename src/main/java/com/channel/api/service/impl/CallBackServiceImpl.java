package com.channel.api.service.impl;

import com.channel.api.dao.CallbackDao;
import com.channel.api.entity.CallbackLog;
import com.channel.api.service.CallBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by gq on 2018/4/15.
 */
@Service
public class CallBackServiceImpl implements CallBackService {
    @Autowired
    private CallbackDao callbackDao;

    @Override
    public List<CallbackLog> findList(CallbackLog log, Date startTime, Date endTime, int offset, int limit) {
        return callbackDao.findList(log,startTime,endTime,offset,limit);
    }

    @Override
    public int updateStatus(CallbackLog callbackLog) {
        return callbackDao.updateStatus(callbackLog);
    }
}
