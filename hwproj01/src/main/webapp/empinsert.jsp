<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
document.addEventListener("DOMContentLoaded", function () {
	document.getElementById("idNo").addEventListener("blur", checkNo);
	document.getElementById("idName").addEventListener("blur", checkName);
    document.getElementById("idDate").addEventListener("blur", checkDate);
    document.getElementById("idInt").addEventListener("blur", checkInt);
    document.getElementById("idNo2").addEventListener("blur", checkNo2);
    document.getElementById("idTi").addEventListener("blur", checkTi);
});
let f1=false;let f2=false;let f3=false;let f4=false;let f5=false;let f6=false;
function checkNo() {
	let userNo = document.getElementById("idNo").value;
    let theNoL = userNo.length;
    let flag1 = 0;
    if(theNoL==0){
    	document.getElementById("sp1").innerHTML = "<img src='Images/error.png'>錯誤";
    	f1=false;
    }else if(theNoL==4){
    	for (let i = 0; i < theNoL; i++) {
            let theNoChr = userNo.charAt(i).toUpperCase();
            if (theNoChr >= "0" && theNoChr <= "9")
                flag1 = flag1+1;
        }
    	if(flag1==4){
    		document.getElementById("sp1").innerHTML = "<img src='Images/ok.png'>正確";
    		f1=true;
    	}else {
    		document.getElementById("sp1").innerHTML = "<img src='Images/error.png'>錯誤";
    		f1=false;
		}
    }else{
    	document.getElementById("sp1").innerHTML = "<img src='Images/error.png'>錯誤";
    	f1=false;
    }
}

function checkName() {
	let userName = document.getElementById("idName").value;
	if(userName==""){
		document.getElementById("sp2").innerHTML = "<img src='Images/error.png'>錯誤";
		f2=false;
	}else {
		document.getElementById("sp2").innerHTML = "<img src='Images/ok.png'>正確";
		f2=true;
	}
}

function checkDate() {
    let userDate = document.getElementById("idDate").value;
    let d = new Date(userDate);
    let re = /^[\d]{4,4}-[\d]{1,2}-[\d]{1,2}$/;
    if (userDate == "") {
        document.getElementById("sp3").innerHTML = "<img src='Images/error.png'>錯誤";
        f3=false;
    } else if (re.test(userDate)) {
        let str = new String(userDate);
        let fff = str.split("-", 3);
        if (fff[2] == d.getDate()) {
            document.getElementById("sp3").innerHTML = "<img src='Images/ok.png'>正確";
            f3=true;
        } else {
            document.getElementById("sp3").innerHTML = "<img src='Images/error.png'>錯誤";
            f3=false;
        }
    } else {
        document.getElementById("sp3").innerHTML = "<img src='Images/error.png'>錯誤";
        f3=false;
    }
}

function checkInt() {
	let userInt = document.getElementById("idInt").value;
	let theIntL = userInt.length;
    let flag1 = 0;
	if(userInt==""){
		document.getElementById("sp4").innerHTML = "<img src='Images/error.png'>錯誤";
		f4=false;
	}else {
		for (let i = 0; i < theIntL; i++) {
            let theIntChr = userInt.charAt(i).toUpperCase();
            if (theIntChr >= "0" && theIntChr <= "9")
                flag1 = flag1+1;
        }
    	if(flag1==theIntL){
    		document.getElementById("sp4").innerHTML = "<img src='Images/ok.png'>正確";
    		f4=true;
    	}else {
    		document.getElementById("sp4").innerHTML = "<img src='Images/error.png'>錯誤";
    		f4=false;
		}
	}
}

function checkNo2() {
	let userNo = document.getElementById("idNo2").value;
    let theNoL = userNo.length;
    let flag1 = 0;
    if(theNoL==0){
    	document.getElementById("sp5").innerHTML = "<img src='Images/error.png'>錯誤";
    	f5=false;
    }else if(theNoL==3){
    	for (let i = 0; i < theNoL; i++) {
            let theNoChr = userNo.charAt(i).toUpperCase();
            if (theNoChr >= "0" && theNoChr <= "9")
                flag1 = flag1+1;
        }
    	if(flag1==3){
    		document.getElementById("sp5").innerHTML = "<img src='Images/ok.png'>正確";
    		f5=true;
    	}else {
    		document.getElementById("sp5").innerHTML = "<img src='Images/error.png'>錯誤";
    		f5=false;
		}
    }else{
    	document.getElementById("sp5").innerHTML = "<img src='Images/error.png'>錯誤";
    	f5=false;
    }
}

function checkTi() {
	let userName = document.getElementById("idTi").value;
	if(userName==""){
		document.getElementById("sp6").innerHTML = "<img src='Images/error.png'>錯誤";
		f6=false;
	}else {
		document.getElementById("sp6").innerHTML = "<img src='Images/ok.png'>正確";
		f6=true;
	}
}

$(document).ready(function(){
	$("button").click(function(){
		if(f1==true&&f2==true&&f3==true&&f4==true&&f5==true&&f6==true){
			$("form").submit();
		}
	});
});

</script>
</head>
<body>
<div style="width:300px;margin:10% auto;">
<form id="f1" action="Add">
		<table>
			<tr>
				<td>empno</td>
				<td><input type="text" name="empno" placeholder="ex:1001" id="idNo"><span id="sp1"></span>
					<input type="hidden" name="hidden" ></td>
			</tr>
			<tr>
				<td>ename</td>
				<td><input type="text" name="ename" id="idName"><span id="sp2"></span></td>
			</tr>
			<tr>
				<td>hiredate</td>
				<td><input type="text" name="hiredate" placeholder="ex:2000-2-29" id="idDate"><span id="sp3"></span></td>
			</tr>
			<tr>
				<td>salary</td>
				<td><input type="text" name="salary"  id="idInt"><span id="sp4"></span></td>
			</tr>
			<tr>
				<td>deptno</td>
				<td><input type="text" name="deptno" placeholder="ex:100" id="idNo2"><span id="sp5"></span></td>
			</tr>
			<tr>
				<td>title</td>
				<td><input type="text" name="title"  id="idTi"><span id="sp6"></span></td>
			</tr>
		</table>
	</form>
	<button id="b1">確定</button>
	</div>
</body>
</html>