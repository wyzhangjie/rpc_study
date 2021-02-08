package com.rpc.common;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author jie.zhang
 * @create_time 2020/7/9 15:23
 * @updater
 * @update_time
 **/
public class CGLibExample {

    static class Car {
        public void running() {
            System.out.println("The car is running.");
        }
    }

    /**
     * CGLib 代理类
     */
    static class CGLibProxy implements MethodInterceptor {
        private Object target; // 代理对象

        public Object getInstance(Object target) {
            this.target = target;
            Enhancer enhancer = new Enhancer();
            // 设置父类为实例类
            enhancer.setSuperclass(this.target.getClass());
            // 回调方法
            enhancer.setCallback(this);
            // 创建代理对象
            return enhancer.create();
        }

        @Override
        public Object intercept(Object o, Method method,
                                Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("方法调用前业务处理.");
            Object result = methodProxy.invokeSuper(o, objects); // 执行方法调用
            return result;
        }
    }

    // 执行 CGLib 的方法调用
    public static void main(String[] args) {
        // 创建 CGLib 代理类
        CGLibProxy proxy = new CGLibProxy();
        // 初始化代理对象
        Car car = (Car) proxy.getInstance(new Car());
        // 执行方法
        car.running();
    }
}