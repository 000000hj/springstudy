package com.gdu.staff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.staff.dao.StaffMapper;
import com.gdu.staff.dto.StaffDto;


// JUnit4를 이용한다.
@RunWith(SpringJUnit4ClassRunner.class)

// ContactDao Bean 생성 방법을 알려준다.
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")


public class StaffUnitTest {

  @Autowired  // Spring Container에서 ContactDao 객체(Bean)를 가져온다.
  private StaffMapper staffMapper;
    
  //테스트 전에 수행
  @Before
  public void test01_삽입테스트() {
   StaffDto staff=new StaffDto("12334","김기자","기자부",5000);
   int addResult=staffMapper.insertStaff(staff);
   assertEquals(1, addResult); // addResult가 1 나왓으면 좋겟어
  }
  
  @Test  //조회 테스트
  public void test02_조회테스트() {
  String sno="99999";
  StaffDto staff=staffMapper.getStaff(sno);  // 사원번호 99999 전달 . 조회되면 잇음 , 안되면 없음
  assertNotNull(staff); // null이 아니면 조회 성공
  }
  
  
  


}