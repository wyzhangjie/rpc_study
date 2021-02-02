package imclient;

import codc.SmallDecoder;
import codc.SmallEncoder;
import codc.SmallHeader;
import codc.SmallRpcProtocol;
import common.MiniRpcRequest;
import common.RpcServiceHelper;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;
import spring.registry.RegistryService;
import spring.registry.ServiceMeta;

@Slf4j
public class RpcConsumer {

    private final Bootstrap bootstrap;
    private final EventLoopGroup eventLoopGroup;
    public  RpcConsumer(){
        bootstrap = new Bootstrap();
        eventLoopGroup = new NioEventLoopGroup(4);
        bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>(){

            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline p = socketChannel.pipeline();
                p.addLast(new SmallDecoder());
                p.addLast(new SmallEncoder());
                p.addLast(new ConsumerHandler());
            }
        });
    }
    public void sendRequest(SmallRpcProtocol<MiniRpcRequest> protocol, RegistryService registryService) throws Exception {
        SmallHeader smallHeader = protocol.getSmallHeader();
        MiniRpcRequest miniRpcRequest = protocol.getData();
        Object[] params = miniRpcRequest.getParams();
        String serviceKey = RpcServiceHelper.buildServiceKey(miniRpcRequest.getClassName(),miniRpcRequest.getServiceVersion());
        int invokerHashCode = params.length > 0 ? params[0].hashCode() : serviceKey.hashCode();
        ServiceMeta serviceMetadata = registryService.discovery(serviceKey, invokerHashCode);
        if(serviceMetadata!=null){
            ChannelFuture channelFuture = bootstrap.connect(serviceMetadata.getServiceAddr(),serviceMetadata.getServicePort());
            channelFuture.addListener((ChannelFutureListener)arg0->{
                if(arg0.isSuccess()){
                    log.info("connect rpc server {} on port {} success.", serviceMetadata.getServiceAddr(), serviceMetadata.getServicePort());
                }else {
                    log.error("connect rpc server {} on port {} failed.", serviceMetadata.getServiceAddr(), serviceMetadata.getServicePort());
                    channelFuture.cause().printStackTrace();
                    eventLoopGroup.shutdownGracefully();
                }
            });
            channelFuture.channel().writeAndFlush(protocol);
        }
    }
}
