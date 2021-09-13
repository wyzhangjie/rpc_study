package questions.current;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 * public void zero(printNumber) { ... }  // 仅打印出 0
 * public void even(printNumber) { ... }  // 仅打印出 偶数
 * public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 * <p>
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出："0102030405"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-zero-even-odd
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZeroEvenOdd {
    private int n;
    private int i = 0;

    private boolean canZero =true;

    private ReentrantLock lock = new ReentrantLock();

    private Condition zero = lock.newCondition();

    private Condition all = lock.newCondition();


    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
       while (true){
           if(i>n) return;
           try {
               lock.lock();
               if(i==0){
                   printNumber.accept(i++);
                   canZero=false;
                   all.signal();
               }else {
                   while (!canZero){
                       zero.await();
                   }

                   printNumber.accept(0);
                   canZero=false;
                   all.signal();

               }


           } catch (Exception e) {
               e.printStackTrace();
           } finally {
               lock.unlock();
           }

       }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true){
            try {
                if(i>n) return;
                lock.lock();
                while (canZero || i%2!=0){
                    all.await();
                }
                printNumber.accept(i++);
                canZero=true;
                zero.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true){
            if(i>n) return;
            try {
                lock.lock();
                while (canZero || i%2==0){
                    all.await();
                }
                printNumber.accept(i++);
                canZero=true;
                zero.signal();


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) throws Exception {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(3);
        IntConsumer intConsumer= value -> System.out.println(value);

       Thread a1= new Thread(()->{
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


      Thread a2=  new Thread(()->{
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
     Thread a3= new Thread(()->{
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        a1.setName("线程1");
        a1.start();

        a2.setName("线程2");
        a2.start();
        a3.setName("线程3");
        a3.start();
    }
}
