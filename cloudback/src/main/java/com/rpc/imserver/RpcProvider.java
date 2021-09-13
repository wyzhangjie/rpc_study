package com.rpc.imserver;

import com.rpc.codc.SmallDecoder;
import com.rpc.codc.SmallEncoder;
import com.rpc.common.RpcServiceHelper;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import com.rpc.spring.annotation.MyServierI;
import com.rpc.spring.registry.RegistryService;
import com.rpc.spring.registry.ServiceMeta;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class RpcProvider implements InitializingBean, BeanPostProcessor {
    private String serverAddress;
    private final RegistryService serviceRegistry;
    private final int serverPort;
    private final Map<String, Object> rpcServiceMap = new HashMap<>();

    public RpcProvider(int serverPort, RegistryService serviceRegistry) {
        this.serverPort = serverPort;
        this.serviceRegistry = serviceRegistry;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        new Thread(()->{
            try{
              /*  this.serverAddress = InetAddress.getLocalHost().getHostAddress();
                RpcServier rpcServier = new RpcServier(serverAddress,serverPort);*/
                startRpcServer(rpcServiceMap);
            }catch (Exception e){
                log.error("start rpc server error",e);
            }

        }).start();

    }

    private void startRpcServer(Map<String, Object> rpcServiceMap) throws Exception{

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
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.SO_REUSEADDR,true);

            ChannelFuture channelFuture = bootstrap.bind(this.serverAddress, this.serverPort).sync();
            log.info("server addr {} started on port {}", this.serverAddress, this.serverPort);
            channelFuture.channel().closeFuture().sync();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {

        //将所有接口注册到 zk等协调器上
        MyServierI rpcService = bean.getClass().getAnnotation(MyServierI.class);
        if(rpcService!=null){
            String serviceName = rpcService.serviceInterface().getName();
            String serviceVersion = rpcService.serviceVersion();
            try {
                ServiceMeta serviceMeta = new ServiceMeta();
                serviceMeta.setServiceAddr(serverAddress);
                serviceMeta.setServiceName(serviceName);
                serviceMeta.setServicePort(serverPort);
                serviceMeta.setServiceVersion(serviceVersion);
                serviceRegistry.register(serviceMeta);
                rpcServiceMap.put(RpcServiceHelper.buildServiceKey(serviceMeta.getServiceName(), serviceMeta.getServiceVersion()), bean);
            }catch (Exception e){
                log.error("failed to register service {}#{}", serviceName, serviceVersion, e);
            }
        }
        return bean;
    }
}
