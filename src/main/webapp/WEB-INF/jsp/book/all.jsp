<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach items="${allBooks}" var="book">
    <br />
    --------------------------------
    <br />
    ${book.title}<br />
    ${book.description}<br />
    <br />
        <a href="edit?idToEdit=${book.id}">Edytuj </a>
        <a href="remove?toRemoveId=${book.id}">Usuń </a>
    <br />

    --------------------------------
    <br />
</c:forEach>