package com.baidu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BaiduEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaiduEurekaApplication.class, args);
    }

}
