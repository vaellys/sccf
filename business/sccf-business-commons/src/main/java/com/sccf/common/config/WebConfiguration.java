package com.sccf.common.config;

import com.sccf.common.EnableAuthClient;
import com.sccf.common.filter.RequestWrapperFilter;
import com.sccf.common.interceptor.AuthenticationInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author qianguobing
 * @date 2018-09-15 15:32
 */
@Configuration
@Primary
@ConditionalOnBean(annotation = {EnableAuthClient.class})
public class WebConfiguration extends WebMvcConfigurerAdapter {


    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**").excludePathPatterns("/swagger-ui.html",
                "/webjar*/**",
                "/v2/**",
                "/swagger-resources/**");
        super.addInterceptors(registry);
    }

    @ConditionalOnMissingBean({AuthenticationInterceptor.class})
    @Bean
    AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Bean
    public FilterRegistrationBean Filters() {

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(new RequestWrapperFilter());

        registrationBean.addUrlPatterns("/*");

        registrationBean.setName("requestWrapperFilter");

        return registrationBean;

    }


}
