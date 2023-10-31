package com.gdu.myhome.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.myhome.dto.BlogDto;

public interface BlogService {
  public Map<String, Object> imageUpload(MultipartHttpServletRequest multipartRequest);
  public int addBlog(HttpServletRequest request);
  public void blogImageBatch();
  public void loadBlogList(HttpServletRequest request,Model model); // 리스트 , String으로 모든 전달이 어려우니 Model로 전달하고 니가 알아서 다해. 반환 없음.
                                                                    // 리퀘스트는 추후의 다른 전달을 대비한것
  public int increaseHit(int BlogNo);
  public BlogDto getBlog(int blogNo);
  public int modifyBlog(HttpServletRequest request);
  public int removeBlog(int blogNo);
  public Map<String, Object>addComment(HttpServletRequest request);
  public Map<String, Object> loadCommentList(HttpServletRequest request);       
  public Map<String, Object>addCommentReply(HttpServletRequest request);
  public Map<String, Object>removeComment(int commentNo);
 
}