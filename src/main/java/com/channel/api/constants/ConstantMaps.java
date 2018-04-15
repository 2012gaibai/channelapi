package com.channel.api.constants;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by gq on 2018/4/15.
 */
public class ConstantMaps {
    public static Map<String, String> appCodeMap = new HashMap<>();
    public static Map<String, String> appIdMap = new HashMap<>();

    public static Set<String> advertSets=new HashSet<>();

    static {
        appCodeMap.put("ele","com.ele");

        appIdMap.put("com.ele","ele");

        advertSets.add("ppApp_1374");
        advertSets.add("xyApp_8739");
        advertSets.add("haimaApp_2349");
    }

    public static String getAppId(String code){
        if(appCodeMap.containsKey(code)){
            return appCodeMap.get(code);
        }
        return null;
    }

    public static String getAppCode(String appId){
        if(appIdMap.containsKey(appId)){
            return appIdMap.get(appId);
        }
        return null;
    }
}
