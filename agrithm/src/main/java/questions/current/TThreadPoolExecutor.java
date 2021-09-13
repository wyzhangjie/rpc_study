package questions.current;

import java.util.concurrent.atomic.AtomicBoolean;

//TThreadPoolExecutor.java，模拟juc的ThreadPoolExecutor
public class TThreadPoolExecutor extends TExecutorService {

    /**
     * 线程池状态，false：未关闭，true已关闭
     */
    private AtomicBoolean ctl = new AtomicBoolean();

    @Override
    public void execute() {
        //启动一个新线程，模拟ThreadPoolExecutor.execute
        new Thread(() -> {

        }).start();
        //模拟ThreadPoolExecutor，启动新建线程后，循环检查线程池状态，验证是否会在finalize中shutdown
        //如果线程池被提前shutdown，则抛出异常
        for (int i = 0; i < 1_000_000; i++) {
            if(ctl.get()){
                throw new RuntimeException("reject!!!["+ctl.get()+"]");
            }
        }
    }

    @Override
    public void shutdown() {
        ctl.compareAndSet(false,true);
    }
}