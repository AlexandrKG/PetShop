<%@ page import="main.java.domain.Category"%>
<%@ page import="main.java.domain.Subcategory"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>


<form name="form1"
	action="<%=request.getContextPath()%>/app/subcategory.page "
	method="GET">
	<select name="selectcateg" onChange="form1.submit()">
		<!-- <option selected value="SELECT">Select Category</option>  -->
		<c:forEach items="${allcateg}" var="category">
			<c:choose>
				<c:when test="${category.id == newsubcateg.idCategory}">
					<option selected value="${category.id}">${category.name}</option>
				</c:when>
				<c:otherwise>
					<option value="${category.id}">${category.name}</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</select>
</form>

<form action="<%=request.getContextPath()%>/app/delsubcateg.page "
	method="GET">
	<table class="center">
		<tr>
			<th>Name</th>
			<th>Select subcategory</th>
		</tr>
		<c:forEach items="${subcategs}" var="subcategory">
			<tr>
				<td><c:out value="${subcategory.name}" /></td>
				<td><input type="radio" name="scid" value="${subcategory.id}" /></td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="Delete check subcategory" />
</form>
<br>
<sf:form method="POST" action="/PetShop/app/addsubcategory.page"
	modelAttribute="newsubcateg">
	<sf:label path="name">Name</sf:label>
	<sf:input path="name" />
	<sf:hidden path="idCategory" />
	<input type="submit" value="Add subcategory" />
	<br>
	<!--     <c:out value="${newsubcateg.idCategory}" />  -->
</sf:form>