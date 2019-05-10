<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script type="text/javascript">
   $(function(){
  	 $('input[name=del]').click(function(){
       var index = ($('input[name=del]').index(this));
       var url = $('#delform').attr('action');
       console.log($('input[name=delnum]').eq(index).val());
       
       var check = confirm("정말로 삭제하시겠습니까?")
   
       if(check) {
           console.log(check);
       }else {
             alert('삭제를 취소합니다.');
             return
       }
       
       $.ajax({
           url : url,
           data : {clc_num:$('input[name=delnum]').eq(index).val(),
        	   	   num:$('input[name=num]').eq(index).val()},
           type : "post",
           datatype : "html",
           success : function(data){
               alert($('input[name=delnum]').eq(index).val() + "번 체크리스트 삭제 완료");
                   $("#listmain").empty();
                   $("#listmain").append(data);
           },
       
           error : function(xhr){
               alert('삭제 실패 : ' + xhr.status );
           }
       });
       
       
   });
  });
</script>
 <div id= "listmain">

    <hr>
    <h3>제목 : ${title.cl_title }</h3>
    <hr>
   
    <table>
    	<thead>
    	<tr>
    	<th>내용</th>
    	</tr>
    	</thead>
    	<tbody>
    	
    	
    	<c:forEach var = "content" items="${content }">
    	
    	<tr>
    	<td>${content.content }</td>
    	
    	<td>
    	<form action = "deleteContent.Checklist" method = "post" id="delform" name="delform">
    	<input type = "button" id="del" name="del" value="삭제">
    	<input type = "hidden" id="delnum${var.index }" name ="delnum${var.index }" value="${content.clc_num }">
    	<input type = "hidden" id="num${var.index }" name ="num${var.index }" value="${title.cl_num }">
    	</form>
    	</td>
    	</tr>
   
    	</c:forEach>
    	
    	</tbody>
    </table>
    <hr>
    <form action = "writeContent.Checklist" method = "post">
    <input type= "hidden" id = "cl_num" name= "cl_num" value="${title.cl_num }">
    <input type= "hidden" id = "num" name= "num" value="${num }">
    <input type ="submit" value = "내용추가">
    </form>
   </div>