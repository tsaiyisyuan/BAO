<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	background-image: url("Images/b1.png");
	background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;
            background-size: cover;
}
th,tr,td{
border:1px solid;
}
th{
	background:#6adec4;
}
	td:nth-child(odd){
  background:#E8FAF6;
}

td:nth-child(even){
  background:#e0feff;
}
	
	 th:first-child , td:first-child{
    border-bottom-left-radius: 8px;
    border-top-left-radius: 8px; 
    }

 th:last-child , td:last-child{
    border-bottom-right-radius: 8px;
    border-top-right-radius: 8px; 
}
	
</style>
</head>
<body>
<div style="width:300px;margin:10% auto;">
	<form action="upDa">
		<table>
			<tr>
				<td>empno</td>
				<td><input type="text" name="empno" value="${emp.empno }">
					<input type="hidden" name="hidden" value="${emp.empno }"></td>
			</tr>
			<tr>
				<td>ename</td>
				<td><input type="text" name="ename" value="${emp.ename }"></td>
			</tr>
			<tr>
				<td>hiredate</td>
				<td><input type="text" name="hiredate" value="${emp.hiredate }"></td>
			</tr>
			<tr>
				<td>salary</td>
				<td><input type="text" name="salary" value="${emp.salary }"></td>
			</tr>
			<tr>
				<td>deptno</td>
				<td><input type="text" name="deptno" value="${emp.deptno }"></td>
			</tr>
			<tr>
				<td>title</td>
				<td><input type="text" name="title" value="${emp.title }"></td>
			</tr>
		</table>
		<input type="submit" value="確定">

	</form>
</div>

</body>
</html>