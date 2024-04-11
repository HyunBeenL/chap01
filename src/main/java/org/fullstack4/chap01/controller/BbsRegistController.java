package org.fullstack4.chap01.controller;

import org.fullstack4.chap01.dto.BbsDTO;
import org.fullstack4.chap01.service.BbsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "BbsRegistController", value = "/bbs/regist")
public class BbsRegistController extends HttpServlet {

    private BbsService service = BbsService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/bbs/regist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        boolean check_flag = true;

//        String title = req.getParameter("title");
//        String reg_date = req.getParameter("reg_date");
//        String content = req.getParameter("content");
//        String[] hobbie = req.getParameterValues("hobbie");
//        String sex = req.getParameter("sex");
        String user_id = req.getParameter("user_id");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String display_date = req.getParameter("display_date");
        String titlerrmsg = "";
        String regDaterrmsg = "";
        String contenterrmsg = "";
//
        if(title == null || title.trim().isEmpty() || display_date == null || display_date.isEmpty() || content.isEmpty() || content == null) {
            if(title == null || title.trim().isEmpty()){
                titlerrmsg = "제목 입력";
            }
            if(display_date == null || display_date.trim().isEmpty()){
                regDaterrmsg = "날짜 입력";
            }
            if(content.isEmpty() || content == null){
                contenterrmsg = "내용 입력";
            }
            check_flag = false;
        }
//
//        System.out.println("등록 완료");
//        resp.setContentType("text/html; charset=UTF-8");
//        PrintWriter out = resp.getWriter();
//        out.println("<html>");
//        out.println("<body>");
//        out.println("<br>title : "+ title);
//        out.println("reg_date : "+ reg_date);
//        out.println("content : "+ content);
//        out.println("hobbie : "+ Arrays.toString(hobbie));
//        out.println("hobbie : ");
//        for(int i = 0; i<hobbie.length; i++){
//            out.println(hobbie[i] + ",");
//        }
//        out.println("sex : "+ sex);
//
//        out.println("</body>");
//        out.println("</html>");



//        if(check_flag){
//            System.out.println("등록 완료");
//            resp.sendRedirect("/bbs/list");
//
//        }else{
//            System.out.println("등록 실패");
//            req.getRequestDispatcher("/WEB-INF/bbs/regist.jsp?titlerrMsg="+titlerrmsg+"&regDaterrMsg="+regDaterrmsg+"&contenterrMsg="+contenterrmsg).forward(req,resp);
//
//        }

        if(check_flag) {

            int read_cnt = 0;
            BbsDTO dto = BbsDTO.builder()
                    .user_id(user_id)
                    .title(title)
                    .content(content)
                    .display_date(display_date)
                    .readcnt(read_cnt)
                    .build();
            int result = 0;

            try {
                result = service.regist(dto);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (result > 0) {
                System.out.println("등록 완료");
                resp.sendRedirect("/bbs/list");
            } else {
                req.setAttribute("result",result);
                req.getRequestDispatcher("/WEB-INF/views/bbs/regist.jsp").forward(req,resp);
            }
        }
        else{
            System.out.println("파라미터 체크");
            req.getRequestDispatcher("/WEB-INF/views/bbs/regist.jsp?titlerrMsg="+titlerrmsg+"&regDaterrMsg="+regDaterrmsg+"&contenterrMsg="+contenterrmsg).forward(req,resp);
        }
    }
}
