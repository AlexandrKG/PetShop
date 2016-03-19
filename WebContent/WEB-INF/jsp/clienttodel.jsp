<%@ page import="main.java.domain.Client"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>

<form action="<%=request.getContextPath()%>/app/delclient.page " method = "GET">
    <table class="center">  
    <caption><b>All users</b></caption>
        <tr>
            <th>Name</th>
            <th>Gender</th>
            <th>Age</th>
            <th>Address</th>
            <th>Telephone</th>
            <th>Select client</th>
        </tr>
    <c:forEach items="${clientsall}" var="client">
        <tr>
            <td><c:out value="${client.name}" /></td>
            <td><c:out value="${client.gender}" /></td>
            <td><c:out value="${client.age}" /></td>
            <td><c:out value="${client.address}" /></td>
            <td><c:out value="${client.telephone}" /></td>
            <td><input type="radio" name="clid" value="${client.idClient}" /></td>
        </tr>
    </c:forEach>            
    </table>
    <input type="submit" value="Delete check client"/>
</form>