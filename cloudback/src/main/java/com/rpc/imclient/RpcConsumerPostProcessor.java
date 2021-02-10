package com.rpc.imclient;

import org.apache.commons.lang3.ClassUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class RpcConsumerPostProcessor  implements ApplicationContextAware, BeanClassLoaderAware, BeanFactoryPostProcessor {
   private ClassLoader classLoader;

   private ApplicationContext context;
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        //获取所有工厂里面的bean
        for(String beanDefinationName:factory.getBeanDefinitionNames()){
            BeanDefinition beanDefinition =factory.getBeanDefinition(beanDefinationName);
            String beanClassName = beanDefinition.getBeanClassName();
            if(beanClassName!=null){
              //  Class<?> clazz = ClassUtils.r
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context=applicationContext;
    }
}
