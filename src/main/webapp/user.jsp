<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%--<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sf:form method="post" commandName="user">
    <sf:input path="username"/>
    <sf:errors path="username"/><br/>
    <sf:input path="age"/>
    <input type="submit"/>
</sf:form>
</body>
</html>
