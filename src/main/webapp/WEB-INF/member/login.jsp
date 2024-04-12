<%@ page import="org.fullstack4.chap01.util.CookieUtil" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-12
  Time: 오전 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 300px;
            margin: 100px auto;
            background-color: #fff;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        input[type="text"], input[type="password"] {
            width: calc(100% - 40px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Login</h2>
    <form action="/member/login" method="post">
        <input type="text" name="user_id" placeholder="User_id" value="${requestScope.save_id}"required>
        <input type="password" name="pwd" placeholder="Password" required>
        <label> 자동 로그인 </label><input type="checkbox" name="auto">
        <label> 아이디 저장 </label><input type="checkbox" name="saved">

        <input type="submit" value="Login">
    </form>
    <p style="color:red">${requestScope.errMsg}</p>
</div>
</body>
</html>

