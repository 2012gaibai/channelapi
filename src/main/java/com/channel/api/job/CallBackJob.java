package com.channel.api.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by gq on 2018/4/15.
 */
@Component
public class CallBackJob {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());



    @Scheduled(cron = "0 0/5 * * * ? ")
    public void callback() {
        LOG.info("@Scheduled-------callback()");

    }

}
