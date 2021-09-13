package questions.evrydaystep;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BeiKe1 {
    ReentrantLock lock = new ReentrantLock();
    Condition aCondition = lock.newCondition();
    Condition bCondition = lock.newCondition();
    int count = 0;

    public static String signal = "A";

    public static void main(String[] args) {
        new BeiKe1().start();
    }

    public void start() {
        new Thread(new AThread()).start();
        new Thread(new BThread()).start();
    }

    public class AThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (count == 0) {
                        aCondition.await();
                    }
                    System.out.println("a");
                    count++;
                    bCondition.signal();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public class BThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    while (count != 0) {
                        bCondition.await();
                    }
                    System.out.println("b");
                    count--;
                    aCondition.signal();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    System.out.println(e.getStackTrace());
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
