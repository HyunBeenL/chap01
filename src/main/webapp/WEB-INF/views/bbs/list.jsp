<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-04-04
  Time: 오전 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset = "utf-8"/>
</head>
<body>
<h1>게시판 리스트</h1>

<%--<ul>--%>
<%--    <li>글번호 제목 등록일</li>--%>
<%--    <% for(int i =1; i<=10; i++){%>--%>
<%--    <li><a href="/bbs/view?idx=<%=i%>"><%=i%></a>&nbsp;&nbsp;게시판 글제목  <%=i%></li>--%>
<%--    <%}%>--%>
<%--</ul>--%>
    <ul>
        <c:forEach var="bbsDTO" items="${list}">
            <li><a href="/bbs/view?idx=${bbsDTO.idx}">${bbsDTO}</a></li>
        </c:forEach>
    </ul>
<br>

<button id="btn_regist" onclick="location.href='/bbs/regist'">글등록</button>

<br>

<ul>
    <li><a href="/bbs/regist">등록</a></li>
    <li><a href="/bbs/modify">수정</a></li>
    <li><a href="/bbs/delete">삭제</a></li>
    <li><a href="/bbs/list">리스트</a></li>
    <li><a href="/bbs/view">상세</a></li>
</ul>

</body>
</html>
