package com.hyssop.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class ByteBufTest {
    public static void main(String[] args) {
        //呦呦呦~ jdk的ByteBuffer设计的太复杂，读写都是用一个指针，一会儿要flip，一会要rewind，没等写完已经犯晕
        //netty看到只撇嘴，我们要设计一个ByteBuf 读写两个指针，清晰操作，毫无违和感，轻松读写，让人爱恋。
        //创建一个直接内存的buteBuf 初始值是6 ，最大值是10，默认设置的是池化的内存池
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(6, 10);

        printByteBufInfo("ByteBufAllocator.buffer(5, 10)", buffer);

        buffer.writeBytes(new byte[]{1, 2});

        printByteBufInfo("write 2 Bytes", buffer);

        buffer.writeInt(100);

        printByteBufInfo("write Int 100", buffer);

        buffer.writeBytes(new byte[]{3, 4, 5});

        printByteBufInfo("write 3 Bytes", buffer);

        byte[] read = new byte[buffer.readableBytes()];

        buffer.readBytes(read);

        printByteBufInfo("readBytes(" + buffer.readableBytes() + ")", buffer);

        printByteBufInfo("BeforeGetAndSet", buffer);

        System.out.println("getInt(2): " + buffer.getInt(2));

        buffer.setByte(1, 0);

        System.out.println("getByte(1): " + buffer.getByte(1));

        printByteBufInfo("AfterGetAndSet", buffer);

    }

    private static void printByteBufInfo(String step, ByteBuf buffer) {

        System.out.println("------" + step + "-----");

        System.out.println("readerIndex(): " + buffer.readerIndex());

        System.out.println("writerIndex(): " + buffer.writerIndex());

        System.out.println("isReadable(): " + buffer.isReadable());

        System.out.println("isWritable(): " + buffer.isWritable());

        System.out.println("readableBytes(): " + buffer.readableBytes());

        System.out.println("writableBytes(): " + buffer.writableBytes());

        System.out.println("maxWritableBytes(): " + buffer.maxWritableBytes());

        System.out.println("capacity(): " + buffer.capacity());

        System.out.println("maxCapacity(): " + buffer.maxCapacity());

    }
}
