package com.gdu.prj02.controller;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.prj02.dto.BoardDto;
import com.gdu.prj02.service.BoardService;
import com.gdu.prj02.service.BoardServiceImpl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;


//요청 방법
@RequiredArgsConstructor  // final BaordService에 Bean이 반드시 전달됨을 보증하는 Annotation이다.
@Controller
@Service // private BoardService boardServicw =new BoardService()  를 해서 Bean으로 저장;
public class BoardController {

  
  //일반 
/*  @RequestMapping(value = "/add.do" , method = RequestMethod.GET )
  public String add(HttpServletRequest request) { //요청 파라미터는 메소드 파라미터로 받습니다.
    int boardNo=Integer.parseInt(request.getParameter("boardNo"));
    String title=request.getParameter("title");
    System.out.println(boardNo+","+title);
    return "";
  }
  */
  
  
  
  //@RequestParam
  /*@RequestMapping(value = "/add.do" , method = RequestMethod.GET ) 
  public String add(@RequestParam(value = "boardNo",required = false,defaultValue = "0") int boardNo,@RequestParam(value = "title") String title) {
    
    System.out.println(boardNo+","+title);
    return "";
  }*/
  
  
  //위의 @RequestParam의 생략형
  
  /*@RequestMapping(value = "/add.do" , method = RequestMethod.GET ) 
  public String add(int boardNo , String title) {
    
    System.out.println(boardNo+","+title);
    return "";
  }
  */
  
  
  
  // 커맨드 객체
 /* @RequestMapping(value = "/add.do" , method = RequestMethod.GET ) 
  public String add(BoardDto boardDto) {
    
    System.out.println(boardDto);
    return "";
  }*/
  
  
  //1.필드DI
/*  @Autowired //@Service로 만들어진 Bean을 가져오세요.
  private BoardService boardService;
  */
  
  //2. Setter 형식의 메소드 DI
  /*private BoardService boardService;
  public void setBoardService(BoardService boardService) {
    this. boardService=boardService;
  }
  */
  
  
  
  
  //3. 생성자 DI
/*  private BoardService boardService;
  @Autowired
  public BoardController(BoardService boardService)
  {
    super();
    this.boardService=boardService;
  }
  */

  
  private  final BoardService boardService;
  
  
  
  @RequestMapping(value = "/add1.do" , method = RequestMethod.GET )
  public String add(HttpServletRequest request,Model model) { //요청 파라미터는 메소드 파라미터로 받습니다.
    int result=boardService.add1(request);
    model.addAttribute("result", result);  //JSP로 전달하는 result 속성입니다.
    return "output"; //output.jsp로 forward(JSP 경로를 작성합니다.)
  }
 
  
  
//@RequestParam
/*@RequestMapping(value = "/add2.do" , method = RequestMethod.GET ) 
  public String add(@RequestParam(value = "boardNo",required = false,defaultValue = "0") int boardNo,@RequestParam(value = "title") String title) {
    boardService.add2(boardNo, title);
   
    return "";
  }
  */
  
  
  
  
  // 커맨드 객체
  @RequestMapping(value = "/add3.do" , method = RequestMethod.GET ) 
  public String add3(BoardDto boardDto ,Model model,RedirectAttributes redirectAttributes) {
    int result=boardService.add3(request); 
    model.addAttribute("result",result)// Model은 redirect 할때 값을 전달하지 못합니다.
   redirectAttributes.addFlashAttribute("result",result); // 
    return "redirect:/output.do"; //output.do라는 새로운 요청(redirect)을 처리하시오.
  }
  
  
  
  @RequestMapping(value = "/output.do" ,method = RequestMethod.GET)
  public String output() {
    
    return "output";
    
  }
}
