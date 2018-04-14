package com.channel.api.dao;

import com.channel.api.entity.ReportLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by gq on 2018/4/11.
 */
public interface ReportLogDao {

    int insert(ReportLog log);

    List<ReportLog> queryAll(@Param("offset") int offset, @Param("limit") int limit);

}
