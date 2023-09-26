package com.gdu.app02.anno01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainWrapper {

  public static void main(String[] args) {

    AbstractApplicationContext ctx= new AnnotationConfigApplicationContext(AppConfig.class);
    
    Fitness f= ctx.getBean("fitness",Fitness.class);
    
    System.out.println("헬스장:"+f.getName());
    System.out.println(f.getName()+"회원:");
    f.info();
    
    ctx.close();
  }

}
