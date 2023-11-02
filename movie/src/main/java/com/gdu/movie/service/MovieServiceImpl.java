package com.gdu.movie.service;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.gdu.movie.dao.MovieMapper;
import com.gdu.movie.dto.MovieDto;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
  private final MovieMapper movieMapper;
  
  
  
  @Override
  public Map<String, Object> getMovieList() {
    
    int movieCount = movieMapper.getMovieCount();
    List<MovieDto>list=movieMapper.getMovieList();
    
    return Map.of("message","전체"+movieCount+"개의 목록을 가져왔습니다."
        ,"list",list
        ,"status",200);
  }
  
  
  @Override
  public Map<String, Object> getSearchList(HttpServletRequest request) {
    
    String column=request.getParameter("column");
    String searchText=request.getParameter("searchText");
   
    
    Map<String, Object> map = new HashMap<>();
    map.put("column", column);
    map.put("searchText", searchText);
    int movieCount = movieMapper.getSearchCount(map);
    List<MovieDto>movieList=movieMapper.getSearchList(map);
    if(movieCount==0)
    {
    return Map.of("message",searchText+" 검색 결과가 없습니다.","movieList",movieList,"movieCount",movieCount);
    }
    else {
      return Map.of("message",movieCount+"개의 검색 결과가 있습니다.","movieList",movieList);
    }
    
    
  }
  
  @Override
  public void FindComedySchedule() {

    
    String column;
    String searchText;
   
    
    Map<String, Object> map = new HashMap<>();
    map.put("column", "GENRE");
    map.put("searchText", "코미디");
    int movieCount = movieMapper.getSearchCount(map);
    List<MovieDto>movieList=movieMapper.getSearchList(map);
    
    File file;
    FileWriter fw=null;
    String str="";
    
 
      
      if(movieCount!=0)
      {
        file=new File("코미디.txt");
        
        str="제목";
        System.out.println(file.getPath()+"파일생성완료");
      }
      else {
        file=new File("error.txt");
         str="코미디 검색 결과가 없습니다.";
      }
      
      
      
      
 
    
    
    
  }
}
