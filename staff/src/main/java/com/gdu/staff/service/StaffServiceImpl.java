package com.gdu.staff.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gdu.staff.dao.StaffMapper;
import com.gdu.staff.dto.StaffDto;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class StaffServiceImpl implements StaffService {

  private final StaffMapper staffMapper;
  
  @Override
  //리스폰스엔티티는 httpstatus 상태값을 저장한다. 예외를 구별하기 위해 삽입
  public ResponseEntity<Map<String, Object>> registerStaff(StaffDto staff) {
    int addResult=0;
    Map<String, Object>map = new HashMap<>();
    try {
      addResult=staffMapper.insertStaff(staff);
      map.put("addResult", addResult);
      // 이 맵은 success로 간다.
      return new ResponseEntity<>(map,HttpStatus.OK);
           
    } catch (Exception e) {
     //insert 실패시 
      //map만 만들고 반환한다.
      // 이 맵은 error로 간다.
      map.put("addResult", addResult);
      return new  ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
  
  }


  
  @Override
  public ResponseEntity<Map<String, Object>> getStaffList(StaffDto staff) {

    Map<String, Object>map= new HashMap<>();
    map.put("sno",staff.getSno());
    map.put("name",staff.getName());
    map.put("dept",staff.getDept());
    map.put("salary",staff.getSalary());
    
    return new ResponseEntity<>(Map.of("staff",map),HttpStatus.OK);
  }

}
