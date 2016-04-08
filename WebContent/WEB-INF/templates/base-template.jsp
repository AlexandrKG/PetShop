
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
       "http://www.w3.org/TR/html4/loose.dtd">

<html style="height: 100%">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<!-- 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mystyle.css" type="text/css" />
 -->
<style>
     <%@ include file="/resources/css/mystyle.css"%>
</style>

</head>

<body style="height: 99%; margin: 0px;">

    <table class="main"> 
        <tr valign='top' style="height: 100%">
            <td style="width: 20%">
                <div style="margin: 20% 5% 0%;"><tiles:insertAttribute name="navigation" /></div>
            </td>
            <td><table class="main">
                    <tr style="height: 20%">
                        <td style="text-align: center"><tiles:insertAttribute name="header" /></td>
                    </tr>
                    <tr>
                        <td id="td-content" style="text-align: center">
                            <tiles:insertAttribute name="content" />
                        </td>
                    </tr>
                    <tr style="height: 5%">
                        <td style="text-align: center"><tiles:insertAttribute name="footer" /></td>
                    </tr>
                </table></td>
        </tr>
    </table>

</body>

</html>