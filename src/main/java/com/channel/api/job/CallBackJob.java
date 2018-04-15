package com.channel.api.job;

import com.channel.api.constants.Constants;
import com.channel.api.entity.CallbackLog;
import com.channel.api.handler.CallBackHandler;
import com.channel.api.service.CallBackService;
import com.channel.api.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by gq on 2018/4/15.
 */
@Component
public class CallBackJob {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CallBackHandler handler;
    @Autowired
    private CallBackService callBackService;


    public void callback() {
        LOG.info("@Scheduled-------callback()--start");
        Date start = DateUtils.dayBefore2Date(-1);
        Date end = new Date();
        CallbackLog log = new CallbackLog();
        log.setIsBalance(1);
        log.setIsCall(0);

        while (true) {

            List<CallbackLog> list = callBackService.findList(log, start, end, 0, 20);
            if (CollectionUtils.isEmpty(list)) {
                LOG.info("@Scheduled======callback is empty===end");
                return;
            }

            for (CallbackLog item : list) {
                String result = handler.callBack(item.getCallback());

                CallbackLog param = new CallbackLog();
                param.setIdfa(item.getIdfa());
                param.setAppCode(item.getAppCode());
                param.setIsBalance(1);
                param.setUpdateTime(new Date());
                param.setIsCall(1);
                param.setIsFinish(Constants.CALL_BACK_SUC.equals(result) ? 1 : 0);
                try {
                    callBackService.updateStatus(param);
                }catch (Exception e){
                    LOG.error("===更新回调记录异常");
                    return;
                }
            }
        }

    }

}
