<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="dt" value="<%=System.currentTimeMillis()%>" />

<jsp:include page="../layout/header.jsp">
  <jsp:param value="회원가입" name="title"/>
</jsp:include>

<script src="${contextPath}/resources/js/user_join.js?dt=${dt}"></script>
<script type="text/javascript">

    
    
}
</script>
<div>

  <form id="frm_join" method="post" action="${contextPath}/user/join.do">
    
    <h1>회원가입</h1>
    
    <div>
      <div>
        <label for="email">이메일</label>
        <input type="text" name="email" id="email">
        <button type="button" id="btn_get_code">인증코드받기</button>
        <span id="msg_email"></span>
      </div>
      <div>
        <input type="text" id="code" placeholder="인증코드입력" disabled>
        <button type="button" id="btn_verify_code" disabled>인증하기</button>
      </div>
    </div>
    
      <div>
      <label for="pw">비밀번호</label>
      <input type="password" name="pw" id="pw">
       <span id="msg_pw"></span>
    </div>
    
        <div>
      <label for="pw2">비밀번호 확인</label>
      <input type="password" id="pw2" >
      <span id="msg_pw2"></span>
    </div>
    
    
    <div>
      <label for="name">이름</label>
      <input type="text" id="name" >
    </div>
    
    
     <div>
      <label >성별</label>
      <label for="man">남자</label>
      <input type="radio" name="gender" value="M" id="man" >
      <label for="woman">여자</label>
      <input type="radio" name="gender" value="W" id="woman" >
     <label for="none">선택 안함</label>
      <input type="radio" name="gender" value="none" id="none"  checked>
    </div>
    
    <div>
      <input type="hidden" name="event" value="${event}">
      <button type="submit">회원가입하기</button>
    </div>
    
    <div>
  
    
    </div>
    
    
  </form>

</div>

<%@ include file="../layout/footer.jsp" %>