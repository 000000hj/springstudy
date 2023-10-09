package com.gdu.prj02.dao;

import org.springframework.stereotype.Repository;

import com.gdu.prj02.dto.BoardDto;


@Repository
public class BoardDao {

  public int insertBoard1(BoardDto boardDto)
  {
    System.out.println(boardDto);
    return 1;
  }
  
  
  
  public int  insertBoard2(BoardDto boardDto)
  {
    System.out.println(boardDto);
    return 1;
  }
  
  
  
  public int insertBoard3(BoardDto boardDto)
  {
    
    System.out.println(boardDto);
    return 1;
    
  }
  
}
