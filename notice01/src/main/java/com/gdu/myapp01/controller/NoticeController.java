package com.gdu.myapp01.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.myapp01.dto.NoticeDto;
import com.gdu.myapp01.service.NoticeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class NoticeController {

  
  private final NoticeService noticeService;
  
  //등록 화면으로 이동
  @RequestMapping(value = "/notice/write.do",method = RequestMethod.GET)
  public String write()
  { 
    return "notice/write";
    
  }
  
  
  
  //삽입
  //요청 파라미터 모아서 보내주는객체를 커맨드 객체라고 부름
  @RequestMapping(value = "/notice/save.do" ,method = RequestMethod.POST)
  public String save(NoticeDto noticeDto ,RedirectAttributes redirectAttributes) {
   int addResult=noticeService.addNotice(noticeDto);
     redirectAttributes.addFlashAttribute("addResult",addResult);
    
    return "redirect:/notice/list.do";
  }
  
  
  
  //수정
  @RequestMapping(value = "/notice/modify.do" ,method = RequestMethod.POST)
  public String modify(NoticeDto noticeDto,RedirectAttributes redirectAttributes) {
    int modifyResult=noticeService.modifyNotice(noticeDto);
    redirectAttributes.addFlashAttribute("modifyResult",modifyResult);
    return "redirect:/notice/detail.do?="+noticeDto.getNoticeNo();
  }
  
  
  //전체 조회
  
  @RequestMapping(value = "/notice/list.do" ,method = RequestMethod.GET)
  public String list(Model model) {  //forward할 데이터는 Model 에 저장한다.
    List<NoticeDto> noticeList=noticeService.getNoticeList();
    model.addAttribute("noticeList",noticeList);
    return "/notice/list";
  }
  
  
  
  
  
  //상세조회
  @RequestMapping(value = "/notice/detail.do" ,method = RequestMethod.GET)
  public String detail(@RequestParam int noticeNo ,Model model) {
    NoticeDto noticeDto = noticeService.getNotice(noticeNo);
    model.addAttribute("notice",noticeDto);  // notice 폴더 아래 detail.jsp로 notice 를 보낸다.
    return "/notice/detail";
  }
  
  
  //삭제
  public String delete() {
    
    return "";
  }
  
  
}
