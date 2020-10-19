<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>E-commerce webpage</title>
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <%@include file="parts_of_webpage/links.jsp"%>
</head>
<body>
<%--HEADER--%>
<%@include file="parts_of_webpage/header.jsp"%>
<script>console.log("Developer of webpage: <%=application.getInitParameter("Developer")%>")</script>
<%--CONTENT--%>
<main role="main">
    <div class="album py-5 bg-light">
        <div class="container">
            <h1>Choose category of products</h1><br>
            <div class="btn-group btn-group-toggle" data-toggle="buttons">
                <form action="Servlet" method="post">
                    <button class="btn btn-info" type="submit" name="all">All</button>
                </form>
                <form action="Servlet" method="post">
                    <button class="btn btn-info" type="submit" name="sport">Sport</button>
                </form>
                <form action="Servlet" method="post">
                    <button class="btn btn-info" type="submit" name="gadgets">Gadgets</button>
                </form>
                <form action="Servlet" method="post">
                    <button class="btn btn-info" type="submit" name="furniture">Furniture</button>
                </form>
                <form action="Servlet" method="post">
                    <button class="btn btn-info" type="submit" name="clothes">Clothes</button>
                </form>
            </div>
            <br><br>
            <div class="row">
                <c:if test="${products != null}">
                    <c:forEach var="product" items="${products}">
                        <div class="col-md-3">
                            <div class="card mb-3 shadow-sm">
                                <div class="card-body">
                                    <p class="card-text"><b>Name: </b> ${product.getProduct_name()}</p>
                                    <p class="card-text"><b>Price: </b> $${product.getProduct_price()}</p>
                                    <c:if test="${sessionScope.userName != null}">
                                        <div class="d-flex justify-content-between align-items-center">
                                            <div class="btn-group">
                                                <form action="Servlet">
                                                    <button type="submit" name="id" value="${product.getProduct_id()}" class="btn btn-warning">Add to cart</button>
                                                </form>
                                            </div>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
    </div>

</main>

<%--FOOTER--%>
<%@include file="parts_of_webpage/footer.jsp"%>
</body>
</html>




