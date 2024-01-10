<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


		<h3>홈화면입니다~~~~</h3>
		<br>
		
		
		<a href="${pageContext.request.contextPath }/index.jsp">Home </a>
		
		<br>
		<c:choose>
		
		<c:when test="${sessionScope.user_id == null }">
		
		<a href="${pageContext.request.contextPath }/projectJorder/user_login.user">로그인 </a>
		
		<br>
		
		<a href="${pageContext.request.contextPath }/projectJorder/user_join.user">회원가입 </a>
		
		<br>
		</c:when>

		<c:otherwise>
		
		<a href="${pageContext.request.contextPath }/projectJorder/user_mypage.user" style="color:red">MYPAGE</a>
		<br>
		<a href="${pageContext.request.contextPath }/projectJorder/user_logout.user" style="color:blue">로그아웃</a>
		
		</c:otherwise>
		</c:choose>
		
		

</body>
</html>