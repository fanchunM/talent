<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="common/ace/js/jquery-1.11.3.min.js"></script>
    <script src="js/test.js"></script>
    <title>test</title>
</head>
<body>
<div style="text-align: center">
    <div style="color:red; font-family: 'Arial Black'; font-size: 22px" onclick="open111();">${users}</div>
    <%--<table>--%>
        <%--<c:forEach items="${users}" var="user">--%>
            <%--<tr>--%>
                <%--<td>${user.id}</td>--%>
                <%--<td>${user.name}</td>--%>
                <%--<td>${user.gender}</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>
</div>
</body>
