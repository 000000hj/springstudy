package com.gdu.app02.xml02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainWrapper {

  public static void main(String[] args) {

    AbstractApplicationContext ctx=new GenericXmlApplicationContext("xml02/appCtx.xml");
    MyjdbcService myjdbcService=ctx.getBean("service",MyjdbcService.class);
    myjdbcService.add();
    myjdbcService.remove();
    myjdbcService.modify();
    myjdbcService.select();
    ctx.close();
    
  }

}
