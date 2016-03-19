<%@ page import="main.java.domain.Category"%>
<%@ page import="main.java.domain.Subcategory"%>
<%@ page import="main.java.domain.Goods"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<%
   Category xCateg = (Category) request.getAttribute("choosecateg");
%>
<script src="${pageContext.request.contextPath}/resources/js/myscript.js" ></script> 
 
    
    <select name="selectcateg" >
        <!-- <option selected value="SELECT">Select Category</option>  -->
        <c:forEach items="${allcateg}" var="category">
            <c:choose>
                <c:when test="${category.id == choosecateg.id}">
                    <option selected value="${category.id}">${category.name}</option>
                </c:when>
                <c:otherwise>
                    <option value="${category.id}">${category.name}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>

<script>

var categ = {};
categ.name = "${choosecateg.name}";
categ.id = "${choosecateg.id}";
alert( "category = " + categ.name ); 
categ.subcategs = [];
<% for(int i = 0; i < xCateg.getSubcategories().size(); i++) { %>
	categ.subcategs[<%=i%>] = {};
	categ.subcategs[<%=i%>].name = "<%=xCateg.getSubcategories().get(i).getName()%>";
	categ.subcategs[<%=i%>].id = <%=xCateg.getSubcategories().get(i).getId()%>;
	categ.subcategs[<%=i%>].goods = [];
	<% for(int j = 0; j < xCateg.getSubcategories().get(i).getGoods().size(); j++) { %>
	   categ.subcategs[<%=i%>].goods[<%=j%>] = {};
	   categ.subcategs[<%=i%>].goods[<%=j%>].name = 
		   "<%=xCateg.getSubcategories().get(i).getGoods().get(j).getName()%>";
		   
	   categ.subcategs[<%=i%>].goods[<%=j%>].number = 
		   "<%=xCateg.getSubcategories().get(i).getGoods().get(j).getNumber()%>";
	   categ.subcategs[<%=i%>].goods[<%=j%>].price = 
	       "<%=xCateg.getSubcategories().get(i).getGoods().get(j).getPrice()%>";
	       
	<%}%>
<%}%>
/*
for(var k = 0; k < categ.subcategs.length; k++) {
	 alert( k + " subcategory = " + categ.subcategs[k].name );
	 for(var n = 0; n < categ.subcategs[k].goods.length; n++) {
		 alert( n + " good = " + categ.subcategs[k].goods[n].name);
	 }
}
*/
createTable(categ,1);

</script> 
 
    
     
     <br>
     <br>
        <select name="selectsubcateg" onChange="showBean(${choosecateg.id})">
        <!-- <option selected value="SELECT">Select Category</option>  -->
        <c:forEach items="${choosecateg.getSubcategories()}" var="subcategory">
            <c:choose>
                <c:when test="${subcategory.id == 1}">
                    <option selected value="${subcategory.id}">${subcategory.name}</option>
                </c:when>
                <c:otherwise>
                    <option value="${subcategory.id}">${subcategory.name}</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
<!-- 
<c:set var="goodslist" value="${choosecateg.getSubcategories().get(0).getGoods()}" />

   
    <table class="center">
        <tr>
            <th>Goods</th>
        </tr>
        <c:forEach items="${goodslist}" var="goods">
            <tr>
                <td><c:out value="${goods.name}" /></td>  
            </tr>
        </c:forEach>
    </table>
      
      <br>
      <input type="button" onclick="count_rabbits()" value="Count rabbits!"/>
      <br>
      <br>
      <c:set var="str_x" value="xxxxxxxxxxxxxxxx" />
 --> 
 <!--     
      <input type="button" onclick="showBean(${choosecateg.id})" value="Show bean"/>            
      <br>
      <br>
      <input type="button" onclick="showObject(categ)" value="Show js_obj"/>     
 -->       
       