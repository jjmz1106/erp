<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
var person = '{"name":"민수","age":25,"address":"경기","hobby":"게임"}';
/*
 * 키 : name, age, address, hobby
 * 값 :  
 *
 */
 person = JSON.parse(person);
 alert(person.name + ',' + person.age + ',' + person.address + ',' + person.hobby);
 
 var sum = '1' + 1;
 
 if(sum===11){
	 alert('sum은 숫자');
 }else if(sum==='11'){
	 alert('sum은 문자');
 }else{
	 alert('아니네');
 }
 
 for(var i=0;i<10;i++){
	 
 }
 var i=1;
 while(i<10){
	 i++;
 }
 alert(i);
 do{
	 i++
 }while()
</script>
</body>
</html>