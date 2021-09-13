package com.rpc.imserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages ="com.rpc.imserver")
public class RpcProviderApplication {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(RpcProviderApplication.class, args);
    }
}