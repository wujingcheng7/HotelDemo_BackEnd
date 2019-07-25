package com.wujingcheng7.hoteldemo_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wujingcheng7.hoteldemo_backend.Mapper")
public class HoteldemoBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoteldemoBackendApplication.class, args);
    }

}
