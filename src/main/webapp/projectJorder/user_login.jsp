<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<div align="center">
		<h3>로그인</h3>
		<hr>
		<form action="loginForm.user" method ="post">
			<table>
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="id" required>
					</td>
				</tr>
				<br>
				
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="text" name="pw" required>
					</td>
				</tr>
				

			</table>
			
				<input type="submit" value="로그인" >
				<input type="reset" value="취소">
			
	
		</form>
		${msg } <br>
	
	</div>




</body>
</html>