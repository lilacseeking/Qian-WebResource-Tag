package org.lilacseeking;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableApolloConfig
public class ThinkApplication {
    @RequestMapping(value = "/")
    public String init(){
        return "this is a SpringBoot Project!";
    }
    public static void main(String[] args){
        SpringApplication.run(ThinkApplication.class , args);
    }
}
