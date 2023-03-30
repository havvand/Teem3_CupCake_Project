<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
            Brugeroprettelse
        <br>
        <br>
    </jsp:attribute>

    <jsp:attribute name="footer">
            Olsker Cupcakes
    </jsp:attribute>

    <jsp:body>

        <h4>Her kan du oprette en bruger, hvis du ikke allerede har en.</h4>
        <br>
        <br>

        <form action="NewUser" method="post">
            <label for="username">Email: </label>
            <input type="text" id="username" name="username"/>
            <label for="name">Navn: </label>
            <input type="text" id="name" name="name"/>
            <label for="password">Vælg et kodeord: </label>
            <input type="password" id="password" name="password"/>
            <label for="password">Bekræft kodeord: </label>
            <input type="password" id="confirmpassword" name="confirmpassword"/><br><br>
            <input type="submit"  value="Opret bruger"/>
        </form>

    </jsp:body>
</t:pagetemplate>