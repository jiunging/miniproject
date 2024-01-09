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
		
		<a href="${pageContext.request.contextPath }/projectJorder/user_login.user">LOGIN </a>
		
		<br>
		
		<a href="${pageContext.request.contextPath }/projectJorder/user_join.user">JOIN </a>
		
		<br>
		
		<a href="${pageContext.request.contextPath }/projectJorder/user_mypage.user" style="color:red">MYPAGE</a>
		
		
		
		

</body>
</html>