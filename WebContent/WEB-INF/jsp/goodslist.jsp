<%@ page import="main.java.domain.Category"%>
<%@ page import="main.java.domain.Subcategory"%>
<%@ page import="main.java.domain.Goods"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>

<div class="inv"> 

<form name="form1"
    action="<%=request.getContextPath()%>/app/goods.page "
    method="GET">
    <select name="selectcateg" onChange="form1.submit()">
        <!-- <option selected value="SELECT">Select Category</option>  -->
        <c:forEach items="${allcateg}" var="category">
            <c:choose>
                <c:when test="${category.id == newgoods.idCategory}">
                    <option selected value="${category.id}">${category.name}</option>
                </c:when>
                <c:otherwise>
                    <option value="${category.id}">${category.name}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
</form>

<form name="form2"
    action="<%=request.getContextPath()%>/app/goods.page "
    method="GET">
    <select name="selectsubcateg" onChange="form2.submit()" >
        
        <c:forEach items="${subcategs}" var="subcategory">
            <c:choose>
                <c:when test="${subcategory.id == newgoods.idSubcategory}">
                    <option selected value="${subcategory.id}">${subcategory.name}</option>
                </c:when>
                <c:otherwise>
                    <option value="${subcategory.id}">${subcategory.name}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
</form>

<form action="<%=request.getContextPath()%>/app/delgoods.page "
    method="GET">
    <table class="center">
        <tr>
            <th>Name</th>
            <th>Select goods</th>
        </tr>
        <c:forEach items="${listgoods}" var="goods">
            <tr>
                <td><c:out value="${goods.name}" /></td>
                <td><input type="radio" name="gid" value="${goods.idGoods}" /></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Delete check goods" />
</form>
<br>
<sf:form method="POST" action="/PetShop/app/addgoods.page"
    modelAttribute="newgoods">
    <sf:label path="name">Name</sf:label>
    <sf:input path="name" />
    <sf:hidden path="idCategory" />
    <sf:hidden path="idSubcategory" />
    <input type="submit" value="Add goods" />
    <br>
    <!--     <c:out value="${newgoods.idCategory}" />  -->
</sf:form>
 
</div> 