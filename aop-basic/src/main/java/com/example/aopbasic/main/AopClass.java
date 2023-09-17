package com.example.aopbasic.main;

import org.springframework.stereotype.Component;

@Component
public class AopClass {
    public void hello(){
        System.out.println("Hello world");
    }

    public  void printSomething(String something){
        System.out.println(something);
    }
    public  int sum(int a,int b){
        return  a+b;
    }
}
