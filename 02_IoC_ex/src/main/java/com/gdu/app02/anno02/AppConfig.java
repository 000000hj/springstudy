package com.gdu.app02.anno02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  

  
  //myjdbc커넥션 객체
  
  @Bean
  public MyjdbcConnection myjdbcConnection() {
    
    MyjdbcConnection myjdbcConnection=new MyjdbcConnection();
    myjdbcConnection.setDriver("oracle.jdbc.OracleDriver");
    myjdbcConnection.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
    myjdbcConnection.setUser("GD");
    myjdbcConnection.setPassword("1111");
    
    return myjdbcConnection;
    
  }
 
  // dao 객체
  @Bean
  public MyjdbcDao dao () {
    
    
    return new MyjdbcDao();
    
    
  }
  
  

  
  //서비스 객체
  @Bean
  public MyjdbcService service() {
    return new MyjdbcService(dao());
    
  }
  
  
}
