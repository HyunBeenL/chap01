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
<h1>게시판 등록</h1>

<div>
    <form name="frmRegist" id="frmRegist" method="post" action="/bbs/regist">
        <input type="hidden" name="user_id" id="user_id" value="test">
        <table>
            <tr>
                <td><span>제목 :</span></td>
                <td><input type="text" name="title" id="title" value="" maxlength="200" placeholder="글 제목을 입력하세요."/></td>
                <td style="color:red"><%=request.getParameter("titlerrMsg")==null?"":request.getParameter("titlerrMsg")%></td>
            </tr>
            <tr>
                <td><span>등록일 :</span></td>
                <td><input type="date" name="display_date" id="display_date" value="" /></td>
                <td style="color:red"><%=request.getParameter("regDaterrMsg")==null?"":request.getParameter("regDaterrMsg")%></td>
            </tr>
            <tr>
                <td><span>글 내용 :</span></td>
                <td><textarea name="content" id="content" rows="10" cols="80"></textarea></td>
                <td style="color:red"><%=request.getParameter("contenterrMsg")==null?"":request.getParameter("contenterrMsg")%></td>
            </tr>
<%--            <tr>--%>
<%--                <td><span>취미 :</span></td>--%>
<%--                <td>--%>
<%--                    <input type="checkbox" name="hobbie" id="hobbie_0" value="여행"> 여행--%>
<%--                    <input type="checkbox" name="hobbie" id="hobbie_1" value="독서"> 독서--%>
<%--                    <input type="checkbox" name="hobbie" id="hobbie_2" value="수영"> 수영--%>
<%--                    <input type="checkbox" name="hobbie" id="hobbie_3" value="잠자기"> 잠자기--%>
<%--                    <input type="checkbox" name="hobbie" id="hobbie_4" value="게임"> 게임--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td><span>성별 : </span></td>--%>
<%--                <td>--%>
<%--                    <input type="radio" name="sex" id="sex_0" value="남"> 남자--%>
<%--                    <input type="radio" name="sex" id="sex_1" value="여"> 여자--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
                <td colspan ="2">
                    <button type="submit">등록</button>
                    <button type="reset">취소</button>
                </td>
            </tr>
        </table>


    </form>

</div>
</body>
</html>
