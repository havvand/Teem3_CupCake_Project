<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Admin
    </jsp:attribute>

    <jsp:attribute name="footer">
        Olsker Cupcakes
    </jsp:attribute>

    <jsp:body>

        <c:if test="${sessionScope.user != null}">
            <p>Som "${sessionScope.user.role}" har du følgende valgmuligheder:</p>
            <br>
            <form action="ShowHistory" method="post">
                <input type="submit"  value="Ordrerhistorik"/>
            </form>
            <form action="ShowUsers" method="post">
            <input type="submit"  value="Brugerhistorik"/>
            </form>
            <form action="AllUsers" method="post">
                <input type="submit"  value="Alle brugere"/>
            </form>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="../login.jsp">Login</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>