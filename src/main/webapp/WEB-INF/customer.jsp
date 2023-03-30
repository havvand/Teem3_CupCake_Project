<%--
  Created by IntelliJ IDEA.
  User: Salar Salim
  Date: 29-03-2023
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Byg din egne cupcakes, tilføj bestillingen og gå til kassen når du er færdig
        <br>
    </jsp:attribute>

    <jsp:attribute name="footer">
        Olsker Cupcakes
    </jsp:attribute>

    <jsp:body>
        <br>
        <div id class="container-fluid justify-content-center">
            <form action="topAndBottom" method="post">
                <div id="select1" class="product-options row justify-content-center"  data-toggle="buttons">
                    <h1> Vælg topping </h1>
                    <c:forEach var="top" items="${applicationScope.mapOne}">
                        <div class="card text-center m-2" style="width: 14rem; background-color: seashell">
                            <div class="card-body">
                                <h5 class="card-title">${top.key}</h5>
                                <p class="card-text"> <p>Pris ${top.value.price} Kr</p>
                                <input type="radio" class="btn-check" name="option1" value="${top.key}" id="${top.key}" autocomplete="off" checked>
                                <label class="btn btn-outline-primary" for="${top.key}">${top.key}</label><br>
                                <!--<label class="btn btn-default"><input type="radio" name="option1" value="${top.key}"><br>${top.key}</label>-->
                            </div>
                        </div>

                    </c:forEach>
                </div>

                <br>

                <div id="select2" class="product-options row justify-content-center" data-toggle="buttons">
                    <h1> Vælg bund </h1>
                    <c:forEach var="bottom" items="${applicationScope.mapTwo}">
                        <div class="card text-center bg-light m-2" style="width: 14rem;">
                            <div class="card-body">
                                <h5 class="card-title">${bottom.key}</h5>
                                <p class="card-text"> <p>Pris ${bottom.value.price} Kr</p>
                                <input type="radio" class="btn-check" name="option2" value="${bottom.key}" id="${bottom.key}" autocomplete="off" checked>
                                <label class="btn btn-outline-primary" for="${bottom.key}">${bottom.key}</label><br>



                            </div>
                        </div>
                    </c:forEach>
                </div>
                <br>
                <div class="container text-center">
                    <label for="quantity" class="form-label"></label>
                    <input type="text" id="quantity" name="quantity" placeholder="antal">
                </div>
                <br>
                <button type="submit" class="btn btn-outline-primary">Tilføj</button>

            </form>
        </div>

        <form action="CheckOut" method="post">
            <button type="submit" class="btn btn-outline-primary">Gå til kassen</button>
        </form>

    </jsp:body>

</t:pagetemplate>

