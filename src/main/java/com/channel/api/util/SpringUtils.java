package com.channel.api.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * User: lfx(robo) DateTime: 14-9-3下午2:34 QQ: 314231612
 */
@Component
public final class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static Object getBean(String name) {
        Object object;
        try {
            object = context.getBean(name);
        } catch (Exception e) {
            throw new IllegalArgumentException("get Bean error!name=" + name);
        }
        return object;
    }
}
