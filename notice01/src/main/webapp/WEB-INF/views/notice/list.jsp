<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<script>

var addResult='${addResult}';
if(addResult!=='')
	{
	if(addResult==='1')
		{
		alert('공지사항이 등록되었습니다.');
		}
	else {
		alert('공지사항이 등록되지 않았습니다.');}
	
	}





</script>


<body>


  <a href="${contextPath}/notice/write.do">공지작성하러가기</a>



  <c:forEach  items="${noticeList}" var="n" >
  <div>
  <h3> 공지번호 :${n.noticeNo}</h3>
  <h3> 구분 : ${n.gubun}</h3>
  <h3> <a href="${contextPath}/notice/detail.do?noticeNo=${n.noticeNo}">제목 : ${n.title}</a></h3>
  <hr>
  </div>
  
  </c:forEach>


  
  

  
  
  
</body>
</html>