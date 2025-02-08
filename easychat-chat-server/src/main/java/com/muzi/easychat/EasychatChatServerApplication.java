package com.muzi.easychat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = {"com.muzi.easychat"})
@MapperScan({"com.muzi.easychat.**.mapper"})
@ServletComponentScan
public class EasychatChatServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasychatChatServerApplication.class, args);
    }

}
