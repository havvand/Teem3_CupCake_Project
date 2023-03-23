<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the logged in area
    </jsp:attribute>

    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>

        <p>You should be logged in now</p>

        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="../login.jsp">Login</a></p>

        </c:if>
        <form action="itemPicker" method="post">
            <label for="topping">Choose topping: </label>
            <input type="text" id="topping" name="topping-type"/>
            <label for="bottom">Chose bottom: </label>
            <input type="text" id="bottom" name="bottom-type"/>
            <input type="submit"  value="Select"/>

            <p>${sessionScope.topping-type} dsada</p>
        </form>

        <h1> ARGHH ${sessionScope.topping-type}</h1>

    </jsp:body>

</t:pagetemplate>