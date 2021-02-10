package com.rpc.imserver;

import com.rpc.common.RpcServiceHelper;
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
            try{ this.serverAddress = InetAddress.getLocalHost().getHostAddress();
                RpcServier rpcServier = new RpcServier(serverAddress,serverPort);
                rpcServier.startRpcServer(rpcServiceMap);
            }catch (Exception e){
                log.error("start rpc server error",e);
            }

        }).start();

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
