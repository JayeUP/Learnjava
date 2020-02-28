package com.yileone.learnjava.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneUtil {

    /** 手机号正则 */
    private static final String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9|0]))\\d{8}$";

    /** 手机号长度 */
    private static final int PHONE_LENGTH = 11;

    public static boolean isPhone(String phone) {

        if (StringUtils.isBlank(phone)) {
            return false;
        }

        if (phone.length() != PHONE_LENGTH) {
            return false;
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);

        return m.matches();

    }
}
