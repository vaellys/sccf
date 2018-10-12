package com.sccf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

/**
 * 后台管理系统API
 */
@EnableHystrix
@EnableFeignClients
@SpringCloudApplication
@ComponentScan(basePackages = {"com.sccf"})
//@EnableAuthClient
public class AdminApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdminApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
