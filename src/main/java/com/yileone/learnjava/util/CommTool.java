package com.yileone.learnjava.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: jinyuan
 * @since: 2019/11/6 16:33
 */
public class CommTool {
    public static String underlineToCamel2(String param){
        param = param.toLowerCase();//此处为全部转小写，方便根据_判定后一位转驼峰
        if (param==null||"".equals(param.trim())){
            return "";
        }
        //使用正则表达式
        StringBuilder sb=new StringBuilder(param);
        Matcher mc= Pattern.compile("_").matcher(param);
        int i=0;
        while (mc.find()){
            int position=mc.end()-(i++);
            //String.valueOf(Character.toUpperCase(sb.charAt(position)));
            sb.replace(position-1,position+1,sb.substring(position,position+1).toUpperCase());
        }
        return sb.toString();
    }
    public static Map<String, Object> toReplaceKeyLow(Map<String, Object> map) {
        Map re_map = new HashMap();
        if(re_map != null) {
            Iterator var2 = map.entrySet().iterator();

            while(var2.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry)var2.next();
                re_map.put(underlineToCamel2((String)entry.getKey()), map.get(entry.getKey()));
            }

            map.clear();
        }

        return re_map;
    }
}
