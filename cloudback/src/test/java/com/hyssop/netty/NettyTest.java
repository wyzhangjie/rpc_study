package com.hyssop.netty;

import com.alibaba.fastjson.JSON;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class NettyTest {
    static IntBuffer intBuffer = null;

    public static void putTest(){
        for(int i=0;i<5;i++){
            intBuffer.put(i);
        }
    }

    public static void print(){
        System.out.println("position:"+intBuffer.position()+"limit:"+intBuffer.limit()+"capacity="+intBuffer.capacity());
    }

    public static void flipTest(){
        //将position从可写位置，推回到可读位置
        intBuffer.flip();
    }
    //将模式从可读变为可写
    public static void changeToWritable(){
        //将position从可写位置，推回到可读位置
        intBuffer.compact();
    }
    public static void changeToWritable1(){
        //将position从可写位置，推回到可读位置
        intBuffer.clear();
    }
    //读一次
    public static void getInfo(){
        for(int i=0;i<5;i++){
            System.out.println(intBuffer.get());
        }
    }

    //可以重复读多次
    public static void getInfoManyTime(){
        intBuffer.rewind();
        for(int i=0;i<5;i++){
            System.out.println(intBuffer.get());
        }
    }
    private static Unsafe unsafe = null;

    static {

  try {

    Field getUnsafe = Unsafe.class.getDeclaredField("theUnsafe");

    getUnsafe.setAccessible(true);

    unsafe = (Unsafe) getUnsafe.get(null);

  } catch (NoSuchFieldException | IllegalAccessException e) {

    e.printStackTrace();

  }

    }
    public static void directBuffer(){
        //当DirectByteBuffer被gc被回收的时候，Cleaner回收对外内存
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        // cleaner = Cleaner.create(this, new Deallocator(base, size, cap)); 对外内存的释放是这个虚引用的cleaner的，
        //虚可达（phantom reachable） 当试图通过虚引用的get()方法取得强引用 时，总是会返回null，并且，虚引用必须和引用队列一起使用
        // 虚引用有一个引用连，一旦从正引用连摘除就会触发gc清除，达到数据清除的目的。
        //https://www.cnblogs.com/mfrank/p/9837070.html  当垃圾回收器准备回收一个对象时，如果发现它还有虚引用，就会在垃圾回收后，将这个虚引用加入引用队列，在其关联的虚引用出队前，不会彻底销毁该对象。 所以可以通过检查引用队列中是否有相应的虚引用来判断对象是否已经被回收了。

        System.out.println(JSON.toJSONString(unsafe));
        //通过unsafe获取地址
        long address = unsafe.allocateMemory(10*1024*1024);

        System.out.println(address);
        //通过unsafe手动释放
        unsafe.freeMemory(address);
        //设置 XX:MaxDirectMemorySize指定对外内存在达到这个最大值得时候，必须执行一次full gc
        //如果执行完gc之后还是没有足够的对外内存，那么会抛出OOM异常。
        //此外在生成对外内存的时候，如果内存不足也会主动调用一次 System.gc(); 强制执行一次full gc
        // 如果生产环境设置了 -XX:+DisableExplicitGC 那么就会使得System.gc() 这个动作失效
    }
    public static void main(String[] args) {
       /* intBuffer = IntBuffer.allocate(20);
        putTest();
        print();
        flipTest();
        print();
        *//*changeToWritable();
        print();
        changeToWritable1();
        print();*//*
        getInfo();
        print();
        getInfoManyTime();
        print();*/
        directBuffer();
    }


}
