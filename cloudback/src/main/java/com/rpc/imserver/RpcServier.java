package com.rpc.imserver;

import com.rpc.codc.SmallDecoder;
import com.rpc.codc.SmallEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.util.Map;

@Slf4j
public class RpcServier {
    EventLoopGroup bossGroup;
    EventLoopGroup workerGroup;
    ServerBootstrap serverBootstrap;
    String serverAddress;
    int serverPort;

    public RpcServier(String serverAddress,int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void startRpcServer(Map<String, Object> rpcServiceMap)throws Exception {

        /*try {
            serverBootstrap = new ServerBootstrap();
            serverAddress = InetAddress.getLocalHost().getHostAddress();
            workerGroup = new NioEventLoopGroup();
            bossGroup = new NioEventLoopGroup();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .handler(new LoggingHandler(LogLevel.TRACE))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline p = ch.pipeline();
                            //编解码
                            p.addLast(new SmallDecoder());
                            p.addLast(new SmallEncoder());
                            p.addLast(new RpcRequestHandler(rpcServiceMap));

                        }
                    }).childOption(ChannelOption.SO_KEEPALIVE,true);
            ChannelFuture channelFuture = serverBootstrap.bind(serverAddress,serverPort).sync();
            log.info("server addr {} started on port {}", serverAddress, this.serverPort);
            channelFuture.channel().closeFuture().sync();
        }catch (Exception e){
           throw e;

        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }*/



        this.serverAddress = InetAddress.getLocalHost().getHostAddress();

        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast(new SmallEncoder())
                                    .addLast(new SmallDecoder())
                                    .addLast(new RpcRequestHandler(rpcServiceMap));
                        }
                    })
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture channelFuture = bootstrap.bind(this.serverAddress, this.serverPort).sync();
            log.info("server addr {} started on port {}", this.serverAddress, this.serverPort);
            channelFuture.channel().closeFuture().sync();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }









    }
}
