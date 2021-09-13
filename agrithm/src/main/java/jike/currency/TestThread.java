package jike.currency;

public class TestThread {

    public static void main(String[] args) throws InterruptedException {

        Worker t = new Worker();
        t.start();

        Thread.sleep(2000);

        System.out.println("-1-1-1-");
        t.interrupt();
      /*  System.out.println("000000");
        Thread.sleep(2000);
        t.stop();
        System.out.println("000111");
        Thread.sleep(2000);
        t.join();
        System.out.println("111111");*/
    }

}

class Worker extends Thread {

    @Override
    public void run() {
        int i = 0;
        while (i<20) {
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            ++i;
            System.out.println(Thread.currentThread().getName() + "i: " + i);
           /* try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
           //     Thread.currentThread().interrupt();
            }*/
        }

        if(Thread.currentThread().isInterrupted()){
            System.out.println("复位interrupt");
        }
    }
}