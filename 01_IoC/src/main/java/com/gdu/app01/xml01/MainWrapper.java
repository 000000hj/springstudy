package com.gdu.app01.xml01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainWrapper {

  public static void ex01() {
    
    // app-context.xml 파일 읽기 (여기에서 <bean> 태그로 정의해 둔 객체가 생성된다.)
    GenericXmlApplicationContext ctx= new GenericXmlApplicationContext("xml01/app-context.xml");
    
    
    //<bean> 태그로 정의된 객체 가져오기
    Calculator calculator=(Calculator)ctx.getBean("calc");  // ctx.getBean("calc",Calculator.calss);  코드도 동일한 역할을 수행
    
    //객체 사용해 보기
    calculator.add(1, 2);
    calculator.sub(3, 4);
    calculator.mul(5, 6);
    calculator.div(7, 8);
   
    
    // app-context.xml 파일 닫기
    ctx.close();
    
  }
  public static void ex02() {
    
    //app-context.xml파일 읽어서 <bean> 태그로 정의된 객체 만들기
    AbstractApplicationContext ctx= new ClassPathXmlApplicationContext("xml01/app-context.xml");
    
    //객체 가져오기
    Person man=(Person)ctx.getBean("man");
    Person woman=ctx.getBean("woman",Person.class);
    
    System.out.println(man.getName()+","+man.getAge());
    man.getCalc().add(1, 2);
    
    System.out.println(woman.getName()+","+woman.getAge());
    woman.getCalc().add(1, 2);
    
    //app-context.xml 파일 닫기
    ctx.close();
  }
  public static void main(String[] args) {
    ex02();

  }

}
