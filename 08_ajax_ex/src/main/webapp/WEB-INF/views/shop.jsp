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
<script>
$(function() {
	fnQuery();
})

function fnQuery() {
	$('#btn_search').click(function() {
		$.ajax({
			type:'get',
			url:'${contextPath}/shop/search.do',
			data:'query=' + $('#query').val(),
			
			dataType:'json',
			success:function(resData){
				  $('#list').empty();
				  
				
				  console.log(resData);
				//  $.each(resData.item, function(i, elem){

					
					//  $('#list').append('<tr><td>'+"상품명"+'</td><td>'+'썸네일'+'</td><td>'+'멀라'+'</td><td>'+'판매처'+'</td></tr>');
					  
			     // })
				  
				 
					  
			
			}
			
		})
	})
}
</script>
</head>
<body>

  <div id="mainWrapper">
  <h2>주말에 풀어보기</h2>
  <form id="frm_info">
  
  <div>
    <label for="display">검색결과건수</label>
    <select id="display" name="display">
 	   <option selected="selected">10</option>
       <option>20</option>
       <option>30</option>
       <option>40</option>
       <option>50</option>
       <option>60</option>
       <option>70</option>
       <option>80</option>
       <option>90</option>
       <option>100</option>
  </select>
 </div>
 
 <div>
  <input type="radio" name="filter" id="sim" checked="checked"> <label for="sim">유사도순</label>
  <input type="radio" name="filter" id="date"> <label for="date">날짜순</label>
  <input type="radio" name="filter" id="low_price"> <label for="low_price">낮은가격순</label>
  <input type="radio" name="filter" id="high_price"> <label for="high_price">높은가격순</label>
  
  
  
  <div>
  <label for="query">검색어 입력</label>
  <input type="text" id="query" name="query">
  <button type="button" id="btn_search">검색</button>
  </div>
 </div>

  </form>
  </div>

<hr>

<table border="1">
<thead>
<tr>
<td>상품명</td>
<td>썸네일</td>
<td>최저가</td>
<td>판매처</td>
</tr>

</thead>
<tbody id="list"></tbody>

</table>


</body>
</html>