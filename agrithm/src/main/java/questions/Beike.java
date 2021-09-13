package questions;

import questions.evrydaystep.BeiKe1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Beike {
    ReentrantLock lock = new ReentrantLock();
    Condition aCondition = lock.newCondition();
    Condition bCondition = lock.newCondition();


    public static void main(String[] args) {
        new BeiKe1().start();
    }

    public void start() {
        new Thread(new Beike.AThread()).start();
        new Thread(new Beike.BThread()).start();


    }

    public class AThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {

                    lock.lock();

                    System.out.println("a");
                    bCondition.signal();
                    aCondition.await();
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
                    Thread.sleep(1000);
                    lock.lock();

                    System.out.println("b");
                    bCondition.await();
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
