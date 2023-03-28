<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Build your cupcakes!
    </jsp:attribute>

    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>
        <div id class="text-center">
        <form action="topAndBottom" method="post">
            <div id="select1" class="product-options " data-toggle="buttons">
                <h1> Choose topping </h1>
                <c:forEach var="top" items="${applicationScope.mapOne}">
                    <label class="btn btn-default"><input type="radio" name="option1" value=" ${top.key}"> ${top.key} </label>
                </c:forEach>
            </div>

            <br>

            <div id="select2" class="product-options " data-toggle="buttons">
                <h1> Choose bottom </h1>
                <c:forEach var="bottom" items="${applicationScope.mapTwo}">
                    <label class="btn btn-default"><input type="radio" name="option2" value=" ${bottom.key}"> ${bottom.key} </label>
                </c:forEach>
            </div>
            <br>
            <div class="container text-center">
                <label for="quantity" class="form-label"></label>
                <input type="text" id="quantity" name="quantity" placeholder="quantity">
            </div>
            <br>
            <button type="submit" class="btn btn-outline-primary">Add</button>

        </form>
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