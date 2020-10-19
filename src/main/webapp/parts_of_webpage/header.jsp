<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Header of page--%>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
            <a class="navbar-brand" href="index.jsp">E-commerce</a>
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <c:if test="${sessionScope.userName != null}">
                    <li class="nav-item active">
                        <a class="nav-link" href="cart.jsp">Cart<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#"><%=session.getAttribute("userName")%><span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="SignServlet?logout=">Logout<span class="sr-only">(current)</span></a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.userName == null}">
                    <li class="nav-item active">
                        <a class="nav-link" href="login.jsp">Sign in/up <span class="sr-only">(current)</span></a>
                    </li>
                </c:if>

            </ul>
        </div>
    </nav>
</header>