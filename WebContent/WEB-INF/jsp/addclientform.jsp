<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<h2>Add client</h2>
<sf:form method="POST" action="/PetShop/app/addclient.page"
	modelAttribute="newclient">
	<table class="center" >
		<tr>
			<td><sf:label path="name">Name</sf:label></td>
			<td><sf:input path="name" /></td>
		</tr>
		<tr>
			<td><sf:label path="gender">Gender</sf:label></td>
			<td><sf:input path="gender" /></td>
		</tr>
		<tr>
			<td><sf:label path="age">Age</sf:label></td>
			<td><sf:input path="age" /></td>
		</tr>
		<tr>
			<td><sf:label path="address">Address</sf:label></td>
			<td><sf:input path="address" /></td>
		</tr>
		<tr>
			<td><sf:label path="telephone">Telephone</sf:label></td>
			<td><sf:input path="telephone" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</sf:form>
