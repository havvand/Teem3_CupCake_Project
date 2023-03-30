<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Orderhistorik - her kan admin slette ordrer
        <br>
        <br>
    </jsp:attribute>

    <jsp:attribute name="footer">
        Olsker Cupcakes
    </jsp:attribute>

    <jsp:body>
        <form action="RemoveOrder" method="post">
            <label for="remove">Indtast OrderID</label>
            <input type="text" id="remove" name="remove"/>
            <input type="submit" value="Slet"></input>
            <br>
            <br>
        </form>

        <c:forEach  var="order" items="${sessionScope.history}">
            <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col">OrderID</th>
                <th scope="col">Price</th>
                <th scope="col" >UserID</th>
                <th scope="col" >Name</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th class="align-middle">${order.orderId}</th>
                <td class="align-middle">${order.price}</td>
                <td class="align-middle">${order.userId}</td>
                <td class="align-middle">${order.name}</td>
            </tr>
            </tbody>
        </c:forEach>
        </table>

    </jsp:body>

</t:pagetemplate>