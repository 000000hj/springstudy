package com.gdu.app01.anno03;


import java.util.Map;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class MainWrapper {

  public static void main(String[] args) {

    
    
    AbstractApplicationContext ctx= new AnnotationConfigApplicationContext(AppConfig.class);
    
    //객체 가져오기
    Student s =ctx.getBean("student",Student.class);
    
    //확인
    for(String subject: s.getSubjects())
    {
      System.out.println(subject);
    }
    
    
    for(String contact:s.getContacts())
    {
      System.out.println(contact);
    }
     
    for(Map.Entry<String,String>entry:s.getFriends().entrySet()) {
      
      System.out.println(entry.getKey()+","+entry.getValue());
    }
    
    //app-context.xml 파일 닫기
    ctx.close();
  }
}

