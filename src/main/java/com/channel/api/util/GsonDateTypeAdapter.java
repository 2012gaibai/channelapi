package com.channel.api.util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gan on 2016/8/18.
 * 日期适配器
 */
public class GsonDateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

    private final DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Date date;
        String str = jsonElement.getAsString();
        if (!"".equals(str)) {
            try {
                date = format.parse(str);
            } catch (ParseException e) {
                throw new JsonParseException(e);
            }
        } else {
            date = new Date();
        }
        return date;
    }

    @Override
    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        String dfStr = format.format(new Date(date.getTime()));
        return new JsonPrimitive(dfStr);
    }
}
