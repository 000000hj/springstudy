package com.gdu.myhome.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.myhome.service.UserService;

import lombok.RequiredArgsConstructor;

@RequestMapping(value="/user")
@RequiredArgsConstructor
@Controller
public class UserController {
  
  private final UserService userService;
  
  @GetMapping("/login.form")
  public String loginForm(HttpServletRequest request, Model model) {
    // referer  : 이전 주소가 저장되는 요청 Header 값
    String referer=request.getHeader("referer");
    model.addAttribute("referer",referer == null ? request.getContextPath()+"/main.do":referer);
    return "user/login";
  }
  
  @PostMapping("/login.do")
  public void login(HttpServletRequest request, HttpServletResponse response) {
    userService.login(request, response);
  }
  
  @GetMapping("/logout.do")
  public void logout(HttpServletRequest request, HttpServletResponse response) {
    userService.logout(request, response);
  }
  
  @GetMapping("/agree.form")
  public String agreeForm() {
    
    return "user/agree";
  }
  
  
  
  @GetMapping("/join.form")
  public String joinForm(@RequestParam(value = "event",required = false,defaultValue = "off")  String service,
                         @RequestParam(value = "event",required = false,defaultValue = "off")  String event 
                                         ,Model model) {
    
    
    // 주소창에 직접 입력해서 접속할 시  메인 화면으로 리다이렉트 시켜버릴것
    String rtn=null;
   if(service.equals("off")) {
     rtn="redirect:/main.do";
   }else {

     model.addAttribute("event",event); //user 폴더 join.jsp 전달하는 event 는 "on" 또느 "off" 값을 가진다.
    rtn="user/join";
  }
    
   
   return  rtn; 
    
  }
  
  
}