package com.gdu.app13.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app13.util.MyFileUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService {

  private final MyFileUtil myFileUtil;
  
  @Override
  public int upload(MultipartHttpServletRequest multipartRequest) {

    // 첨부된 파일들의 목록
    List<MultipartFile> files = multipartRequest.getFiles("files");
    
    // 순회
    for(MultipartFile multipartFile : files) {
      
      // 첨부 여부 확인
      if(multipartFile != null && !multipartFile.isEmpty()) {
        
        try {
          
          // 첨부 파일이 저장될 경로 가져오기
          String path = myFileUtil.getPath();
          
          // 저장될 경로의 디렉터리 만들기
          File dir = new File(path);
          if(!dir.exists()) {
            dir.mkdirs();
          }
          
          // 첨부 파일의 원래 이름 알아내기
          String originalName = multipartFile.getOriginalFilename();
          
          // 첨부 파일이 저장될 이름 가져오기
          String filesystemName = myFileUtil.getFilesystemName(originalName);
          
          // 첨부 파일의 File 객체
          File file = new File(dir, filesystemName);
          
          // 첨부 파일 저장하기
          multipartFile.transferTo(file);
          
        } catch (Exception e) {
          e.printStackTrace();
        }
        
      }
      
    }
    
    return 0;
    
  }
  
  //디비에는 이미지태그로 저장됨
  /// spring7장 ajax 4번 controller 방식으로도 할  수 있음. 요청주소만 고치면 복붙으로도 사용 가능(직접 설정 방식)
  @Override
  public Map<String, Object> ajaxUpload(MultipartHttpServletRequest multipartRequest) {
    
    // 첨부된 파일들의 목록
    List<MultipartFile> files = multipartRequest.getFiles("files");
    
    // 순회
    for(MultipartFile multipartFile : files) {
      
      // 첨부 여부 확인
      if(multipartFile != null && !multipartFile.isEmpty()) {
        
        try {
          
          // 첨부 파일이 저장될 경로 가져오기
          String path = myFileUtil.getPath();
          
          // 저장될 경로의 디렉터리 만들기
          File dir = new File(path);
          if(!dir.exists()) {
            dir.mkdirs();
          }
          
          // 첨부 파일의 원래 이름 알아내기
          String originalName = multipartFile.getOriginalFilename();
          
          // 첨부 파일이 저장될 이름 가져오기
          String filesystemName = myFileUtil.getFilesystemName(originalName);
          
          // 첨부 파일의 File 객체
          File file = new File(dir, filesystemName);
          
          // 첨부 파일 저장하기
          multipartFile.transferTo(file);
          
        } catch (Exception e) {
          e.printStackTrace();
        }
        
      }
      
    }
    
    return Map.of("success", true);
    
  }  
  
  
  
  //upload 가 첨부파일임
  @Override
  public Map<String, Object> ckeditorUpload(MultipartFile upload ,String contextPath) {

    //이미지 저장할 경로 
   
    String path=myFileUtil.getPath();
    File dir=new File(path);
    
    if(!dir.exists())
    {
      dir.mkdirs();
      
    }
    
    //이미지 저장할 이름 (원래 이름 + 저장할 이름)
    String originalFilename =upload.getOriginalFilename();
    String fileSystemName=myFileUtil.getFilesystemName(originalFilename);
    
    //이미지 File 객체
    File file = new File(dir ,fileSystemName);
    
    // File 객체를 참고하여, MultipartFile upload 첨부 이미지 저장
    try {
      
      upload.transferTo(file);
      
    } catch (Exception e) {
      
      e.printStackTrace();
    }
    
    //CKEditor로 저장된 이미지를 확인할 수 있는 경로를 {url: http://localhost:8080/app13...}방식으로 반환해야 함
    
    return Map.of("url",contextPath +path+"/"+fileSystemName,"uploaded",true);
    
    /* http://localhost:8080/app13/storage/2023/10/18/파일이름.jpg
                       
                      /storage/**  주소로 요청하면 
                      /storage/ 디렉터리의 내용을 보여주세요
    
    
    // CKEditor에 반환할 url
    http://localhost:8080/app13/storage/2023/10/18/23d478292f9b4ae88c19d1bddae550c1.jpg
     
     
    // 
     
    //  
    */
  }

}