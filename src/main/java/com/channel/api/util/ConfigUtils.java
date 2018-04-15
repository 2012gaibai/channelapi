package com.channel.api.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * User: lfx(robo) DateTime: 14-9-3上午11:49
 */
public final class ConfigUtils {
    private static Map<String, String> map = new HashMap<>();

    static {
        forInstance();
    }

    public static void forInstance() {
        try {
            Properties properties = new Properties();
            InputStream inputStream = ConfigUtils.class.getResourceAsStream("/config/properties/config.properties");
            properties.load(new BufferedReader(new InputStreamReader(inputStream, "UTF-8")));
            Enumeration all = properties.keys();
            while (all.hasMoreElements()) {
                String name = (String) all.nextElement();
                String value = (String) properties.get(name);
                map.put(name, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static String getValue(String key) {
        if (map.containsKey(key)) {
            return map.get(key).trim();
        }
        throw new IllegalArgumentException("属性值（" + key + "）不存在");
    }

    public static String getValueNe(String key) {
        if (map.containsKey(key)) {
            return map.get(key).trim();
        }
          return null;
    }

    public static void update(String key, String value) {
        if (map.containsKey(key)) {
            map.put(key, value);
        }
    }

}
