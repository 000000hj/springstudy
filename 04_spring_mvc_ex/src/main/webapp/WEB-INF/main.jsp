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
    <h3>기사 작성하기</h3>
    <img src="${contextPath}/resources/images/animal1.jpg" width="192px">
  </div>
  
  <div>
    <a href="${contextPath}/write.do">작성화면으로 가기</a>
  </div>

</body>
</html>