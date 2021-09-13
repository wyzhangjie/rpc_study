package com.rpc.spring.registry;

public class EurekaRegistryService implements RegistryService{
    public EurekaRegistryService(String registryAddr) {
        // TODO
    }
    @Override
    public void register(ServiceMeta serviceMeta) throws Exception {

    }

    @Override
    public void unregister(ServiceMeta serviceMeta) throws Exception {

    }

    @Override
    public ServiceMeta discovery(String serviceName, int hashCode) throws Exception {
        return null;
    }

    @Override
    public void destroy() throws Exception {

    }
}
