package com.gdu.myhome.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {
  private int userNo;
  private String email;
  private String pw;
  private String name;
  private String gender;
  private String mobile;
  private String postcode;
  private String roadAddress;
  private String jibunAddress;
  private String detailAddress;
  private int agree;   // value가 int 타입이 아닌  on 또는 off라서 UserDto형태로 받을 수 없다(커맨드 객체) 
  private Date pwModifiedAt ;
  private Date joinedAt ;
}