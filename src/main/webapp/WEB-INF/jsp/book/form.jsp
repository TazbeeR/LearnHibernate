<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:form method="post" modelAttribute="book">

    <form:hidden path="id"/>

    Title:
    <form:input path="title"/><br />
    Rating:
    <form:input path="rating" type="number"/><br />
    Description:
    <form:input path="description"/><br />

    Publisher:
    <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/>

    Author:
    <form:select path="authorList" items="${authors}" itemLabel="lastName" itemValue="id" multiple="true"/>
     <input type="submit">

</form:form>