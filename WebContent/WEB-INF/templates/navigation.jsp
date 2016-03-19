    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div id="navigation">
        <ul>
            <li>
                <a href="<%=request.getContextPath()%>/app/main.page">Home page</a>
                <br>
            </li>  
            <li>
                <a href="<%=request.getContextPath()%>/app/formfindclient.page">Find client by ID</a>
                <br>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/app/clientslist.page">Show all clients</a>
                <br>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/app/addclientform.page">Add new client</a>
                <br>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/app/clienttodel.page">Select user to delete</a>
                <br>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/app/category.page">Edit Categories</a>
                <br>
            </li> 
            <li>
                <a href="<%=request.getContextPath()%>/app/subcategory.page">Edit Subcategories</a>
                <br>
            </li> 
            <li>
                <a href="<%=request.getContextPath()%>/app/goods.page">Edit Goods</a>
                <br>
            </li>   
            <li>
                <a href="<%=request.getContextPath()%>/app/clienttrade.page">
                    Show Client's activity
                </a>
                <br>
            </li>
            <li>
                <a href="<%=request.getContextPath()%>/app/shop.page">
                    Shopping
                </a>
                <br>
            </li>                                
                                                  
        </ul>
    </div>