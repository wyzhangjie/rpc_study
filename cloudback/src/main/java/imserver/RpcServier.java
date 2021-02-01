package imserver;

import codc.SmallDecoder;
import codc.SmallEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class RpcServier {
    EventLoopGroup bossGroup;
    EventLoopGroup workerGroup;
    static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));
    ServerBootstrap serverBootstrap;

    public void RpcServier() {
        workerGroup = new NioEventLoopGroup();
        bossGroup = new NioEventLoopGroup();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 100)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        //编解码
                        p.addLast(new SmallDecoder());
                        p.addLast(new SmallEncoder());
                        //  p.addLast(serverHandler);
                    }
                });

    }
}
