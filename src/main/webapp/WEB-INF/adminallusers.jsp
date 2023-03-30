<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
          Alle Brugere - her kan du se brugere og indsætte penge
        <br>
        <br>
    </jsp:attribute>

    <jsp:attribute name="footer">
       Olsker Cupcakes
    </jsp:attribute>

    <jsp:body>
        <form action="AddBalance" method="post">
            <label for="add">Indtast beløb</label>
            <input type="text" id="add" name="add"/>
            <label for="foruser">Indtast bruger-ID</label>
            <input type="text" id="foruser" name="foruser"/>
            <input type="submit" value="Indsæt"></input>
            <br>
            <br>
        </form>

        <c:forEach  var="users" items="${sessionScope.users}">
            <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col" id="userId">UserID</th>
                <th scope="col">User Name</th>
                <th scope="col" >Balance</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th class="align-middle">${users.userId}</th>
                <td class="align-middle">${users.username}</td>
                <td class="align-middle">${users.balance}</td>
            </tr>
            </tbody>
        </c:forEach>
        </table>

    </jsp:body>

</t:pagetemplate>
