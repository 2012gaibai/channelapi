package com.channel.api.dao;

import com.channel.api.entity.CallbackLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by gq on 2018/4/15.
 */
public interface CallbackDao {

    List<CallbackLog> findList(@Param("log") CallbackLog log, @Param("startTime") Date startTime,@Param("endTime") Date endTime,@Param("offset") int offset, @Param("limit") int limit);

    int updateStatus(CallbackLog callbackLog);

}
