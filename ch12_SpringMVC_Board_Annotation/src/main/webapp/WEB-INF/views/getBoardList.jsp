<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<center>
		<h1>글 목록</h1>
		<h3> 게시판에 오신걸 환영합니다. <a href="logout.do">로그아웃</a></h3>
		
		<!-- 데이터 검색 시작-->
		<!-- 데이터 검색 종료 -->
		
		<!-- 목록 출력 -->
		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="orange" width="100">번호</th>
				<th bgcolor="orange" width="200">제목</th>
				<th bgcolor="orange" width="150">작성자</th>
				<th bgcolor="orange" width="150">등록일</th>
				<th bgcolor="orange" width="100">조회수</th>
			</tr>
			<!-- jstl을 사용하여 자바 문법을 최소화한 상태로 데이터 불러오기 -->
			<!-- 사용법 : 설정 셋팅 안에 태그로 정의.-->
			<c:forEach items="${boardList}" var="board"> <!-- items-> 가져올 값 덩어리. var-> 변수 선언 -->
				<tr>
					<td align="center">${board.seq}</td>
					<td><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>
					<td align="center">${board.writer}</td>
					<td align="center">${board.regdate}</td>
					<td align="center">${board.cnt}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<a href="insertBoard.do">글쓰기</a>
	</center>
</body>
</html>