package imserver;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import spring.registry.RegistryService;

import java.util.HashMap;
import java.util.Map;

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
            RpcServier rpcServier = new RpcServier();
        });

    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {

        //将所有接口注册到 zk等协调器上

        return null;
    }
}
