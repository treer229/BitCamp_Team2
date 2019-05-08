<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<title>Test Project</title>


<style type="text/css">

tr {
	border: solid 1px Lightgray;
	background-color: white;
	color: black;
}

td {
	border: solid 1px Lightgray;
}

th { 
	text-align: center;
}
#hoguma {
width : 196px; 
height : 256px; 
list-style-type: none; 
padding : 0;
}
#hoguma a:link {
color: gray;
background-color: transparent;
text-decoration: none;
}

#hoguma a:visited {
color: gray;
background-color: transparent;
text-decoration: none;
}
#hoguma a:hover {
color : black;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
 
$(function(){
	var checkbit = /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
    // 회원 가입 처리
    
   
   $('#join-submit').submit(function(e){
        e.preventDefault();
        if($("#inputName").val() ==''){
            alert('이름을 입력하세요');
            $("#inputName").focus();
            return false;
        }
        if($("#id").val() ==''){
            alert('아이디를 입력하세요');
            $("#inputName").focus();
            return false;
        }
        if($("#inputPassword").val() ==''){
            alert('비밀번호를 입력하세요');
            $("#inputPassword").focus();
            return false;
        }
         if($("#birthday").val() == '') {
    		alert('생년월일을 입력해주세요.');
    		$("#birthday").focus();
    		return false;
    	} else if(!checkbit.test($('#birthday').val())){
    		alert('올바른 형식의 생년월일이 아닙니다.')
    		$('#birthday').focus();
    		return false; 
    	}
        var email = $('#InputEmail').val();
        if(email == ''){
            alert('이메일을 입력하세요');
            $("#InputEmail").focus();
            return false;
        } else {
            var emailRegex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
            if (!emailRegex.test(email)) {
                alert('이메일 주소가 유효하지 않습니다. ex)abc@gmail.com');
                $("#inputEmail").focus();
                return false;
            }
        }


    });
});
    
</script>
<!--  
CREATE TABLE koreaMember
(
    id VARCHAR2(50) PRIMARY KEY ,
    pwd VARCHAR2(50) NOT NULL,
    NAME VARCHAR2(50) NOT NULL,
    age NUMBER ,
    gender CHAR(4),
    email VARCHAR2(50),
    ip   VARCHAR2(50)
)
-->

</head>
<body>
	<div
		style="width: 100%; height: 100%; margin-left: auto; margin-right: auto;
			 border-collapse: collapse;">
		<div style = "height : 100px">
			
				<jsp:include page="/common/Top.jsp"></jsp:include>
			
		</div>
		<div style = "column-count: 2">
			<div style = "width : 25%">
				<jsp:include page="/common/Left.jsp"></jsp:include>
			</div>
			<div style = "position : relative ; right: 50%">
				<form action="Ex02_JDBC_JoinOK.jsp" method="post" name="joinForm" id="joinForm">
					
						<div style="width: auto; height: auto; margin-left: auto; margin-right: auto;">
							<article style = "margin-top: 550px">
            <div class="page-header">
                <div style = "text-align: center">
                <h3>회원가입</h3>
                </div>
            </div>
            <div style = "width : auto ; margin-top: auto">
              
                    <div class="form-group">
                        <label for="inputName">성명</label>
                        <input type="text" class="form-control" name = "inputName" id="inputName" placeholder="이름을 입력해 주세요">
                    </div>
   					  <div class="form-group">
                        <label for="inputName">아이디</label>
                        <input type="text" class="form-control" name = "id" id="id" placeholder="ID를 입력해 주세요">
                    </div>
                      <div class="form-group">
                        <label for="inputPassword">비밀번호</label>
                        <input type="password" class="form-control" name = "inputPassword" id="inputPassword" placeholder="비밀번호를 입력해주세요">
                    </div>
                     <div class="form-group">
                        <label for="inputName">생년월일</label>
                        <input type="text" class="form-control" name= "birthday" id="birthday" placeholder="Ex)19960715">
                    </div>
                    <div class="btn-group btn-group-toggle" data-toggle="buttons" style = "width : auto ; height: auto;">
                  
						<label class="btn btn-primary">
							<input type="radio" name="gender" id="gender" value = "남"> 남자
						</label>
						<label class="btn btn-danger">
							<input type="radio" name="gender" id="gender" value = "여"> 여자
						</label>
						</div>
                    <div class="form-group">
                        <label for="InputEmail">이메일 주소</label>
                        <input type="email" class="form-control" name= "InputEmail" id="InputEmail" placeholder="이메일 주소를 입력해주세요">
                    </div>

                    <div class="form-group text-center">
                        <button type="submit" id="join-submit" class="btn btn-primary">
                            회원가입
                        </button>
                    </div>
                    
            
            </div>

        </article>

				
				</form>
			</div>
		</div>

	</div>
	<br>
	<br>
<div>
		<jsp:include page="/common/Bottom.jsp"></jsp:include>

</body>
</html>