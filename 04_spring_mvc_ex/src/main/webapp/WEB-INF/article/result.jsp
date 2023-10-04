<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <div>
  <div>
    ${articleNo}
  </div>
 <div>
    ${title}
  </div>
  <div>
    ${content}
  </div>
 
 <hr>
 
 <div>${vo.articleNo}</div>
 <div>${vo.title}</div>
 <div>${vo.content}</div>
 
 
 <div>
 
 <div>
 ${articleVo.articleNo}</div>
 ${articleVo.title}</div>
 ${articleVo.content}</div>
 </div>
 
 
 
 <hr>
 
 <hr>
 
 <hr>
 
  <div>
 ${atcVo.articleNo}</div>
 ${atcVo.title}</div>
 ${atcVo.content}</div>
 </div>
 
 </div>
  
  

</body>
</html>