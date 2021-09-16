<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach items="${allAuthors}" var="author">
    <br />
    --------------------------------
    <br />
    ${author.firstName}<br />
    ${author.lastName}<br />
    <br />
    <a href="edit?idToEdit=${author.id}">Edytuj </a>
    <a href="remove?toRemoveId=${author.id}">Usuń </a>
    <br />
    --------------------------------
    <br />
</c:forEach>