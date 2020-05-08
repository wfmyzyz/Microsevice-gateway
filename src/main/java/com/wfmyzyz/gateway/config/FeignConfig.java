package com.wfmyzyz.gateway.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author admin
 */
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLever(){
        return Logger.Level.FULL;
    }
}
