package com.rpc.netty;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Acceptor implements Runnable{
    private AtomicInteger num = new AtomicInteger(0);
    private ExecutorService mainReactor = Executors.newSingleThreadExecutor(
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    Thread thread = new Thread();
                    thread.setName("main-reactor-"+num);
                    return thread;
                }
            }
    );
    @Override
    public void run() {

    }
}
