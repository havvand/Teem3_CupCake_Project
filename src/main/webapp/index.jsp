<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Velkommen til Olsker Cupcakes på nettet!
    </jsp:attribute>

    <jsp:attribute name="footer">
        Olsker Cupcakes
    </jsp:attribute>

    <jsp:body>

        <c:if test="${sessionScope.user != null}">
            <p>Du er  logget ind som "${sessionScope.user.role}".</p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>Du er ikke logget ind - det kan du gøre her: <a
                    href="login.jsp">Login</a></p>
            <p>Eller du kan oprette en ny bruger her: <a
                    href="newuser.jsp">Ny bruger</a></p>
        </c:if>

    </jsp:body>

</t:pagetemplate>