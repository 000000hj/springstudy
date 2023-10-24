package com.gdu.staff.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.staff.dto.StaffDto;

@Mapper
public interface StaffMapper {

  
 
  //(삽입)
   public int insertStaff(StaffDto staff);
   //getStaffList(전체 조회)
   public StaffDto getStaffList();
   //(조회)
   public StaffDto getStaff(String sno);
}
