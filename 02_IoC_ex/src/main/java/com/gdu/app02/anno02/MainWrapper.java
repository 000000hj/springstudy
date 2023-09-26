package com.gdu.app02.anno02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class MainWrapper {

  public static void main(String[] args) {

    AbstractApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
    
    //서비스
    MyjdbcService myjdbcService=ctx.getBean("MyjdbcService",MyjdbcService.class);
    myjdbcService.add();
    myjdbcService.remove();
    myjdbcService.modify();
    myjdbcService.select();
    
    

    ctx.close();
    
  }

}
