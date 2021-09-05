<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1 align="center">Formularz student</h1>
<form:form method="post" modelAttribute="student">
    Imię: <form:input path="firstName"/><br />
    Nazwisko: <form:input path="lastName"/><br />
    Płeć: Mężczyzna <form:radiobutton path="gender" value="M"/>
          Kobieta <form:radiobutton path="gender" value="F"/><br />
    Kraj: <form:select path="country">
    <form:option value="-" label="--> Wybierz <--"/>
    <form:options items="${countries}"/>
        </form:select><br />
    Notatka: <form:textarea path="notes"/><br />
    Chcę otrzymywać powiadomienia
    <form:checkbox path="mailingList"/><br />
    <form:select path="programmingSkills" items="${skills}"  multiple="true"/><br />
    <form:checkboxes path="hobby" items="${hobbies}"/><br />



    <input type="submit">
</form:form>

