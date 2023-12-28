package com.collegevol;

import com.collegevol.vo.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.collegevol")
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan("com.collegevol.dao")
//@ServletComponentScan(basePackages = "com.collegevol")
@EnableScheduling
public class Application {
    
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class);
        System.out.println(run.getEnvironment().getProperty("spring.datasource.url"));
        new Test().test();
    }

}
