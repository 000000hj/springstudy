package com.gdu.myapp01.service;

import java.util.List;

import com.gdu.myapp01.dto.NoticeDto;

public interface NoticeService {

public List<NoticeDto> getNoticeList();
public int addNotice(NoticeDto noticeDto); // insert는 int로 받기로 약속됨.

  
}
