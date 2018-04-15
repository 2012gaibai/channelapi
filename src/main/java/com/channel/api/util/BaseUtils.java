package com.channel.api.util;

import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;


public final class BaseUtils {

    public static boolean isNotEmpty(String str) {
        return (null != str && !"".equals(str.trim()));
    }

    public static boolean isNotEmpty(List list) {
        return (null != list && list.size() > 0);
    }

    public static boolean isNotEmpty(Object str) {
        return (null != str);
    }

    public static boolean isNotEmpty(StringBuffer str) {
        return (null != str && str.length() > 0);
    }

    public static int random(int maxVal) {
        Random random = new Random();
        return random.nextInt(maxVal);
    }

    /**
     * 生成0-9的随机数
     *
     * @return
     */
    public static int random() {
        Random random = new Random();
        return random.nextInt(9);
    }

    public static String randomStrForLen(int len) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < len; i++) {
            buffer.append(random());
        }
        return buffer.toString();
    }

    /**
     * 中文
     *
     * @return
     */
    public static String encodeStr(String str) {
        try {
            return new String(str.getBytes("iso-8859-1"), "utf-8");
        } catch (Exception e) {
            return str;
        }
    }

    /**
     * 中文
     *
     * @return
     */
    public static String encodeStr(String str, String encoding) {
        try {
            return new String(str.getBytes("iso-8859-1"), encoding);
        } catch (Exception e) {
            return str;
        }
    }


    /**
     * 判断是否为整数
     *
     * @param str 传入的字符串
     * @return 是整数返回true, 否则返回false
     */
    public static boolean isInt(String str) {
        if (null == str)
            return false;
        str = str.trim();
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    public static int formatInt(String str, int def) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return def;
        }
    }

    public static long formatLong(String str, int def) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            return def;
        }
    }

    public static long formatLong(Long str, int def) {
        if (isNotEmpty(str)) {
            return str;
        } else {
            return def;
        }
    }


    public static Long formatLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer formatInt(String str, Integer def) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return def;
        }
    }

    public static Float Double(String str, Float def) {
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            return def;
        }
    }

    public static Double formatDouble(String str, Double def) {
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            return def;
        }
    }

    public static Double formatDouble(Object obj) {
        Double num = 0d;
        try {
            if (isNotEmpty(obj)) {
                BigDecimal db = (BigDecimal) obj;
                num = db.doubleValue();
            }
            return num;
        } catch (Exception e) {
            return num;
        }
    }

    public static String formatDouble(Double value, String pattern) {
        if (pattern == null) {
            pattern = "#.##";
        }
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(value);
    }

    public static Double formatDouble(Double str, Double def) {
        if (isNotEmpty(str)) {
            return str;
        }
        return def;
    }

    public static boolean isDouble(String str) {
        if (null == str)
            return false;
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }

//    /**
//     * 判断输入的字符串是否符合Email样式.
//     *
//     * @param str 传入的字符串
//     * @return 是Email样式返回true, 否则返回false
//     */
//    public static boolean isEmail(String str) {
//        if (null == str)
//            return false;
//        Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
//        return pattern.matcher(str).matches();
//    }

    /**
     * 判断输入的字符串是否为纯汉字
     *
     * @param str 传入的字符串
     * @return 如果是纯汉字返回true, 否则返回false
     */
    public static boolean isChinese(String str) {
        if (null == str)
            return false;
        Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
        return pattern.matcher(str).matches();
    }

    /**
     * 是否为空白,包括null和""
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    /**
     * 是否为空白,包括null和""
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(List str) {
        return str == null || str.size() == 0;
    }

    /**
     * 将字符转成16进制
     *
     * @return
     */
    public static String toHexString(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = "0000" + Integer.toHexString(ch);
            str = str + s4.substring(s4.length() - 4) + " ";
        }
        return str;
    }


    /**
     * 在字符串头部添加字符，使原字符串达到指定的长度
     *
     * @param source  源字符串
     * @param filling 填充字符
     * @param lastLen 填充后的总长度
     * @return 如果源字符串长度大于lastLen，返回原字符串，否则用filling填充源字符串后返回结果
     */
    public static String fillString(String source, char filling, int lastLen) {
        StringBuilder temp = new StringBuilder();
        if (source.length() < lastLen) {
            int fillLen = lastLen - source.length();
            for (int i = 0; i < fillLen; i++) {
                temp.append(filling);
            }
        }
        temp.append(source);
        return temp.toString();
    }

    /**
     * 从右边截取指定长度的字符串
     *
     * @param src 源字符串
     * @param len 长度
     * @return 截取后的字符串
     */
    public static String subStrRight(String src, int len) {
        String dest = src;
        if (src != null) {
            if (src.length() > len) {
                dest = src.substring(src.length() - len);
            }
        }

        return dest;
    }

    /**
     * 得到以pix规定的符号分割的数组
     *
     * @param str
     * @param pix
     * @return
     */
    public static String[] strToArr(String str, String pix) {
        if (null == str || "".equals(str))
            return null;
        return str.split(pix);
    }

    public static String fullByZero(int in, int len) {
        String str = Integer.toString(in);
        if (null != str) {
            while (str.length() < len) {
                str = "0" + str;
            }
        }
        return str;
    }

    public static String fullByZero(String str, int len) {
        if (null != str) {
            while (str.length() < len) {
                str = "0" + str;
            }
        }
        return str;
    }

    public static String getClassPath() {
        URL url = BaseUtils.class.getClassLoader().getResource("");
        if (null == url) {
            return "";
        }
        return url.getPath();
    }

    public static int passWordStrength(String password) {
        // 0:低，1：中，2高
        if (PatternUtils.regValidate(password, ".*[A-Za-z0-9]+.*") && PatternUtils.regValidate(password, ".*[\\W]+")) {
            return 2;
        }
        if (PatternUtils.regValidate(password, ".*[A-Za-z]+.*") && PatternUtils.regValidate(password, ".*[0-9]+.*")) {
            return 1;
        }
        if (PatternUtils.regValidate(password, "[0-9]+")) {
            return 0;
        }
        if (PatternUtils.regValidate(password, "[A-Za-z]+")) {
            return 0;
        }
        return -1;
    }

    public static String getEmailDomain(String email) {
        if (isEmpty(email)) {
            return "";
        }
        if (!validateMobile(email)) {
            return "";
        }
        String[] mailArray = email.split("@");
        if (mailArray.length != 2) {
            return "";
        }
        if (mailArray[1].equals("gmail.com")) {
            return "http://www.gmail.com";
        }

        return "http://mail." + mailArray[1];
    }

    public static String getVerifyCode(int len) {
        StringBuilder temp = new StringBuilder();
        String arr = "abcdefghijklmnopkrstuvwxyzABCDEFGHIJKLMNOPKRSTUVWXYZ0123456789";
        String[] array = arr.split("");
        while (temp.length() < len) {
            int random = random(62);
            if (isNotEmpty(array[random])) {
                temp.append(array[random]);
            }
        }
        return temp.toString();
    }

    public static String objectToString(Object obj) {
        if (isNotEmpty(obj)) {
            return obj.toString();
        }
        return "";
    }

    public static boolean validateCode(String idCode) {
        String code = idCode.trim();
        return IdCardUtils.validateCard(code);
    }

    public static boolean validateEmail(String email) {
        return PatternUtils.regValidate(email, "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    }

    public static boolean validateMobile(String mobile) {
        return PatternUtils.regValidate(mobile, "^1{1}[3|5|8]{1}\\d{9}$");
    }

    public static String formatMobile(String mobile) {
        if (isNotEmpty(mobile)) {
            if (mobile.length() == 11) {
                mobile = mobile.substring(0, 3) + "****" + mobile.substring(7, mobile.length());
            }
        }
        return mobile;
    }

    /**
     * 将一个整数字符串分解成一个整数数组 例： num=123; --> numArray[3]{1,2,3}
     *
     * @param num
     * @return
     */
    public static int[] strToIntArray(String num) {
        String[] strArray = num.trim().split("");
        int[] numArray = new int[strArray.length - 1];
        for (int i = 1; i < strArray.length; i++) {
            numArray[i - 1] = Integer.parseInt(strArray[i]);
        }
        return numArray;
    }

    /**
     * 将一个字符串分解成一个字符数组
     *
     * @param str
     * @return
     */
    public static String[] strToStrArray(String str) {
        String[] strArray = str.trim().split("");
        String[] numArray = new String[strArray.length - 1];
        System.arraycopy(strArray, 1, numArray, 0, strArray.length - 1);

//        String[] numArray = new String[strArray.length - 1];
//                for (int i = 1; i < strArray.length; i++) {
//                    numArray[i - 1] = strArray[i];
//                }
        return numArray;
    }
}
