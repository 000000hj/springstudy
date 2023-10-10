package com.gdu.app08.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;




@Service
public class ShopServiceImpl implements ShopService {


@Override
public Map<String, Object> getSearchInfo(String query) {
 
  

  /*
   * 네이버개발자센터 - 검색(블로그)
   * 1. 요청주소 : https://openapi.naver.com/v1/search/blog.json
   * 2. 요청변수
   *    1) query   : 필수, 인코딩된 검색어
   *    2) display : 선택, 10 (검색 결과의 개수)
   *    3) start   : 선택, 1
   *    4) sort    : 선택, sim (sim 또는 date)
   */
  
  
  
  
  URL url = null;
  HttpURLConnection con = null;
  BufferedReader reader = null;
  
  
  String spec =null;
  String display=null;
  String start=null;
  String sort=null ;
  String clientId=null;
  String clientSecret=null;
  String title=null;
  JSONArray items=null;
  JSONObject item=null;
  int count=0;
  try {
    
  spec = "https://openapi.naver.com/v1/search/shop.json";
  display = "10";
  start = "1";
  sort = "sim";
  clientId = "RTJMyHb54a63lvLzPh7A";
  clientSecret = "0xR9yv0oo3";
    
    StringBuilder sbUrl = new StringBuilder();
    sbUrl.append(spec);
    sbUrl.append("?query=").append(URLEncoder.encode(query, "UTF-8"));
    sbUrl.append("&display=").append(display);
    sbUrl.append("&start=").append(start);
    sbUrl.append("&sort=").append(sort);
    
    url = new URL(sbUrl.toString());
    con = (HttpURLConnection) url.openConnection();
    
    // 요청 메소드
    con.setRequestMethod("GET");  // 반드시 대문자 GET
    
    // 요청 헤더
    con.setRequestProperty("X-Naver-Client-Id", clientId);
    con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
    
    int responseCode = con.getResponseCode();
    if(responseCode != HttpURLConnection.HTTP_OK) {
      throw new RuntimeException(responseCode + " 발생");
    }
    
    reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
    
    StringBuilder sb = new StringBuilder();
    String line = null;
    while((line = reader.readLine()) != null) {
      sb.append(line + "\n");
    }
    
    JSONObject obj = new JSONObject(sb.toString());
    items = obj.getJSONArray("items");
    for(int i = 0, length = items.length(); i < length; i++) {
      item = items.getJSONObject(i);
      count=items.length();
      title=item.getString("title");
      
      
      

      
    }
    
  } catch (Exception e) {
    System.out.println(e.getMessage());
  } finally {
    try {
      if(reader != null) reader.close();
      if(con != null) con.disconnect();
    } catch (Exception e) {
      e.printStackTrace();
    }
  
  }
  
  

  
  
  return Map.of("title",title,"items",items);
}


}

