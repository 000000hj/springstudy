package com.gdu.app01.anno01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




@Configuration //IocContainer에 bean을 등록하는 클래스이다.
public class AppConfig {

  //메소드를 bean으로 등록하기 위해서  @Bean 추가한다.
  //반환타입 ==빈의 클래스
  //메소드명 ==빈의 아이디
  @Bean
  public  Calculator calc() {
    
    
    return new Calculator();
  }
  
  @Bean
  public Person man() {
    Person person =new Person();
    person.setAge(1);
    person.setName("박남자");
    person.setCalc(calc());
    return person;
   
  }
  
  
  @Bean
  public Person woman() {
    Person person =new Person();
    person.setAge(2);
    person.setName("김여자");
    person.setCalc(calc());
    return person;
   
  }
  
}
