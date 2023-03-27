<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
            Create New User
    </jsp:attribute>

    <jsp:attribute name="footer">
            Create New User
    </jsp:attribute>

    <jsp:body>

        <h3>Create New User</h3>

        <form action="NewUser" method="post">
            <label for="username">Email here: </label>
            <input type="text" id="username" name="username"/>
            <label for="name">Name here: </label>
            <input type="text" id="name" name="name"/>
            <label for="password">Choose Password: </label>
            <input type="password" id="password" name="password"/>
            <label for="password">Confirm Password: </label>
            <input type="password" id="confirmpassword" name="confirmpassword"/><br><br>
            <input type="submit"  value="Create User"/>
        </form>

    </jsp:body>
</t:pagetemplate>