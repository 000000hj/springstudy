package com.gdu.app01.anno01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Calculator {

  //no field 
  
  //default constructor
  
  //method
  
  public void add(int a,int b)
  {
    System.out.println(a+"+"+b+"="+(a+b));
  }
  
  public void sub(int a,int b)
  {
    System.out.println(a+"-"+b+"="+(a-b));
  }
  
  public void mul(int a,int b)
  {
    System.out.println(a+"x"+b+"="+(a*b));
  }
  
  public void div(int a,int b)
  {
    System.out.println(a+"/"+b+"="+(a/b));
  }
}
