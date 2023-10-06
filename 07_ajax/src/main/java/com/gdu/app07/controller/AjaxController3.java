package com.gdu.app07.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gdu.app07.dto.AjaxDto;
import com.gdu.app07.service.AjaxService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/ajax3")
@RequiredArgsConstructor
@Controller
public class AjaxController3 {

  private final AjaxService ajaxService;
  
  @RequestMapping(value = "/list.do",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
  public ResponseEntity<List<AjaxDto>> list(){ //ResponseEntity는 @ResponseBody를 작성하지 않는다.
    return new ResponseEntity<List<AjaxDto>>(ajaxService.getDtoList() //실제 응답 데이터
                                             ,HttpStatus.OK);         // 응답 코드(200)
    
    
  }
  

  
  @PostMapping(value = "/detail.do",produces = "application/json; charset=UTF-8")
  public ResponseEntity<AjaxDto> detail(@RequestBody AjaxDto ajaxDto ){// post방식(@RequestBody)으로 전송된 JSON 데이터(AjaxDto ajaxDto)는
  // 응답 헤더 : Content-Type (produces = "application/json; charset=UTF-8"을 대체한다.)
   HttpHeaders header=new HttpHeaders();
   header.add("Content-Type", "application/json; charset=UTF-8");
    
   //반환
   return new ResponseEntity<AjaxDto>(ajaxService.getDto(ajaxDto.getName())       //실제 응답 데이터
                                                                 , header         //응답헤더
                                                                 , HttpStatus.OK);//응답 코드(200)
  }
  
  
  
}
