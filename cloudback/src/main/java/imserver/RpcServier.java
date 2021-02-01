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
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;

@Slf4j
public class RpcServier {
    private String serverAddress;
    EventLoopGroup bossGroup;
    EventLoopGroup workerGroup;
    static final int PORT = Integer.parseInt(System.getProperty("port", "8007"));
    ServerBootstrap serverBootstrap;

    public void RpcServier() throws Exception{
        serverAddress = InetAddress.getLocalHost().getHostAddress();
        workerGroup = new NioEventLoopGroup();
        bossGroup = new NioEventLoopGroup();
        try {
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
                    }).childOption(ChannelOption.SO_KEEPALIVE,true);
            ChannelFuture channelFuture = serverBootstrap.bind(serverAddress,PORT).sync();
            log.info("server addr {} started on port {}", this.serverAddress, this.PORT);
            channelFuture.channel().closeFuture().sync();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }













    }
}
