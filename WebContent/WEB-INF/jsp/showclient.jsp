<%@ page import="main.java.domain.Client"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>


    <table class="center">
        <tr>
            <th>Name</th>
            <th>Gender</th>
            <th>Age</th>
            <th>Address</th>
            <th>Telephone</th>
        </tr>
        <tr>
            <td><c:out value="${respclient.name}" /></td>
            <td><c:out value="${respclient.gender}" /></td>
            <td><c:out value="${respclient.age}" /></td>
            <td><c:out value="${respclient.address}" /></td>
            <td><c:out value="${respclient.telephone}" /></td>
        </tr>
    </table>
