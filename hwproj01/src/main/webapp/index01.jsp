<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList,_00_beans.EmpBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
<script type="text/javascript">
	function showEmp2(empno) {
		location.href="EmpById?empno="+empno;
	}
</script>
</head>
<body>
	<div style="width: 550px; margin: 0 auto;">
		<input id="str1" type="text" name="str">
		<button id="b3">搜尋</button>
		<table id="t1">
			<tr>
				<th>編號
				<th>姓名
				<th>到職日期
				<th>薪水
				<th>部門編號
				<th>職稱
				<th><button class="b4">新增</button> 
				<c:forEach items="${emps }" var="emp" varStatus="s">
						<tr>
							<td>${emp.empno }
							<td>${emp.ename }
							<td>${emp.hiredate }
							<td>${emp.salary }
							<td>${emp.deptno }
							<td>${emp.title }
							<td><button class="b1" value="${emp.empno }">修改</button>
							<td><button class="b2" value="${emp.empno }">刪除</button>
					</c:forEach>
		</table>
	</div>
	<script type="text/javascript">
     $(document).ready(function(){
    	 $(".b1").click(function() {
 			location.href="EmpById?empno="+this.value;
 		 });
    	 
    	 $("body").on("click",".b2",function(){
    		 if (confirm("是否要刪除資料")) {
     		    $(this).parent().parent().hide();
     		   $.ajax({
        			url:"DeleEmp",
        			data:{empno:this.value},
        			type:"post"
        		});
     		  } 
    	 });
    	 
    	 $("body").on("click",".b4",function(){
    		 location.href="empinsert.jsp";
    	 });
     });
     	
     	$("#b3").click(function() {
     		$.ajax({
     			url:"ShowEmp",
     			data:{str:$("#str1").val()},
     			type:"post",
     			success:function (data){
     				showEmp(data);
     			}
     		});
		});
     	
     	function showEmp(data) {
			var empss=JSON.parse(data);
			var txt ="<th>編號<th>姓名<th>到職日期<th>薪水<th>部門編號<th>職稱<th><button class=\"b4\">新增</button>";
			for(i=0;i<empss.length;i++){
				txt +="<tr><td>"+empss[i].empno;
				txt +="<td>"+empss[i].ename;
				txt +="<td>"+empss[i].hiredate;
				txt +="<td>"+empss[i].salary;
				txt +="<td>"+empss[i].deptno;
				txt +="<td>"+empss[i].title;
				txt +="<td><button class=\"b1\" value=\""+empss[i].empno+"\" onclick=\"showEmp2("+empss[i].empno+")\">修改</button>";
				txt +="<td><button class=\"b2\" value=\""+empss[i].empno+"\">刪除</button>";
			}
			document.getElementById("t1").innerHTML=txt;
		}
     </script>
     
</body>
</html>