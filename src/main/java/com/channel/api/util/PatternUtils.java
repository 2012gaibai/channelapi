package com.channel.api.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PatternUtils {
    public static boolean regValidate(String Content, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Content);
        return matcher.matches();
    }


    public static List<String> regFinds(String Content, String regex) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Content);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    public static String regFind(String Content, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Content);
        matcher.find();
        return matcher.group();
    }

    public static String regFind(String Content, String regex, int index) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Content);
        matcher.find();
        return matcher.group(index);
    }

    public static String regReplace(String Content, String regex, String regStr) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Content);
        return matcher.replaceAll(regStr);
    }


}
