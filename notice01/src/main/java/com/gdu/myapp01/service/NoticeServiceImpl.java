package com.gdu.myapp01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdu.myapp01.dao.NoticeMapper;
import com.gdu.myapp01.dto.NoticeDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

  private final NoticeMapper noticeMapper;
  
  
  // 삽입
  @Override
  public int addNotice(NoticeDto noticeDto) {
    return noticeMapper.addNotice(noticeDto);
  }
  
  
  
  //전체조회
  
  
  @Override
  public List<NoticeDto>getNoticeList( ) {

    return noticeMapper.getNoticeList();// 매퍼에서 쿼리에 따라 조회된 목록을 받아와 반환한다.
  }
  
  
  //상세 조회
  
  
  
  
  //수정
  
  
  
  
  
  //삭제
  
  
  
}
