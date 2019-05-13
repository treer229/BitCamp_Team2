<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('#loginment').css("color", "white");
	});
</script>
<style type="text/css">
<link href="/css/bootstrap.min.css" rel="stylesheet">
   
a {
text-decoration : none;
}
a:link {
color: white;
background-color: transparent;
text-decoration: none;
}

a:visited {
color: white;
background-color: transparent;
text-decoration: none;
}
a:hover {
color : black;
text-decoration: none;
} 

</style>


<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="Ex02_JDBC_Main.jsp">Team2</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor01">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="Ex02_JDBC_Main.jsp">Main <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Ex02_JDBC_Login.jsp">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Ex02_JDBC_JoinForm.jsp">Register</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Intro</a>
      </li>
    </ul>
    <%
	if(session.getAttribute("userid") != null){
		out.print("<b>" + session.getAttribute("userid") + "</b>&nbsp님");
		out.print("<a href='Ex02_JDBC_Logout.jsp'>[ 로그아웃 ]</a>");
	}else{
		out.print("<a id='loginment'>로그인을 해주세요</a>");
		out.print("<a href='Ex02_JDBC_Login.jsp'>[ 로그인 ]</a>");
	}
%>
  </div> 
</nav>