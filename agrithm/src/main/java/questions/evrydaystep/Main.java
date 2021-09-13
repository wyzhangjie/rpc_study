package questions.evrydaystep;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static int  count=1;
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        List queue = new LinkedList();
        Lock lock = new ReentrantLock();

        new Thread(()->{
            for(int i=0;i<20;i++){
                try{
                    Thread.sleep(100);
                    lock.lock();
                    queue.add(count++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally{
                    lock.unlock();
                }
            }
        }).start();
        new Thread(()->{
            for(int j=0;j<5;j++){
                try{
                    Thread.sleep(500);
                    lock.lock();
                    int index=0;

                    queue.stream().forEach((a)->{
                        System.out.println(a);
                    });
                    queue.clear();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally{
                    lock.unlock();
                }
            }

        }).start();

    }
}