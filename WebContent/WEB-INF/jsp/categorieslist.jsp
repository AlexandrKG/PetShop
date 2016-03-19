<%@ page import="main.java.domain.Category"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<form action="<%=request.getContextPath()%>/app/delcateg.page " method = "GET">
<table class="center">
	<caption>
		<b>All categories</b>
	</caption>
	<tr>
		<th>Name</th>
		<th>Select category</th>
	</tr>

	<c:forEach items="${allcategories}" var="category">
		<tr>
			<td><c:out value="${category.name}" /></td>
			<td><input type="radio" name="catid" value="${category.id}" /></td>
		</tr>
	</c:forEach>
</table>

<input type="submit" value="Delete check category"/>
</form>
<br>

<sf:form method="POST" action="/PetShop/app/addcategory.page"
	modelAttribute="newcateg">
	<sf:label path="name">Name</sf:label>
	<sf:input path="name" />
	<input type="submit" value="Add category" />
</sf:form>