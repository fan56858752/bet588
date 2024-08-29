package com.haibing.mvvm.bases;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    private ExecutorService service;
    private static final int CORE_NUM = 20;
    private static final long KEEP_ALIVE = 1 * 60 * 1000;//ms
    private ThreadPool() {
        service = new ThreadPoolExecutor(CORE_NUM,CORE_NUM * 2,KEEP_ALIVE, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(CORE_NUM * 2));
    }
    private static volatile ThreadPool INSTANCE = null;
    public static ThreadPool getInstance() {
        if(INSTANCE == null) {
            synchronized (ThreadPool.class) {
                if(INSTANCE == null) {
                    INSTANCE = new ThreadPool();
                }
            }
        }
        return INSTANCE;
    }
    public void execute(Runnable runnable) {
        if(!service.isShutdown()) {
            try {
                service.execute(runnable);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
    public void shutdown() {
        if(!service.isShutdown()) {
            service.shutdown();
        }
    }

    public ExecutorService getService() {
        return service;
    }
}
