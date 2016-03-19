<%@ page import="main.java.domain.SaleRecord"%>
<%@ page import="main.java.domain.Client"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<h2>Choose client for view his activity</h2>
<form name="form1"
	action="<%=request.getContextPath()%>/app/clienttradelist.page "
	method="GET">
	<c:set var="now" value="<%=new java.util.Date()%>" />
	<fmt:formatDate var="sdate" pattern="dd/MM/yyyy" value="${now}" />
	<fmt:formatDate var="edate" pattern="dd/MM/yyyy" value="${now}" />

	<table class="center">
		<caption>
			<b>Choose period</b>
		</caption>
		<tr>
			<th>Start date</th>
			<th>End date</th>
		</tr>
		<tr>
			<th><input type="text" name="startdate" value="${sdate}"></th>
			<th><input type="text" name="enddate" value="${edate}"></th>
		</tr>
	</table>
    <br>
    <br>
	<select name="selectclient" onChange="form1.submit()">
		<option selected value="SELECT">Select Client</option>
		<c:forEach items="${allclients}" var="client">
			<option value="${client.idClient}">${client.name}</option>
		</c:forEach>
	</select>
</form>
