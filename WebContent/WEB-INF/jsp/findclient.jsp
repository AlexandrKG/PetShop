<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

   
    <h2>Find client</h2>
    <form action="<%=request.getContextPath()%>/app/clientdb.page " method = "GET">
        <input type="text" name="clid" value="1" /> 
        <input type="submit" name="submit" />
    </form>