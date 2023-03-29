<%--
  Created by IntelliJ IDEA.
  User: havva
  Date: 27-03-2023
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the Customer Homepage

    </jsp:attribute>

    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>

        <div class="container-fluid" style="min-height: 400px">
            <div class="row align-items-start" style="min-height: 100px;">
                <div class="col">

                </div>
                <div class="col">
                    <c:forEach var="order" items="${sessionScope.orders}">
                        <p>${order.name}</p>
                        <p>${order.price}</p>
                    </c:forEach>
                </div>
                <div class="col">

                </div>
            </div>
            <div class="row align-items-center" style="min-height: 100px;">
                <div class="col">

                </div>
                <div class="col">

                </div>
                <div class="col">

                </div>
            </div>
            <div class="row align-items-end" style="min-height: 100px;">
                <div class="col">

                </div>
                <div class="col">
                    <form action="checkOut" method="post">
                        <button class="btn btn-lg btn-primary" type="submit">Pay</button>
                    </form>
                </div>
                <div class="col">

                </div>
            </div>
        </div>

        <p>You should be logged in now</p>

        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
        </c:if>

        <c:if test="${sessionScope.user == null}">
            <p>You are not logged in yet. You can do it here: <a
                    href="../login.jsp">Login</a></p>

        </c:if>

    </jsp:body>

</t:pagetemplate>