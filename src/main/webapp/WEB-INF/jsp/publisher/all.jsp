<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach items="${allPublishers}" var="publisher">
    <br />
    --------------------------------
    <br />
    ${publisher.name}<br />
    <br />
    <a href="edit?idToEdit=${publisher.id}">Edytuj </a>
    <a href="remove?toRemoveId=${publisher.id}">Usuń </a>
    <br />
    --------------------------------
    <br />
</c:forEach>