package com.gdu.myapp01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.myapp01.dto.NoticeDto;

/*
 * @Mapper
 * 1. 매퍼의 쿼리문을 호출할 수 있는 인터페이스에 추가하는 마이바티스 어노테이션이다.
 * 2. 메소드이름과 호출할 쿼리문의 아이디(id)을 동일하게 맞추면 자동으로 호출된다.
 * 3. @Mapper로 등록된 인터페이스의 검색이 가능하도록 @MapperScan을 추가해야 한다. (SqlSessionTemplate Bean이 등록된 AppConfig.java에 추가한다.)
 * 4. 매퍼의 namespace값을 인터페이스 경로로 작성한다.
 */

@Mapper
public interface NoticeMapper {
   public List<NoticeDto> getNoticeList(); // 넘겨줄것은 없고 NoticeDto가 들은 리스트 타입을 dao(mapper)로 부터 받는다.
   public int addNotice(NoticeDto noticeDto); // 삽입
   public int deleteNotice(int noticeNo); // 삭제
   public int modifyNotice(NoticeDto noticeDto);// 수정
   public NoticeDto getNotice(int noticeNo);//상세보기
}