<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:form method="post" modelAttribute="publisher">

    <form:hidden path="id"/>

    Name:
    <form:input path="name"/><br />


    <input type="submit">
</form:form>