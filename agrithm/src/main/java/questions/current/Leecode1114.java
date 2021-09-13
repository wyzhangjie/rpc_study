package questions.current;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Leecode1114 {
    ReentrantLock lock = new ReentrantLock();
    Condition first = lock.newCondition();
    Condition second = lock.newCondition();
    Condition third = lock.newCondition();
    int count=1;

    public static void main(String[] args) throws Exception{
        Leecode1114 leecode1114 = new Leecode1114();
        Thread first =new Thread(new FistThread());
        Thread second = new Thread(new SecondThread());
        Thread third =new Thread(new ThirdThread());
        while (true){
            leecode1114.first(first);
            leecode1114.second(second);
            leecode1114.third(third);
        }


    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try{
        if(count!=1){
            first.await();
        }
            printFirst.run();
            count=2;
            second.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try{
            if(count!=2) {
                second.await();
            }
                printSecond.run();
                count=3;
                third.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try{
            if(count!=3) {
                third.await();
            }
            printThird.run();
            count=1;
            first.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

 static    class FistThread implements Runnable{

        @Override
        public void run() {
            System.out.println("第一个线程");
        }
    }

  static   class SecondThread implements Runnable{

        @Override
        public void run() {
            System.out.println("第二个线程");
        }
    }

  static   class ThirdThread implements Runnable{

        @Override
        public void run() {
            System.out.println("第三个线程");
        }
    }
}
