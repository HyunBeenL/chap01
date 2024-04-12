package org.fullstack4.chap01.controller;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.chap01.domain.MemberVO;
import org.fullstack4.chap01.dto.MemberDTO;
import org.fullstack4.chap01.service.MemberService;
import org.fullstack4.chap01.util.CommonUtil;
import org.fullstack4.chap01.util.CookieUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "LoginController", value = "/member/login")
public class LoginController extends HttpServlet {

    private MemberService service = MemberService.INSTANCE;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(!CommonUtil.login(session)) {
            req.setAttribute("save_id", CookieUtil.getCookieValue(req, "save_id"));
            req.getRequestDispatcher("/WEB-INF/member/login.jsp").forward(req, resp);
        }
        else{
            session.invalidate();
            CookieUtil.setDeleteCookie(resp,"user_id");
            resp.sendRedirect("/");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("user_id");
        String pwd = req.getParameter("pwd");
        String auto = req.getParameter("auto");
        String saved = req.getParameter("saved");

        System.out.println(auto);
        System.out.println(saved);

        HttpSession session = req.getSession();
        MemberVO vo = MemberVO.builder()
                .user_id(id)
                .pwd(pwd)
                .build();
        boolean login = service.login(vo);

        if(auto ==null){
            CookieUtil.setDeleteCookie(resp,"user_id");
        }
        if(saved ==null){
            CookieUtil.setDeleteCookie(resp,"save_id");
        }
        if(login){
            if(auto != null){
                CookieUtil.setCookies(resp,"","",50000,"user_id",id);
            }
            if(saved != null){
                CookieUtil.setCookies(resp,"","",50000,"save_id",id);
            }
            session.setAttribute("user_id",id);
            resp.sendRedirect("/");

        }else{
            req.setAttribute("errMsg", "로그인 오류");
            req.getRequestDispatcher("/WEB-INF/member/login.jsp").forward(req, resp);
        }
    }
}
