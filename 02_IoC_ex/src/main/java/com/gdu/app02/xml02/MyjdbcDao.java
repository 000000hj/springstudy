package com.gdu.app02.xml02;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyjdbcDao {
  private Connection con;
  
  
 private AbstractApplicationContext ctx;
 private MyjdbcConnection myjdbcConnection;
 
//반환값 MyjdbcConnection 클래스의 getConnection() 메소드를 호출
  public Connection getConnection() {
    ctx=new GenericXmlApplicationContext("xml02/appCtx.xml");
    myjdbcConnection=ctx.getBean("myjdbcConnection",MyjdbcConnection.class);
    ctx.close();
    return myjdbcConnection.getConnection();
  }
  
  

  
  private void close() {
    
    try {
      if(con!=null) {
        con.close();
        System.out.println(myjdbcConnection.getUser()+"접속 해제");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  
  public void add() {
  con= getConnection();
    System.out.println("add()호출");
   close();
  }
  
  public void remove(){
    con=getConnection();
    System.out.println("remove()호출");
   close();
    
  }

  public void modify() {
    con=getConnection();
    System.out.println("modify()호출");
   close();
  }
  
  public void select() {
    con=getConnection();
    System.out.println("select()호출");
   close();
  }

}
