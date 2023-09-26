package com.gdu.app02.anno01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
  private Calculator calculator; //bmi 계산 위한 계산기
  private String name;
  private double height;//cm
  private double weight;//kg
  private double bmi;  // 몸무게 / (키*키 /10000)
  private String status;//<20 : 저체중, <25 정상 ,<30 과체중 ,비만
}
