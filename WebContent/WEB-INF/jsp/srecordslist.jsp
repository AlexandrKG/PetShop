<%@ page import="main.java.domain.SaleRecord"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>


<table class="center" >
    <caption>
        <b>All clients</b>
    </caption>
    <tr>
            <th>Date</th>
            <th>Client</th>
            <th>Goods</th>
            <th>Number</th>
            <th>Cost</th>
    </tr>

    <c:forEach items="${alltransactions}" var="saleRecord">
        <tr>
            <td><c:out value="${saleRecord.dataTXT}" /></td>
            <td><c:out value="${saleRecord.client.getName()}" /></td>
            <td><c:out value="${saleRecord.goods.getName()}" /></td>
            <td><c:out value="${saleRecord.number}" /></td>
            <td><c:out value="${saleRecord.cost}" /></td>
        </tr>
    </c:forEach> 
</table>