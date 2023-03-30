<%--
  Created by IntelliJ IDEA.
  User: Salar Salim
  Date: 29-03-2023
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Kassen - færdiggør bestilling ved at betale

    </jsp:attribute>

    <jsp:attribute name="footer">
        Olsker Cupcakes
    </jsp:attribute>

    <jsp:body>

        <div class="container-fluid" style="min-height: 400px">
            <div class="row align-items-start" style="min-height: 100px;">
                <div class="col">

                </div>
                <div class="col">
                    <c:forEach var="order" items="${sessionScope.orders}">
                        <p>${order.name}</p>
                        <p>${order.price} Kr</p>
                    </c:forEach>
                </div>
                <div class="col">

                </div>
            </div>
            <div class="row align-items-center" style="min-height: 100px;">
                <div class="col">

                </div>
                <div class="col">
                    <h1>Total Pris:</h1>
                <h3>${sessionScope.price} Kr</h3>
                    <br>
                <h3>${requestScope.besked}</h3>
                </div>
                <div class="col">

                </div>
            </div>
            <div class="row align-items-end" style="min-height: 100px;">
                <div class="col">

                </div>
                <div class="col">
                    <form action="Pay" method="post">
                        <button class="btn btn-lg btn-primary" type="submit">Betal</button>
                    </form>
                </div>
                <div class="col">

                </div>
            </div>
        </div>

    </jsp:body>

</t:pagetemplate>