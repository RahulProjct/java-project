<%@page import="java.util.List"%>
<%@page import="com.rj.bookdtomodel.BookDTO"%>

<%@ taglib uri="http://jakarta.apache.org/taglibs/standard/permittedTaglibs" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search book</title>
<style>
body {
	text-align: justify;
	background-color: purple;
}

h1 {
	text-align: center;
}
</style>
</head>
<body>
	
	<h1>Book List</h1>

	<table border="1">
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>ISBN</th>
		</tr>
		
		<c:forEach items="${bookList}" var="book">
			<tr>
				<td><c:out value="{book.title}"/> </td>
				<td><c:out value="{book.author}"/> </td>
				<td><c:out value="{book.isbn}"/> </td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>