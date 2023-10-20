package com.gdu.myhome.service;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.gdu.myhome.dao.UserMapper;
import com.gdu.myhome.dto.UserDto;
import com.gdu.myhome.util.MySecurityUtils;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service


public class UserServiceImpl implements UserService {

  private final UserMapper userMapper;
  private final MySecurityUtils mySecurityUtils;

@Override
//서비스가 void 반환이면 스스로 응답해야함.
public void login(HttpServletRequest request, HttpServletResponse response) {

  String email=request.getParameter("email");
  // 사용자가 보낸 비밀번호가 암호화 처리된다.!!
  String pw=mySecurityUtils.getSHA256(request.getParameter("pw"));
  
  Map<String, Object>map=Map.of("email",email,"pw",pw);
  
  UserDto user =userMapper.getUser(map);
  
  //로그인 처리
  
  //성공시
  if( user != null ) {
      
    // 세션에 유저정보를 통째로 올려.   왕왕왕왕 중요 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        request.getSession().setAttribute("user", user);
    // 접속기록 남겨  
        userMapper.insertAccess(email);
    
   //in up de   - > redirect
     // 메인 페이지로 되돌아가
        try {
          
          response.sendRedirect(request.getParameter("referer"));
          
          
        } catch (Exception e) {
          e.printStackTrace();
        }
        
    
        
  }else {
    try {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out=response.getWriter();
      
      
      out.println("<script>");
      out.println("alert('일치하는 회원 정보가 없습니다.')");
      //로그인 페이지로 돌아간다.  //history.back()  휴면처리 구간에서 걸릴 수 있어서 안써
      out.println("location.href='"+request.getContextPath()+"/main.do'");
      out.println("</script>");
      out.flush();
      out.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
  
}



@Override
public void logout(HttpServletRequest request, HttpServletResponse response) {

  HttpSession session = request.getSession();
  
  // 세션 초기화
  session.invalidate();
  
  
  try {
    response.sendRedirect(request.getContextPath()+"/main.do");
  } catch (Exception e) {
    e.printStackTrace();
  }
}



}
