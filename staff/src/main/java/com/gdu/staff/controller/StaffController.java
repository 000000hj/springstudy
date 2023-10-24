package com.gdu.staff.controller;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.staff.dto.StaffDto;
import com.gdu.staff.service.StaffService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class StaffController {

  
    private final StaffService staffService;
    
    //등록해라
    @PostMapping(value = "/add.do" ,produces = "application/json")
    public ResponseEntity<Map<String, Object>>add(StaffDto staff) {
      return staffService.registerStaff(staff);
    }
    
    //목록 보여줘
    @GetMapping(value="/list.do", produces="application/json")
    public ResponseEntity<Map<String, Object>> list(@RequestParam StaffDto staff) {
      System.out.println("에엑따:"+staff.toString());
      return staffService.getStaffList(staff);
    }
    
    }
   
    

