package com.gdu.myhome.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

  
  // response 쓰는 이유는 session 쓰려고.  // 로그인
  public void login(HttpServletRequest request, HttpServletResponse response);
  
  //로그아웃 
  public void logout(HttpServletRequest request, HttpServletResponse response);
  
}
