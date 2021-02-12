package com.javainuse.springbootsecurity.tests;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class Test {
    private static final AtomicLong LAST_TIME_MS = new AtomicLong();
    public static void main(String[] args) {
//        for(int i=0;i<=100;i++){

            System.out.println(getUnique());
//        }

    }
    public static String getUnique(){
        long now = System.currentTimeMillis();
        while(true) {
            long lastTime = LAST_TIME_MS.get();
            if (lastTime >= now)
                now = lastTime+1;
            if (LAST_TIME_MS.compareAndSet(lastTime, now))
                return String.format("%015d",now);
        }
    }
}
