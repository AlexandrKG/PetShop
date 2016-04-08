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

<select name="selectclient" id="clid">
	<option selected value="SELECT">Select Client</option>
	<c:forEach items="${clientsall}" var="client">
		<option value="${client.idClient}">${client.name}</option>
	</c:forEach>
</select>
<br>     
<br> 
<form name="form1"
    action="<%=request.getContextPath()%>/app/shop.page "
    method="GET">    
    <select name="selectcateg" onChange="form1.submit()">
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
</form>    
     <br>

   
<script>
var categ = {};
categ.name = "${choosecateg.name}";
categ.id = "${choosecateg.id}";
//alert( "category = " + categ.name ); 
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
	   categ.subcategs[<%=i%>].goods[<%=j%>].id = 
	       "<%=xCateg.getSubcategories().get(i).getGoods().get(j).getIdGoods()%>";
		   
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

var choiseGoods = {};
choiseGoods.idclient = 0;
choiseGoods.idgoods = 0;
choiseGoods.num = 0;
choiseGoods.action = "<%=request.getContextPath()%>/app/buygoods.page";

createSelect(0);
createTable(0);


</script>

    
   
       