<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
시도 : 
<select id="sido" onchange="changeSido(this)">
	<option value="">선택</option>
	<c:forEach items="sidoList" var="sido">
		<option value="${sido}">${sido}</option>
	</c:forEach>
</select>
구군 : 
<select id="gugun" onchange="changeSido(this)">
	<option value="">선택</option>
	<c:forEach items="${gugunList}" var="gugun">
		<option value="${gugun}">${gugun}</option>
	</c:forEach>
</select>
동 : 
<select id="dong" onchange="changeSido(this)">
	<option value="">선택</option>
	<c:forEach items="${dongList}" var="dong">
		<option value="${dong}">${dong}</option>
	</c:forEach>
</select>
<script>
function changeSido(){
	alert(obj.value);
}
</script>
</body>
</html>