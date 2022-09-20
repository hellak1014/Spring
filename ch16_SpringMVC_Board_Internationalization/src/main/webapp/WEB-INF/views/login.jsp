<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.user.login.title"/></title>
</head>
<body>

	<center>
	<h1 align="center"><spring:message code="message.user.login.title"/></h1>
	<a href="login.me?lang=en">
		<spring:message code="message.user.login.language.en"/>
	</a> &nbsp; &nbsp;
	<a href="login.me?lang=ko">
		<spring:message code="message.user.login.language.ko"/>
	</a>
	</center>
	<hr>
	<form action="login.me" method="post">
		<table border="1" cellpadding="0" cellspacing="0" align="center">
			<tr>
				<td><spring:message code="message.user.login.id"/></td>
				<td><input type="text" name="id" value="${usr.id}"/></td>
			</tr>
			<tr>
				<td><spring:message code="message.user.login.password"/></td>
				<td><input type="password" name="password" value="${usr.password}"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="<spring:message code="message.user.login.loginBtn"/>"/></td>
			</tr>
		</table>
	</form>

</body>
</html>