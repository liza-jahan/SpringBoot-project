package com.example.aopbasic;

import com.example.aopbasic.main.AopClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AopBasicApplication {

    public static void main(String[] args) {
      ApplicationContext context= SpringApplication.run(AopBasicApplication.class, args);
        AopClass aopClass=context.getBean(AopClass.class);
        aopClass.hello();
        aopClass.printSomething("Some thing");
        System.out.println(aopClass.sum(10,70));

    }

}
