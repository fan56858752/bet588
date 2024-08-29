package com.haibing.mvvm.bases.ui;

import com.haibing.mvvm.utils.LogUtils;
import com.haibing.mvvm.constants.GlobalConstants;
import com.haibing.mvvm.utils.StringUtils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description tag锁，自定义锁，或者行锁，锁住某行，某张表，通过名字或者对象来加锁
 * @Author 王小军
 * @CreateTime 2024年07月22日
 **/

public class RowLock<T> {
    private static final String TAG = StringUtils.concat(GlobalConstants.TAG_PREFIXES, RowLock.class.getSimpleName());
    private ConcurrentHashMap<T, Lock> rowLock = new ConcurrentHashMap<>();
    public void lock(T t) {
        LogUtils.d(TAG, StringUtils.concat(t.toString(), " lock"));
        Lock lock = rowLock.get(t);
        if(lock == null) {
            lock = new ReentrantLock();
            rowLock.put(t, lock);
        }
        lock.lock();
    }
    public void unlock(T t) {
        Lock lock = rowLock.get(t);
        if(lock != null) {
            LogUtils.d(TAG, StringUtils.concat(t.toString(), " unlock"));
            lock.unlock();
        }
    }

    public void postLock(T t, Runnable runnable) {
        try {
            lock(t);
            runnable.run();
        } catch (Throwable e) {
            e.printStackTrace();
            LogUtils.e("RowLock", "postLock error");
            String message = e.getMessage();
            if(message != null) {
                LogUtils.e("RowLock", e.getMessage());
            }
        } finally {
            unlock(t);
        }
    }
}
