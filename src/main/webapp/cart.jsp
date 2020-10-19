<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Shopping cart</title>
    <%@include file="parts_of_webpage/links.jsp"%>
    <%
        if(request.getParameter("cart") == null){
            response.sendRedirect("Servlet?cart=");
        }
    %>
</head>
<body>
<%--HEADER--%>
<%@include file="parts_of_webpage/header.jsp"%>

<%--CONTENT --%>
<main role="main">
    <div class="album py-5 bg-light">
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <h1>Information</h1>
                    <p>User name: <%=session.getAttribute("userName")%></p>
                    <p>User email: <%=session.getAttribute("userEmail")%></p>
                    <p>Session creation: <%=new Date(session.getCreationTime()) %></p>
                    <p>Last visit time: <%=new Date(session.getLastAccessedTime())%></p>
                    <br><br>
                </div>
                <div class="col-md-5">
                    <h1>Products for purchase</h1><br>
                    <table class="table table-bordered table-hover">
                        <c:if test="${cart_products != null}">
                            <thead class="thead-dark">
                            <tr>
                                <th scope="col">Name</th>
                                <th scope="col">Price</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${cart_products}">
                                <tr>
                                    <td>${item.getKey()}</td>
                                    <td>$${item.getValue()}</td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <th>Total: </th>
                                <th>$${total_sum}</th>
                            </tr>
                            </tbody>
                        </c:if>
                        <c:if test="${cart_products == null}">
                            There are no items...
                        </c:if>
                    </table>
                    <c:if test="${cart_products != null}">
                        <button class="btn btn-info">Pay</button>
                        <a href="Servlet?delete=" class="btn btn-danger">Delete all cart products</a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</main>
<%--FOOTER    --%>
<%@include file="parts_of_webpage/footer.jsp"%>
</body>
</html>
