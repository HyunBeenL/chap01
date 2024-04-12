package org.fullstack4.chap01.controller;

import org.fullstack4.chap01.util.CommonUtil;
import org.fullstack4.chap01.util.CookieUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StartController", value = "/")
public class StartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(CommonUtil.autologincheck(req)){
            System.out.println(CookieUtil.getCookieValue(req,"user_id"));
            session.setAttribute("user_id", CookieUtil.getCookieValue(req,"user_id"));
            System.out.println(session.getAttribute("user_id"));
        }
//        req.getRequestDispatcher("/index.jsp").forward(req,resp);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
