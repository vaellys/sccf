package com.sccf.common.config;

import com.sccf.common.EnableAuthClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author qianguobing
 * @date 2018-09-15 14:19
 */
@ComponentScan(basePackages={"com.sccf.common"})
@EnableFeignClients(basePackages={"com.sccf.common.feign"})
@ConditionalOnBean(annotation={EnableAuthClient.class})
public class AutoConfiguration {


    @ConditionalOnMissingBean({AuthServerConfiguration.class})
    @Bean
    AuthServerConfiguration userAuthConfig() {
        return new AuthServerConfiguration();
    }
}
