package com.channel.api.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: lfx(robo) DateTime: 14-12-10下午3:31
 */
public class ThreadPoolHelper {
    private Integer poolSize;// default Runtime.getRuntime().availableProcessors() * 2
    private ExecutorService executorService;

    public ThreadPoolHelper(int poolSize) {
        this.poolSize = poolSize;
    }

    public ThreadPoolHelper() {

    }

    public void destroy() {
        if (null != executorService && !executorService.isShutdown()) {
            executorService.shutdown();
        }
    }

    public void init() {
        if (null == executorService) {
            if(poolSize == null){
                poolSize = Runtime.getRuntime().availableProcessors() * 2;
            }
            executorService = Executors.newFixedThreadPool(poolSize);
        }
    }

    public Integer getPoolSize() {
        return poolSize;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

}
