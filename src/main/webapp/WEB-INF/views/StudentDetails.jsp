<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<title>Student Library Records</title>
</head>
<body>
	<c:if test="${empty booksList}">
		No books checked out for this user
	</c:if>
	<c:if test="${not empty booksList}">
		Here are all authors matching your search critera:
	<table border="1">
			<tr>
				<td><c:out value="Book Id" />
				<td><c:out value="Book Name" />
				<td><c:out value="Book Price" />
			</tr>
			<c:forEach items="${booksList}" var="bookObj">
				<tr>
					<td><c:out value="${bookObj.bookId}" />
					<td><c:out value="${bookObj.bookName}" />
					<td><c:out value="${bookObj.price}" />
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>