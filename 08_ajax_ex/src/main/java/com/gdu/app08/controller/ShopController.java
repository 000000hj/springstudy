package com.gdu.app08.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app08.service.ShopService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class ShopController {

  private final ShopService shopService;
  
  @ResponseBody
  @GetMapping(value = "/shop/query.search",produces="application/json; charset=UTF-8")
  public Map<String, Object>searchInfo(@RequestParam("query") String query){
    return shopService.getResult(query);
  }
  
  
}
