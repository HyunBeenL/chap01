package org.fullstack4.chap01.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BbsDeleteController", value = "/bbs/delete")
public class BbsDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idx = req.getParameter("idx");
        System.out.println(idx+"번째 게시글 삭제 완료: GET");
        resp.sendRedirect("/bbs/list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idx = req.getParameter("idx");
        System.out.println(idx+"번째 게시글 삭제 완료: POST");
        resp.sendRedirect("/bbs/list");
    }
}
