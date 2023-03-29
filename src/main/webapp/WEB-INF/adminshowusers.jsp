<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Welcome to the admin area
    </jsp:attribute>

    <jsp:attribute name="footer">
        Admin area
    </jsp:attribute>

    <jsp:body>
        <form action="AddBalance" method="post">
            <label for="add">Enter amount</label>
            <input type="text" id="add" name="add"/>
            <label for="foruser">Enter UserID</label>
            <input type="text" id="foruser" name="foruser"/>
            <input type="submit" value="add">Add</input>
        </form>

        <c:forEach  var="users" items="${sessionScope.users}">
            <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th scope="col" id="userId">UserID</th>
                <th scope="col">User Name</th>
                <th scope="col" >Balance</th>
                <th scope="col" >OrderID</th>
                <th scope="col" class="text-center">Action</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th class="align-middle">${users.userId}</th>
                <td class="align-middle">${users.username}</td>
                <td class="align-middle">${users.balance}</td>
                <td class="align-middle">${users.orderId}</td>
                <td class="text-center">

                    <form action="AddBalance" method="post">
                        <select name="adder">
                            <label for="amount">Amount</label>
                            <input type="text" value="${users.userId}" id="amount" name="amount"/>
                            <button type="submit" >Add</button>
                        </select>
                    </form>
                </td>
            </tr>
            </tbody>
        </c:forEach>
        </table>

    </jsp:body>

</t:pagetemplate>