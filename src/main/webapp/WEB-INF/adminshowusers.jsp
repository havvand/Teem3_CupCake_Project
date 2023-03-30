<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
           Brugerhistorik
        <br>
        <br>
    </jsp:attribute>

    <jsp:attribute name="footer">
     Olsker Cupcakes
    </jsp:attribute>

    <jsp:body>

        <c:forEach  var="users" items="${sessionScope.users}">
            <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col" id="userId">UserID</th>
                <th scope="col">User Name</th>
                <th scope="col" >Balance</th>
                <th scope="col" >OrderID</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th class="align-middle">${users.userId}</th>
                <td class="align-middle">${users.username}</td>
                <td class="align-middle">${users.balance}</td>
                <td class="align-middle">${users.orderId}</td>
            </tr>
            </tbody>
        </c:forEach>
        </table>

    </jsp:body>

</t:pagetemplate>
