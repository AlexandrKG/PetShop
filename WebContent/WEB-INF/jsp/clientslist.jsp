<%@ page import="main.java.domain.Client"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>


<table class="center" >
    <caption>
        <b>All clients</b>
    </caption>
    <tr>
            <th>Name</th>
            <th>Gender</th>
            <th>Age</th>
            <th>Address</th>
            <th>Telephone</th>
    </tr>

    <c:forEach items="${clientsall}" var="client">
        <tr>
            <td><c:out value="${client.name}" /></td>
            <td><c:out value="${client.gender}" /></td>
            <td><c:out value="${client.age}" /></td>
            <td><c:out value="${client.address}" /></td>
            <td><c:out value="${client.telephone}" /></td>
        </tr>
    </c:forEach> 
</table>