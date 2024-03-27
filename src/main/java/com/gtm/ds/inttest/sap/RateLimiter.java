package com.gtm.ds.inttest.sap;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RateLimiter {
    private static final int REQUEST_LIMIT = 5;
    private static final long WINDOW_SIZE_MS = 1000; // 1 second

    private final Map<String, Limit> requestCounts = new ConcurrentHashMap<>();

    public synchronized boolean allowRequest(String ipAddress) {
        long currentTime = System.currentTimeMillis();
        cleanUpExpiredEntries(currentTime);

        Limit limit = requestCounts.getOrDefault(ipAddress, new Limit());
        if (limit.count < REQUEST_LIMIT) {
            limit.count = limit.count + 1;
            limit.lastAccessTime = currentTime;
            requestCounts.put(ipAddress, limit);
            return true;
        } else {
            return false; // Request limit exceeded
        }
    }

    private void cleanUpExpiredEntries(long currentTime) {
        requestCounts.entrySet().removeIf(entry -> currentTime - entry.getValue().lastAccessTime > WINDOW_SIZE_MS);
        //System.out.println(requestCounts.keySet());
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter();
        ExecutorService service = Executors.newFixedThreadPool(3);
        int i = 0;
        Random random = new Random();
        while (i < 1000) {
            int ip = random.nextInt(3);
            Runnable runnable = () -> {
                if (rateLimiter.allowRequest(String.valueOf(ip))) {
                    System.out.println("allowed " + ip);
                } else {
                    System.out.println("not allowed " + ip);
                }

                try {
                    Thread.sleep(502L);
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            };
            service.submit(runnable);
            i++;
        }

        service.shutdown();
    }
}

class Limit {
    int count = 0;
    long lastAccessTime = 0L;
}
