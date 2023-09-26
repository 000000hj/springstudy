package com.gdu.app02.anno02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyjdbcService {
  
  
  private MyjdbcDao myjdbcDao;
  
  
  public void add() {
    myjdbcDao.add();
  }
  
  public void remove() {
    myjdbcDao.remove();
  }
  
  public void modify() {
    myjdbcDao.modify();
    
  }
  
  public void select() {
    myjdbcDao.select();
    
  }
}
