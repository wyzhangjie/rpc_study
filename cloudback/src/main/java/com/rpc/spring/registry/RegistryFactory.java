package com.rpc.spring.registry;

public class RegistryFactory {

    private static volatile RegistryService registryService;

    public static RegistryService getInstance(String registryAddr, RegistryType type) throws Exception {
        if(registryService==null){
            synchronized (RegistryFactory.class){
                if(registryService==null){
                    switch (type){
                        case EUREKA:
                            registryService = new EurekaRegistryService(registryAddr);
                            break;
                        case ZOOKEEPER:
                            registryService = new ZkRegistryServiceImpl(registryAddr);
                            break;

                    }
                }
            }
        }
        return registryService;
    }
}
