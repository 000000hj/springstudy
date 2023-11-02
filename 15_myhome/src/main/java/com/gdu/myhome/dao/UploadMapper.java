package com.gdu.myhome.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.myhome.dto.AttachDto;
import com.gdu.myhome.dto.UploadDto;

@Mapper
public interface UploadMapper {
  public int insertUpload(UploadDto upload);
  public int insertAttach(AttachDto attach);
  public int getUploadCount();
  public List<UploadDto> getUploadList(Map<String, Object>map);// 확장을 위해서 Map<String,Integer>로 안썼다.
}
