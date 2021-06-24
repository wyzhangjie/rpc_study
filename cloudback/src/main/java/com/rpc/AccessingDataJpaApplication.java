package com.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EnableJpaRepositories(basePackages={"com.rpc.db.reposity"})

@EntityScan("com.rpc.db.entity")
public class AccessingDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

}
