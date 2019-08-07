<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script>
$(function(){
	$("#recommendGrade").change(function(){ // 별점 select 할때마다 ajax처리로 바로바로 영화 들어가게끔 한다.		
		var params = {
			memberId:$("#memberId").val(),
			movieNo:$("#movieNo").val(),
			recommendGrade:$("#recommendGrade").val(),
			"${_csrf.parameterName}":"${_csrf.token}"
		};		
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/recommend/insert",				
			data:params
		});//ajax
	});	
});
</script>
<body>
	<h1>회원 가입 후 이동하여 DB에 본인이 관심있는 영화 정보 축적하는 페이지입니다.</h1>
	<br>
	<h3>
		영화 목록 랜덤으로 20개 띄워주고<br> 별표 누를때 마다 ajax로
		user_id,Movie_no,recommend_grade를 table에 insert해줍니다.
	</h3>
	<form method="post">
		<input type="hidden" id="memberId" value="1234" name="memberId"/> <!-- value 하드코딩 하였습니다. 나중에 얻어와야함. -->
		<input type="hidden" id="movieNo" value="4321" name="movieNo"/>
		<select id="recommendGrade" name="recommendGrade">
			<option value="">---별점 선택---</option>
			<option value="1">★☆☆☆☆</option>
			<option value="2">★★☆☆☆</option>
			<option value="3">★★★☆☆</option>
			<option value="4">★★★★☆</option>
			<option value="5">★★★★★</option>
		</select>
	</form>
</body>
</html>