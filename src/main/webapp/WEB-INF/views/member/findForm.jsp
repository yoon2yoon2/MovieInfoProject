<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>MEMBER SEARCH USING ID</h2>
<form action="${pageContext.request.contextPath}/member/findMember">
ID : <input type="text" name="memberEmail">
<input type="submit" value="search">
</form>
</body>
</html>