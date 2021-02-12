package com.javainuse.springbootsecurity.util;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class CommonUtil {
    private static final AtomicLong LAST_TIME_MS = new AtomicLong();
    public static String autoGenProdCode(){
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
