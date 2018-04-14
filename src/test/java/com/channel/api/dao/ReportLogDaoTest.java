package com.channel.api.dao;

import com.channel.api.entity.ReportLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by gq on 2018/4/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring/spring-dao.xml")
public class ReportLogDaoTest {

    @Autowired
    private ReportLogDao reportLogDao;

    @Test
    public void queryAll() throws Exception {
        List<ReportLog> list=reportLogDao.queryAll(0, 100);
        for (ReportLog goods : list) {
            System.out.println(goods);
        }
        System.out.println("--------------------------");
    }

    @Test
    public void insert() throws Exception{
        ReportLog log=new ReportLog();
        log.setIdfa("dasdas");
        log.setAppCode("qdqwd");
        log.setClickId("sdcdsv");
        log.setAdverterCode("dsvdsv");
        log.setReportTime(new Date());
        try {
            int i=reportLogDao.insert(log);
            System.out.println("======="+i);
        }catch (DuplicateKeyException e){
            System.out.println("主键冲突");
        }

    }

}