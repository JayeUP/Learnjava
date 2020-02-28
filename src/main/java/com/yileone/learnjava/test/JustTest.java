package com.yileone.learnjava.test;

/**
 * @author: jinyuan
 * @since: 2019/11/24 22:43
 */
public class JustTest {
    public static void main(String[] args) {
        /*try {
            Integer test = test();
            System.out.println("test = " + test);
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        Long time = 1575253766L;
        time = 1575256192L;
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        System.out.println("差值1 = " + (start/1000 -time));
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("差值2 = " + (end/1000 -time));
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
