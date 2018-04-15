package com.channel.api.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * Created by gan on 2016/8/18.
 */
public class GsonUtils {

    private final static Gson gson;

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new GsonDateTypeAdapter())
                .serializeNulls();

        gson = builder.create();
    }

    public static <T> T jsonToPojo(String json, Class<T> c) {
        return gson.fromJson(json, c);
    }

    public static String pojoToJson(Object obj) {
        String json = gson.toJson(obj);
        json = StringUtils.replace(json, "null", "\"\"");
        return json;
    }


}
