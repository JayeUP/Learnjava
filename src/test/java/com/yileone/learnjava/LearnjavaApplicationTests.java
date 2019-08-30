package com.yileone.learnjava;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnjavaApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void md5Test() {
        String str="28239002ff1c440d899d8f702a0a7ff9fe66b4e929e24e9f802c32f10b2a832dhttp://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83er9ick32L2hCGYn3XqRcSMMp3PHPvhFBwtQvJrGSRlS50YibMyTWSB6B6PsrXsSgW9nKENjpCQbqibuA/132孔祥福972dd4c192dac2d20ce8bac67ef09a25";
        String md5Pre = "28239002ff1c440d899d8f702a0a7ff9fe66b4e929e24e9f802c32f10b2a832dhttp://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83er9ick32L2hCGYn3XqRcSMMp3PHPvhFBwtQvJrGSRlS50YibMyTWSB6B6PsrXsSgW9nKENjpCQbqibuA/132孔祥福972dd4c192dac2d20ce8bac67ef09a25";
        System.out.println("是否相同 = " + StringUtils.equals(str,md5Pre));
//        sign：fbdc46d25e23c2c46c21f9e35aeca7a2
        // 生成一个MD5加密计算摘要
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 计算md5函数
        md.update(md5Pre.getBytes());
        String sign = new BigInteger(1, md.digest()).toString(16);
        System.out.println("sign = " + sign);   // sign = fbdc46d25e23c2c46c21f9e35aeca7a2
        // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
    }


}
