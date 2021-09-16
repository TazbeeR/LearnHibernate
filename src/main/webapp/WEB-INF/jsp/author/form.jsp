<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:form method="post" modelAttribute="author">

    <form:hidden path="id"/>

    First Name:
    <form:input path="firstName"/><br />
    Last Name:
    <form:input path="lastName" /><br />

    <input type="submit">
</form:form>