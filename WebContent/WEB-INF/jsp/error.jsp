<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<center><h2>ERROR!</h2></center>
<div id="content">
    <c:if test="${message != null}">
        <c:out value="${message}" />
    </c:if>
</div>    