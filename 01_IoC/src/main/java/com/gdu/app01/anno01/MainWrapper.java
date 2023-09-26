package com.gdu.app01.anno01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainWrapper {

  
  
  
  public static void ex01()
{
  //AppConfig.java 에 등록된 Bean 생성 하기
  AbstractApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
  
  //bean 가져오기
  Calculator calc=ctx.getBean("calc",Calculator.class);
  
  calc.add(1, 2);
  calc.sub(3, 4);
  calc.mul(5, 6);
  calc.div(7, 8);
  
  //ctx닫기
  ctx.close();
}
  public static void ex02() {
    
    //com.gud.app01.anno01 패키지에 정의된 bean을 생성
    //config 파일이 여러개 있을 때 유용
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext("com.gdu.app01.anno01");
    Person man=ctx.getBean("man",Person.class);
    Person woman=ctx.getBean("woman",Person.class);
    
   System.out.println(man.getAge()+","+man.getName()+",");
   
   man.getCalc().add(1, 2);
   System.out.println(woman.getAge()+","+woman.getName()+",");
   woman.getCalc().add(3, 2);
  }
  
  
  public static void main(String[] args) {
    
    ex02();
    
  }

}
