<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sign up</title>
  <%@include file="parts_of_webpage/links.jsp"%>
  <style>
    html,
    body {
      height: 100%;
    }

    body {
      display: -ms-flexbox;
      display: flex;
      -ms-flex-align: center;
      align-items: center;
      padding-top: 40px;
      padding-bottom: 40px;
      background-color: #f5f5f5;
    }

    .form-signin {
      width: 100%;
      max-width: 330px;
      padding: 15px;
      margin: auto;
    }
    .form-signin .checkbox {
      font-weight: 400;
    }
    .form-signin .form-control {
      position: relative;
      box-sizing: border-box;
      height: auto;
      padding: 10px;
      font-size: 16px;
    }
    .form-signin .form-control:focus {
      z-index: 2;
    }
    .form-signin input[type="email"] {
      margin-bottom: -1px;
      border-bottom-right-radius: 0;
      border-bottom-left-radius: 0;
    }
    .form-signin input[type="password"] {
      margin-bottom: 10px;
      border-top-left-radius: 0;
      border-top-right-radius: 0;
    }
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
</head>
<body class="text-center">

<form class="form-signin" action="SignServlet" method="post">
  <h1 class="h3 mb-3 font-weight-normal">Sign up</h1>
  <span style="color: red"><%if(request.getAttribute("message")!=null){out.print(request.getAttribute("message"));}%></span>
  <label for="inputName" class="sr-only">Name</label>
  <input type="text" name="reg-name" id="inputName" class="form-control" placeholder="Name" required autofocus>

  <label for="inputEmail" class="sr-only">Email address</label>
  <input type="email" name="reg-email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>

  <label for="inputPassword" class="sr-only">Password</label>
  <input type="password" name="reg-pass" id="inputPassword" class="form-control" placeholder="Password" required>

  <label for="pass2" class="sr-only">Confirm password</label>
  <input type="password"name="reg-pass2" id="pass2" class="form-control" placeholder="Confirm password" required>

  <div class="checkbox mb-3">
    <label>
      <a href="login.jsp">Sign in.</a>
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit" name="register">Sign up</button>
  <p class="mt-5 mb-3 text-muted">&copy; 2020</p>
</form>
</body>
</html>