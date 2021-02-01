package com.hyssop.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import org.junit.Test;

import java.nio.charset.Charset;

public class TestDecoder {
    @Test
    public void testLineBasedFrameDecoder() throws Exception {

        //...

        ChannelInitializer i = new ChannelInitializer<EmbeddedChannel>() {

            protected void initChannel(EmbeddedChannel ch) {

                ch.pipeline().addLast(new LineBasedFrameDecoder(1024));

                ch.pipeline().addLast(new StringDecoder());

                ch.pipeline().addLast(new StringProcessHandler());

            }

        };

        EmbeddedChannel channel = new EmbeddedChannel(i);

        for (int j = 0; j < 100; j++) {

            ByteBuf buf = Unpooled.buffer();

            String s = "I am " + j;

            buf.writeBytes(s.getBytes("UTF-8"));

            buf.writeBytes("\r\n".getBytes("UTF-8"));

            channel.writeInbound(buf);

        }
    }


    @Test

    public void testLengthFieldBasedFrameDecoder() throws Exception {

        try {

            LengthFieldBasedFrameDecoder spliter = new LengthFieldBasedFrameDecoder(1024, 0, 4, 0, 4);

            ChannelInitializer i = new ChannelInitializer<EmbeddedChannel>() {

                protected void initChannel(EmbeddedChannel ch) {

                    ch.pipeline().addLast(spliter);

                    ch.pipeline().addLast(new StringDecoder(Charset.forName("UTF-8")));

                    ch.pipeline().addLast(new StringProcessHandler());

                }

            };

            EmbeddedChannel channel = new EmbeddedChannel(i);

            for (int j = 0; j < 100; j++) {

                ByteBuf buf = Unpooled.buffer();

                String s = "呵呵,I am " + j;

                byte[] bytes = s.getBytes("UTF-8");

                buf.writeInt(bytes.length);

                buf.writeBytes(bytes);

                channel.writeInbound(buf);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Test

    public void testLengthFieldBasedFrameDecoder1() throws Exception {

        try {
            //maxFrameLength：最大长度
            //lengthFieldOffset：长度字段偏移量
            //lengthFieldLength:长度字段的长度
            //lengthAdjustment：长度字段的内容里面需要扣除哪些不想要的字段长度，以负数的形式扣除（确保获取到数据字段的准确长度，进行微调）
            //initialBytesToStrip 哪些字段是不想被包含在结果里面的，也就是绕过一些字段
            LengthFieldBasedFrameDecoder spliter=new LengthFieldBasedFrameDecoder(1024,2,4,-4,6);
        //    LengthFieldBasedFrameDecoder spliter = new LengthFieldBasedFrameDecoder(1024, 0, 4, 0, 4);

            ChannelInitializer i = new ChannelInitializer<EmbeddedChannel>() {

                protected void initChannel(EmbeddedChannel ch) {

                    ch.pipeline().addLast(spliter);

                    ch.pipeline().addLast(new StringDecoder(Charset.forName("UTF-8")));

                    ch.pipeline().addLast(new StringProcessHandler());

                }

            };

            EmbeddedChannel channel = new EmbeddedChannel(i);

            for (int j = 0; j < 100; j++) {

                ByteBuf buf = Unpooled.buffer();

                String s = j + " is me ,呵呵";

                byte[] bytes = s.getBytes("UTF-8");

                buf.writeChar(100);

                buf.writeInt(bytes.length + 4);

                buf.writeBytes(bytes);
                channel.writeInbound(buf);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
