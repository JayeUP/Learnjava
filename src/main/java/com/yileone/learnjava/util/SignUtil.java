package com.yileone.learnjava.util;

import cn.hutool.json.JSONUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 商户签名工具
 */
public class SignUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger( SignUtil.class );

    public static String zjSign(Map params, String skey, List<String> keyList) {
        keyList.add( "skey" );
        Collections.sort( keyList );
        String content = "";
        for (int i = 0; i < keyList.size(); i++) {
            String key = keyList.get( i );
            if (key.equals( "skey" )) {
                content = content + skey;
            } else {
                content = content + params.get( key );
            }
        }
        String sign = MD5Util.getMD5String( content ).toLowerCase();
        LOGGER.info( "校验签名:params:{}", params );
        LOGGER.info( "校验签名:content:{}", content );
        LOGGER.info( "校验签名:sign:{}", sign );
        return sign;
    }

    public static String sign(Map params, String appSecret) {
        HashMap<Object, Object> data = new HashMap<>(params.size() + 1, 1);
        data.putAll(params);
        data.put("appSecret", appSecret);

        TreeMap treeMap = new TreeMap<>(data);
        String content = StringUtils.join(treeMap.values(), null);
        String sign = MD5Util.getMD5String(content).toLowerCase();
        LOGGER.info("校验签名:params:{}", params);
        LOGGER.info("校验签名:content:{}", content);
        LOGGER.info("校验签名:sign:{}", sign);
        return sign;
    }


    public static String powersearchSign(Map params, String appSecret) {
        params.putAll(params);
        List<String> keyList = new ArrayList<>();

        for (Object key : params.keySet()) {
            keyList.add( key + "" );
        }
        keyList.add( "appSecret" );
        Collections.sort( keyList );
        String content = "";
        for (int i = 0; i < keyList.size(); i++) {
            String key = keyList.get( i );
            if (key.equals( "appSecret" )) {
                content = content + appSecret;
            } else {
                content = content + params.get( key );
            }
        }

        String sign = MD5Util.getMD5String( content ).toLowerCase();
        LOGGER.info( "校验签名:params:{}", params );
        LOGGER.info( "校验签名:content:{}", content );
        LOGGER.info( "校验签名:sign:{}", sign );
        return sign;
    }


    public static boolean elemeCheckSign(Map params, String publicKeyBase64, String sign) throws Exception {
        List<String> keyList = new ArrayList<>();
        for (Object key : params.keySet()) {
            keyList.add( key + "" );
        }
        Collections.sort( keyList );
        String content = "";
        for (int i = 0; i < keyList.size(); i++) {
            String key = keyList.get( i );
            if (i == 0) {
                content = key + "=" + params.get( key );
            } else {
                content += "&" + key + "=" + params.get( key );
            }
        }
        Map paramsCheck = new HashMap();

        paramsCheck.put( "sign_type", "RSA2" );
        paramsCheck.put( "content", content );
        paramsCheck.put( "sign", sign );
        paramsCheck.put( "publicKey", publicKeyBase64 );
        paramsCheck.put( "charset", "UTF-8" );
        boolean res = RSA.rsaCheck( paramsCheck, sign );
        LOGGER.info( "饿了么验签结果:{},参数:{}", res, JSONUtil.toJsonStr( params ) );
        return res;
    }

    public static final String elemeSign(Map params, String usPrivateKey) throws Exception {
        Set keys = params.keySet();
        Iterator<String> keysSet = keys.iterator();
        String keyJoinSign = "";
        while (keysSet.hasNext()) {
            String key = keysSet.next();
            if (StringUtils.isBlank( keyJoinSign )) {
                keyJoinSign += key;
            } else {
                keyJoinSign += "," + key;
            }
        }
        params.put( "sign_type", "RSA2" );
        params.put( "privateKey", usPrivateKey );
        params.put( "charset", "UTF-8" );
        params.put( "sign_param", keyJoinSign );
        String sign = RSA.rsaSign( params );
        LOGGER.info( "eleme sign res :{},参数:{}", sign, JSONUtil.toJsonStr( params ) );
        return sign;
    }

    public static void main(String[] args) {
        Map params = new HashMap();
        String appId = "73b09fcc444a4520a9741d37e93f9890";
        String appSecret = "9bc045ffa0f84ce3ae7ed5a120b72206";
        params.put( "appId", appId );
//        params.put( "appSecret", appSecret );
        params.put( "tel", "17858511591" );
//        params.put( "actId","545706935" );
//        params.put( "type","2" );


        String sign = sign( params, appSecret );
        powersearchSign( params, appSecret );
        System.out.println( sign );
    }

}
