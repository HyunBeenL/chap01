<%@ page import="org.fullstack4.chap01.util.CommonUtil" %>
<%@ page import="org.fullstack4.chap01.util.CookieUtil" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<% String cookie = CookieUtil.getCookieValue(request,"user_id")==null?"":CookieUtil.getCookieValue(request,"user_id");%>
<h1><%= "Hello World!" %></h1>
<ul>
    <li><a href="/bbs/regist">등록</a></li>
    <li><a href="/bbs/modify">수정</a></li>
    <li><a href="/bbs/delete">삭제</a></li>
    <li><a href="/bbs/list">리스트</a></li>
    <li><a href="/bbs/view">상세</a></li>
    <% if(!CommonUtil.login(session)){%>
    <li><a href="/member/login">로그인</a></li>
    <%}else{%>
    <li><a href="/member/login">로그아웃</a></li>
    <%}%>

</ul>
<br/>
<script>

</script>

</body>
</html>
