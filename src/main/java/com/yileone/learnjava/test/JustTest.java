package com.yileone.learnjava.test;

/**
 * @author: jinyuan
 * @since: 2019/11/24 22:43
 */
public class JustTest {
    public static void main(String[] args) {
        try {
            Integer test = test();
            System.out.println("test = " + test);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Integer test() throws Exception {
        try {
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            throw new Exception("error");
        }
    }
}
