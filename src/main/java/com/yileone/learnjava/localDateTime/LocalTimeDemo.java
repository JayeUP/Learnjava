package com.yileone.learnjava.localDateTime;

import java.time.LocalTime;

public class LocalTimeDemo {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println("now = " + now); //now = 19:17:21.483

        LocalTime nowWithoutNano = LocalTime.now().withNano(0);
        System.out.println("nowWithoutNano = " + nowWithoutNano);   //nowWithoutNano = 19:17:21

        LocalTime zero = LocalTime.of(0, 0, 0);
        System.out.println("zero = " + zero);   //zero = 00:00
        LocalTime mid = LocalTime.parse("12:00:00");
        System.out.println("mid = " + mid); //mid = 12:00
    }
}
