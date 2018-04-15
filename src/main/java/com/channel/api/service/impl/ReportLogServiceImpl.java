package com.channel.api.service.impl;

import com.channel.api.dao.ReportLogDao;
import com.channel.api.entity.ReportLog;
import com.channel.api.service.ReportLogService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;


/**
 * Created by gq on 2018/4/13.
 * 上报
 */
@Service
public class ReportLogServiceImpl implements ReportLogService {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private ReportLogDao reportLogDao;

    @Override
    public int insert(ReportLog log) {
        int count;
        try {
            count=reportLogDao.insert(log,"report_log");
        } catch(DuplicateKeyException e){
            LOG.error("主键冲突:"+log.toString());
            return 0;
        } catch (Exception e){
            LOG.error("保存失败:"+log.toString(),e);
            return 0;
        }
        return count;
    }

}
