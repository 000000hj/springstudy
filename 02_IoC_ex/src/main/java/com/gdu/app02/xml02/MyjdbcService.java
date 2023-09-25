package com.gdu.app02.xml02;

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
