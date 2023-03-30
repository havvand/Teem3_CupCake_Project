<%--
  Created by IntelliJ IDEA.
  User: Salar Salim
  Date: 29-03-2023
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Velkommen kære kunde!

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

                </div>
                <div class="col">

                </div>
            </div>
            <div class="row align-items-center" style="min-height: 100px;">
                <div class="col">

                </div>
                <div class="col">
                    <form action="CustomerHomepage" method="post">
                        <button class="btn btn-lg btn-primary" type="submit">Lav en bestilling</button>
                    </form>
                </div>
                <div class="col">

                </div>
            </div>
            <div class="row align-items-end" style="min-height: 100px;">
                <div class="col">

                </div>
                <div class="col">

                </div>
                <div class="col">

                </div>
            </div>
        </div>

    </jsp:body>

</t:pagetemplate>