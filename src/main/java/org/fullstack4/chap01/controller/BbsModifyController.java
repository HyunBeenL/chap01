package org.fullstack4.chap01.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BbsModifyController", value = "/bbs/modify")
public class BbsModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/bbs/modify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        boolean check_flag = true;
        String idx = req.getParameter("idx")==null?"":req.getParameter("idx");
        String title = req.getParameter("title");
        String reg_date = req.getParameter("reg_date");
        String content = req.getParameter("content");
        String[] hobbie = req.getParameterValues("hobbie");
        String sex = req.getParameter("sex");
        String titlerrmsg = "";
        String regDaterrmsg = "";
        String contenterrmsg = "";

        if(title == null || title.trim().isEmpty() || reg_date == null || reg_date.isEmpty() || content.isEmpty() || content == null) {
            if(title == null || title.trim().isEmpty()){
                titlerrmsg = "제목 입력";
            }
            if(reg_date == null || reg_date.trim().isEmpty()){
                regDaterrmsg = "날짜 입력";
            }
            if(content.isEmpty() || content == null){
                contenterrmsg = "내용 입력";
            }
            check_flag = false;
        }

        if(check_flag){
            System.out.println("수정 완료");
            resp.sendRedirect("/bbs/list");

        }else{
            System.out.println("수정 실패");
            req.getRequestDispatcher("/WEB-INF/bbs/modify.jsp?titlerrMsg="+titlerrmsg+"&regDaterrMsg="+regDaterrmsg+"&contenterrMsg="+contenterrmsg+"&idx="+idx).forward(req,resp);

        }

    }
}
