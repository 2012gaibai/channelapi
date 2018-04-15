package com.channel.api.util;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: lfx(robo) DateTime: 14-9-16下午4:30
 */
public class SpringServerHelper {
    static Logger logger = Logger.getLogger(SpringServerHelper.class);

    public static void main(String[] args) {
        logger.info("准备启动!");
        try {
            if (SpringUtils.getBean("springUtils") != null) {
                logger.info("准备失败!");
                throw new IllegalStateException("已有一个实例正在执行");
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
        logger.info("启动中!");
        ApplicationContext cx = new ClassPathXmlApplicationContext("classpath:config/spring/applicationContext.xml");
        logger.info("启动成功!");

    }
}
