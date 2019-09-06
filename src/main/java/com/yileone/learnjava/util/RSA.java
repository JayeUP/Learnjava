package com.yileone.learnjava.util;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;
import org.apache.commons.codec.binary.Base64;

public class RSA {

    private static final String SIGN_TYPE_RSA = "RSA";

    private static final String SIGN_TYPE_RSA2 = "RSA2";

    private static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    private static final String SIGN_SHA256RSA_ALGORITHMS = "SHA256WithRSA";

    private static final int DEFAULT_BUFFER_SIZE = 8192;



    public static void main(String[] args) throws Exception {
        Map map = new HashMap();
        map.put( "sign_type", "RSA2" );
        map.put( "privateKey",
                "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCv733a7rMhJjRw6cnVLz9bt3/YCcSsgJzw2LA2NINDsD/li694ExJT9xUj9iwHOWdPA4KVZmWTsye9a/5RP3p8O+WfxxTzqaMdC9" +
                        "/K3GhQMIG2FgBpxXT2VXZEspoX3xd26DlfGZgVpWBZoIz4PdaIdsiNAUY6tnu745T9wUd8wFzWo3ngs3udfFPXRlDiik9Wu7qAF30rC6eOiZ3EqnltYRwd3Fzgh4p5EU6l1s" +
                        "/zHLY58Y2DjXIF6nGSKjpQvHYHqpx7oM/UQmKpFGwcNsnZ7wgP7zGNDUMvLlaq9+Kz+gyJf5iKqMG05RlklQZ9/OOJJjaUhUt7q" +
                        "+WqW2VscHRvAgMBAAECggEAYFbldPBG2L0h9D6hDgLsT93gvL1EnC1lQyF1BImm43bs1layRC81VxMy2Vlg7KfLYWILrKHAt6tf9ILhZT48ZTErYV3TpEXdEvfAmUYuPNMDBGFx4nmEvas4sw+V/8JjB" +
                        "/LMD75lIF1JsGqRJxI9msZotYXgHiB1CwLpQDcJXU7UJmmVdm1ZFw9udyS3BB0AcuMa79IVFqZw3riBfeDoy4o4NvejFZXXomqw3m+VhANhaoBEqopFyV5RDmCRIcpcUR" +
                        "/tvKD8djSJfxZaOm5c2ZqvMgqhvAjHzkLRoI79vi/F/Oo6RekIiBDkb3Ju5DgY3U0cLlaDuOjwZM37kJz00QKBgQDdTjsYP+2NQKUk6eGEg1x" +
                        "+jd1zlIWdrmTXIU2MYku7VnsPq0Gd0vi320DCRVXWGtv8tHmmvvBs/1OaD4XxMlM8yRQcz3UvtBJoH4TKp6RsKO2Pak8IhMSWbBsEuow1xoQ95c1jL3pBStRXw6DNUxzLCtCzQlo2OrARMKtfE" +
                        "/NAyQKBgQDLhGaOWuFmBjUkXZo6JLLJhDJ9QbFEp/oLTjODaRnru8hEm8BnWE92HU81cnvwpwvyrtZ56YId6sZkBzpK21hwDgrrIK0/alyQr5y7kMX9N9qJvaU2X9gNYLxVvujhbcubkqq7LgDD" +
                        "/UFPf1WxbTIUlrAgXKDQXNIwhyOBpN0fdwKBgFza+Dyihh/gYeptH6ykGWkYSTS3uqCAjdseJBWlILWIAbZ/WtbHsIgkPLXGtc9SEb+kUe6" +
                        "+6s4xC3j2znJ3dSlqDUBRY5ASdC6wGt2VHY4sVhD4wBSI8JtU3LlNNItTsiTuiRD22MsQhKwWbx/3oXsoHI06Z/OdCEcOLrmD" +
                        "+2rRAoGBALPs9g5c4nEkg88GwdctorLuIQUEEwizySg9luVTAgubFM8zM8MqG/Y8q06BTHnR9Yo0cIGPo+13JrZAfZS4n1NR1u1RElnCWtu/pj1dHO1ld9vWwj10Nrp9D4RvJ8xFGYENBcw" +
                        "+O4cKW7dAyC34cBIrtsKlobcUmO82SnnPm365AoGACBILq+wvlmcb2KtUGKccemCFztgxW0t7bZ3siPBRab+zJfrtar0u1HuxAWvs/L2VMeZLxS4KE/lMJGR0+E+PERDJjqa155" +
                        "/x5VO6ksBaAXsh81F331f6oFvdprvNW8AcO2rgkOTZ7Av48bljceLBo8PcV7j0WlxlZOLHJnOFmhM=" );
        map.put( "charset", "UTF-8" );
        map.put( "a", "1" );
        map.put( "b", "2" );
        map.put( "sign_param", "a,b" );
        String sign = rsaSign( map );
        Map map1 = new HashMap();

        String content = "a=1&b=2";

        map1.put( "sign_type", "RSA2" );
        map1.put( "content", content );
        map1.put( "sign", sign );
        map1.put( "publicKey", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAr+992u6zISY0cOnJ1S8/W7d/2AnErICc8NiwNjSDQ7A/5YuveBMSU/cVI/YsBzlnTwOClWZlk7MnvWv" +
                "+UT96fDvln8cU86mjHQvfytxoUDCBthYAacV09lV2RLKaF98Xdug5XxmYFaVgWaCM+D3WiHbIjQFGOrZ7u+OU" +
                "/cFHfMBc1qN54LN7nXxT10ZQ4opPVru6gBd9KwunjomdxKp5bWEcHdxc4IeKeRFOpdbP8xy2OfGNg41yBepxkio6ULx2B6qce6DP1EJiqRRsHDbJ2e8ID+8xjQ1DLy5Wqvfis/oMiX" +
                "+YiqjBtOUZZJUGffzjiSY2lIVLe6vlqltlbHB0bwIDAQAB" );
        map1.put( "charset", "UTF-8" );
        boolean res = rsaCheck( map1, sign );
    }

    /**
     * RSA/RSA2 生成签名
     *
     * @param map 包含 sign_type、privateKey、charset
     *
     * @return
     *
     * @throws Exception
     */
    public static String rsaSign(Map map) throws Exception {
        PrivateKey priKey = null;
        java.security.Signature signature = null;
        String signType = map.get( "sign_type" ).toString();
        String privateKey = map.get( "privateKey" ).toString();
        String charset = map.get( "charset" ).toString();
        String content = getSignContent( map );
        map.put( "content", content );
        System.out.println( "请求参数生成的字符串为:" + content );
        if (SIGN_TYPE_RSA.equals( signType )) {
            priKey = getPrivateKeyFromPKCS8( SIGN_TYPE_RSA, new ByteArrayInputStream( privateKey.getBytes() ) );
            signature = java.security.Signature.getInstance( SIGN_ALGORITHMS );
        } else if (SIGN_TYPE_RSA2.equals( signType )) {
            priKey = getPrivateKeyFromPKCS8( SIGN_TYPE_RSA, new ByteArrayInputStream( privateKey.getBytes() ) );
            signature = java.security.Signature.getInstance( SIGN_SHA256RSA_ALGORITHMS );
        } else {
            throw new Exception( "不是支持的签名类型 : : signType=" + signType );
        }
        signature.initSign( priKey );

        if (StringUtils.isEmpty( charset )) {
            signature.update( content.getBytes() );
        } else {
            signature.update( content.getBytes( charset ) );
        }

        byte[] signed = signature.sign();

        return new String( Base64.encodeBase64( signed ) );
    }

    /**
     * 验签方法
     *
     * @param content 参数的合成字符串格式: key1=value1&key2=value2&key3=value3...
     * @param sign
     * @param publicKey
     * @param charset
     * @param signType
     *
     * @return
     */

    public static boolean rsaCheck(Map map, String sign) throws Exception {
        java.security.Signature signature = null;
        String signType = map.get( "sign_type" ).toString();
        String charset = map.get( "charset" ).toString();
        String content = map.get( "content" ).toString();
        String publicKey = map.get( "publicKey" ).toString();
        System.out.println( ">>验证的签名为:" + sign );
        System.out.println( ">>生成签名的参数为:" + content );
        PublicKey pubKey = getPublicKeyFromX509( "RSA", new ByteArrayInputStream( publicKey.getBytes() ) );
        if (SIGN_TYPE_RSA.equals( signType )) {
            signature = java.security.Signature.getInstance( SIGN_ALGORITHMS );
        } else if (SIGN_TYPE_RSA2.equals( signType )) {
            signature = java.security.Signature.getInstance( SIGN_SHA256RSA_ALGORITHMS );
        } else {
            throw new Exception( "不是支持的签名类型 : signType=" + signType );
        }
        signature.initVerify( pubKey );

        if (StringUtils.isEmpty( charset )) {
            signature.update( content.getBytes() );
        } else {
            signature.update( content.getBytes( charset ) );
        }

        return signature.verify( Base64.decodeBase64( sign.getBytes() ) );
    }

    public static PrivateKey getPrivateKeyFromPKCS8(String algorithm, InputStream ins) throws Exception {
        if (ins == null || StringUtils.isEmpty( algorithm )) {
            return null;
        }

        KeyFactory keyFactory = KeyFactory.getInstance( algorithm );

        byte[] encodedKey = readText( ins ).getBytes();

        encodedKey = Base64.decodeBase64( encodedKey );

        return keyFactory.generatePrivate( new PKCS8EncodedKeySpec( encodedKey ) );
    }

    public static PublicKey getPublicKeyFromX509(String algorithm, InputStream ins) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance( algorithm );

        StringWriter writer = new StringWriter();
        io( new InputStreamReader( ins ), writer, -1 );

        byte[] encodedKey = writer.toString().getBytes();

        encodedKey = Base64.decodeBase64( encodedKey );

        return keyFactory.generatePublic( new X509EncodedKeySpec( encodedKey ) );
    }

    /**
     * 把参数合成成字符串
     *
     * @param sortedParams
     *
     * @return
     */
    public static String getSignContent(Map<String, String> sortedParams) {
        StringBuffer content = new StringBuffer();
        // app_id,method,charset,sign_type,version,bill_type,timestamp,bill_date
        String[] sign_param = sortedParams.get( "sign_param" ).split( "," );// 生成签名所需的参数
        List<String> keys = new ArrayList<String>();
        for (int i = 0; i < sign_param.length; i++) {
            keys.add( sign_param[i] );
        }
        Collections.sort( keys );
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get( i );
                  /*if ("biz_content".equals(key)) {
          content.append(
                  (index == 0 ? "" : "&") + key + "={\"bill_date\":\"" + sortedParams.get("bill_date") + "\",")
                  .append("\"bill_type\":\"" + sortedParams.get("bill_type") + "\"}");
          index++;
      } else {*/
            String value = sortedParams.get( key );
            if (StringUtils.isNotEmpty( key ) && StringUtils.isNotEmpty( value )) {
                content.append( ( index == 0 ? "" : "&" ) + key + "=" + value );
                index++;
            }
            //            }
        }
        return content.toString();
    }

    private static String readText(InputStream ins) throws IOException {
        Reader reader = new InputStreamReader( ins );
        StringWriter writer = new StringWriter();

        io( reader, writer, -1 );
        return writer.toString();
    }

    private static void io(Reader in, Writer out, int bufferSize) throws IOException {
        if (bufferSize == -1) {
            bufferSize = DEFAULT_BUFFER_SIZE >> 1;
        }

        char[] buffer = new char[bufferSize];
        int amount;

        while (( amount = in.read( buffer ) ) >= 0) {
            out.write( buffer, 0, amount );
        }
    }

}
