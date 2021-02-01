package spring.registry;

import java.io.IOException;

public interface RegistryService {
    /**
     * 注册
     * */
    void register(ServiceMeta serviceMeta)throws Exception;
    /**
     * 注销
     * */
    void unregister(ServiceMeta serviceMeta) throws Exception;
    /**
     * 发现
     * */
    ServiceMeta discovery(String serviceName,int hashCode) throws Exception;
    /**
     * 销毁
     * */
    void destroy() throws Exception;

}
