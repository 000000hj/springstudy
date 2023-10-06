package com.gdu.app08.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app08.dto.MemberDto;

@Configuration
public class MemberConfig {

  @Bean
  public MemberDto member1() {
    
    return new MemberDto(1,"김씨",150,60);
  }
  
  
  

  @Bean
  public MemberDto member2() {
    
    return new MemberDto(2,"이씨",170,90);
  }
  
  
  

  @Bean
  public MemberDto member3() {
    
    return new MemberDto(3,"박씨",160,50);
  }
  
}
