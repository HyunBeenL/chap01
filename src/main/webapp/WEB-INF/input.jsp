<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-03
  Time: 오후 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String errCode = request.getAttribute("errCode") == null?"": request.getAttribute("errCode")+"";
%>
<form name="frm" id="frmCalc" method="post" action="/calc">

    <input type="text" name="num1" /></br>
    <input type="text" name="num2" /></br>

    <div style="display:<%=(errCode != "" ? "block" : "none" )%>">에러</div>
    <input type="submit" value="END" /></br>

</form>

</body>
</html>
