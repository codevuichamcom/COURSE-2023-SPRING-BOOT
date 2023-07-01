package com.funnycode.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
public class ConfigurationGlobal {
    @Value("${sql.url}")
    private String url;

    @Value("${sql.username}")
    private String username;

    @Value("${sql.password}")
    private String password;


//    @Bean
//    @Primary
//    public Girl createNgocTrinh(){
//        IOutfit bikini = new Bikini();
//        Girl girl = new Girl( bikini);
//        girl.setName("Ngọc Trinh");
//        return girl;
//    }

    @Bean
    public String getConnection(){
        return "url: "+url+", username: "+username+", password: "+password;
    }
}
