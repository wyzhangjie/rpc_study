package jike.currency;


import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class SafeWM {
    // 库存上限
    private final AtomicLong upper =
            new AtomicLong(0);
    // 库存下限
    private final AtomicLong lower =
            new AtomicLong(0);

    private ReentrantLock lock = new ReentrantLock();

    // 设置库存上限
    void setUpper(long v) {
        // 检查参数合法性
        try{
            lock.lock();
            if (v < lower.get()) {
                throw new IllegalArgumentException();
            }
            upper.set(v);
        }finally {
            lock.unlock();
        }

    }

    // 设置库存下限
    void setLower(long v) {
        // 检查参数合法性
        try{
            lock.lock();
            if (v > upper.get()) {
                throw new IllegalArgumentException();
            }
            lower.set(v);
        }finally {
            lock.unlock();
        }

    }
    // 省略其他业务代码
}