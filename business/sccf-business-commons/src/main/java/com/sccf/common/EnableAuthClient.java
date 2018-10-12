package com.sccf.common;

import com.sccf.common.config.AutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({AutoConfiguration.class})
@Documented
@Inherited
public @interface EnableAuthClient
{
}
