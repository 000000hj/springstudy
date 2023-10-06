package com.gdu.app05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gdu.app05.dao.BoardDao;
import com.gdu.app05.dto.BoardDto;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor // fianl 필드 전용 생성자
                        // Autowired를 이용한 생성자 주입을 위해서 추가한다.

//서비스 전용 컴포넌트 (@Component가 포함되어 있다,서비스 계층 (Business 계층),Spring Container에 BoardService boardServiceImpl 객체를 생성해 둔다.)
@Service
public class BoardServiceImpl implements BoardService {
  
  //Autowired 붙이는 방법 3가지중 택 1(컨테이너에 저장된걸 자동으로 가져오는방법)
  
  //1.필드에 붙이겠다
  private final BoardDao boardDao;

  
////2.생성자에 붙이겠다
 /* @Autowired // 없어도 컨테이너의 정보를 가져옴
  // 따라서 생성자 만 있어도 적용됨.
   // lombok의 allargsContsturctor로 대체.
  public BoardServiceImpl(BoardDao boardDao) {
    super();
    this.boardDao=boardDao;
 }*/
  
 
//
//  //3.세터에 붙이겠다
//  @Autowired
//  public void setBoardDao(BoardDao boardDao) {
//    this.boardDao = boardDao;
//  }

  
 
  
  
  @Override
  public List<BoardDto> getBoardList() {
    return boardDao.getBoardList();
  }


}