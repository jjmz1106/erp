<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직급정보입력</title>
</head>
<body>
	<form method="post" action="/grade/grade-insert">
		<table border="1">
			<tr>
				<th>직급</th>
				<td><input type="text" name="grd_no"></td>
			</tr>
			<tr>
				<th>비고</th>
				<td><input type="text" name="grd_desc"></td>
			</tr>
		</table>
	</form>
</body>
</html>