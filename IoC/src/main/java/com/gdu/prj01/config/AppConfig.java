package com.gdu.prj01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.prj01.dto.BoardDto;
import com.gdu.prj01.dto.UserDto;

@Configuration   // 이 클래스는 Bean을 만드는 클래스입니다.
public class AppConfig {

  
 @Bean // 이 메소드는 Bean 입니다.
 public UserDto user3() {// 메소드의 이름이 Bean의 id 입니다.
   
   UserDto user=new UserDto();
   user.setUserNo(3);
   user.setUserId("myId");
   return  user;
 }
 
 
 @Bean
 public BoardDto board3() {
   BoardDto board=new BoardDto();
   board.setBoardNo(3);
   board.setTitle("title1");
   board.setUserDto(user3());  // 다른 Bean을 가져올때는 해당 Bean의 메소드를 호출 합니다.
 
   
   return board;
 }
 
}
