<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<table border="1">
	<thead><tr><td>스케줄 번호</td> <td>제목</td> <td>내용</td> <td>작성자</td> <td>시작일</td> <td>종료일</td> <td>색상</td> <td>삭제여부</td> <td>완료여부</td></tr></thead>
		<tbody>
<c:forEach var = "i" items = "${list }">
	<tr>
	<td>${i.schedule_num}</td>
	<td>${i.schedule_title}</td>
	<td>${i.content}</td>
	<td>${i.id}</td>
	<td>${i.schedule_start}</td>
	<td>${i.schedule_end}</td>
	<td>${i.color}</td>
	<td>${i.deleteok}</td>
	<td>${i.completeok}</td>
	<tr>
</c:forEach>

		</tbody>
</table>
<a href = "insert.Schedule">추가하기</a>