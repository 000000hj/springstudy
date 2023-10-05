package com.gdu.app05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gdu.app05.service.BoardService;
import com.gdu.app05.service.BoardServiceImpl;


//스프링에게 가져다 쓰라고 명시해주는게 컴포넌트
@Controller //컨트롤러 전용 컴포넌트 @Component
public class BoardController {

  /*
   * DI
   * 1. Dependency Injection
   * 2. Spring Container에 저장된 객체를 가져오는 방식이다.
   * 3. 주요 Annotation
   *  1) @Inject
   *    (1) javax.inject.Inject
   *    (2) 타입이 일치하는 객체를 찾아서 가져온다. 없으면 오류가 발생한다.
   *    (3) 동일한 타입의 객체가 2개 이상 있다면 이름이 일치하는 객체를 가져온다.
   *  2) @Resource
   *    (1) javax.annotation.Resource
   *    (2) javax-annotation-api dependency를 pom.xml에 추가해야 사용할 수 있다.
   *      <!-- https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api -->
   *      <dependency>
   *        <groupId>javax.annotation</groupId>
   *        <artifactId>javax.annotation-api</artifactId>
   *        <version>1.3.2</version>
   *      </dependency>
   *    (3) 이름이 일치하는 객체를 찾아서 가져온다. 없으면 오류가 발생한다.
   *  3) @Autowired
   *    (1) org.springframework.beans.factory.annotation.Autowired
   *    (2) @Inject 기반의 Spring Annotation이다. (타입 기반)
   *    (3) 객체 이름을 기준으로 가져올 수 있도록 @Qualifier(org.springframework.beans.factory.annotation.Qualifier)를 사용할 수 있다.
   */
  
  /*
   * BoardService DI 처리 방법
   * 
   * 1. BoardService 타입의 BoardServiceImpl 객체를 Spring Container에 넣는다. (아래 3가지 방법 중 하나 이용)
   *  1) <bean> 태그            : /WEB-INF/spring/root-context.xml
   *  2) @Configuration + @Bean : com.gdu.app05.config.AppConfig.java
   *  3) @Component
   * 
   * 2. @Autowired를 이용해서 Spring Container에서 BoardService 타입의 객체를 가져온다. (아래 3가지 방법 중 하나 이용)
   *  1) 필드에 주입하기
   *  2) 생성자에 주입하기
   *  3) Setter 형식의 메소드에 주입하기
   */
  
  
  
  
  /*****************************DI********************************/
 /* 
  * @Autowired
  private BoardService boardService = new BoardServiceImpl();
  와 같은것을 의미하는 @Autowired 방식 3가지(컨테이너에 저장된정보를 자동으로 가져오는 방법)
  */

  
  private final BoardService boardService;
  
  
  

  //BoardService에 final처리를 하면 생성자 주입만 가능하다. (필드 주입과 Setter주입은 불가능하다)
  //Autowired는 생략할 수 있으므로 @RequiredArgsConstructor와 같은 Annotation으로 대체할 수 있다.
  
  //2. 생성자에 Autowired를 붙여줄것

  @Autowired
  public BoardController(BoardService boardService) {
super();
this.boardService=boardService;
  }


  //3. 세터에 Autowired를 붙여줄것
  /*
   * @Autowired
  public void setBoardService(BoardService boardService) {
    this.boardService = boardService;
  }
  */
/*****************************Method********************************/
  @RequestMapping(value="/board/list.do", method=RequestMethod.GET)
  public String list(Model model) {
    model.addAttribute("boardList", boardService.getBoardList());
    return "board/list";
  }
  


  

  
  
}