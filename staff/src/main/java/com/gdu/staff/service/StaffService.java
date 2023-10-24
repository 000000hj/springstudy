package com.gdu.staff.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.gdu.staff.dto.StaffDto;

public interface StaffService {
  // 사원 등록
  public ResponseEntity<Map<String, Object>> registerStaff(StaffDto staff); 
  // 사원  목록 조회
  public ResponseEntity<Map<String, Object>> getStaffList(StaffDto staff);
}
