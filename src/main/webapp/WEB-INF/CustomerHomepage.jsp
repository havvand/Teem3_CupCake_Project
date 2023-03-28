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

          <form action="customerHomePage" method="post">
              <label for="bottom">Buy Cupcakes: </label>
              <input type="text" id="bottom" name="bottomType"/>
              <input type="submit"  value="Select"/>
                  ${bottomType}
          </form>

    </jsp:attribute>

    <jsp:attribute name="footer">
        Logged in area
    </jsp:attribute>

    <jsp:body>

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