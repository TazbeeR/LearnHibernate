<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="post" modelAttribute="person">
    Login: <form:input path="login"/> <br/>
    Email: <form:input path="email"/><br/>
    Password: <form:input path="password" /><br/>
    <input type="submit">
</form:form>
    <form method="post">
    Login: <input type="text" name="login"> <br />
    Email: <input type="email" name="email"> <br />
    Password: <input type="password" name="password"> <br />

    <input type="submit">
    </form>
