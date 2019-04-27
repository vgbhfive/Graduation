package cn.vgbhfive.graduationproject;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableSwagger2Doc
@EnableAsync
@SpringBootApplication
public class GraduationprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraduationprojectApplication.class, args);
    }

}

