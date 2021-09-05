<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form:form modelAttribute="student">

    First name:
    ${student.firstName}
    <br />

    Last name:
    ${student.lastName}
    <br />

    Gender:
    ${student.gender}
    <br />

    Country:
    ${student.country}
    <br />

    Notes:
    <form:textarea path="notes" cols="20" rows="3" disabled="true" />
    <br />

    Mailing list:
    ${student.mailingList}
    <br />

    Programming skills:
    <br />
    <c:forEach items="${student.programmingSkills}" var="skill">
        ${skill}<br/>
    </c:forEach>
    <br />

    Hobbies:
    <br />
    <c:forEach items="${student.hobbies}" var="hobby">
        ${hobby}<br/>
    </c:forEach>

</form:form>