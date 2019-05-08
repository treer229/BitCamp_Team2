<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
   <style type="text/css">
a {
text-decoration : none;
}
a:link {
color: gray;
background-color: transparent;
text-decoration: none;
}

a:visited {
color: gray;
background-color: transparent;
text-decoration: none;
}
a:hover {
color : black;
} 
   </style>
     <div style = "text-align: right">
      <%
   if(session.getAttribute("userid") != null) {
	   out.print("<b>[" + session.getAttribute("userid") + "]</b> 로그인 상태");
	   out.print("<a href='Ex02_JDBC_Logout.jsp'> [ 로그아웃  ]</a>");
   }else{
	   out.print("<b>로그인이 필요합니다.</b>");
	   out.print("<a href = 'Ex02_JDBC_Login.jsp' style = 'text-decoration: none'>[ 로그인 ]</a>");
   }
   %>
    </div>

<meta name="viewport" content="width=device-width, initial-scale=1.0">   
    
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Menu</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="Ex02_JDBC_Main.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
<!--       <li class="nav-item">
        <a class="nav-link" href="Ex02_JDBC_Login.jsp">Login</a>
      </li> 
      <li class="nav-item">
        <a class="nav-link" href="Ex02_JDBC_JoinForm.jsp">JOIN</a>
      </li>-->
            <li class="nav-item">
        <a class="nav-link" href="Ex03_MemberEdit.jsp">MemberEdit</a>
      </li>
            <li class="nav-item">
        <a class="nav-link" href="Ex03_Memberlist.jsp">Memberlist</a>
      </li>
              <li class="nav-item">
        <a class="nav-link" href="Ex03_MemberSearch.jsp">MemberSearch</a>
      </li>
    </ul>
  </div>
</nav>

