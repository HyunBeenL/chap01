package org.fullstack4.chap01.controller;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.chap01.dao.ConnectionUtil;
import org.fullstack4.chap01.service.BbsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
@Log4j2
@WebServlet(name = "BbsDeleteController", value = "/bbs/delete")
public class BbsDeleteController extends HttpServlet {
    private BbsService service = BbsService.INSTANCE;
    private ConnectionUtil connectionUtil = ConnectionUtil.INSTANCE;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idx = req.getParameter("idx");
        int result = 0;

        if(idx != null && Integer.parseInt(idx)>0){
            try{
                result = service.delete(Integer.parseInt(idx));
                log.info("============================");
                log.info("==========idx"+idx+"========");
                log.info("==========result"+result+"==");
                log.info("============================");

                if(result>0){
                    System.out.println(idx+"번째 게시글 삭제 완료: POST");
                    resp.sendRedirect("/bbs/list");
                }else{
                    req.setAttribute("idx",idx);
                    req.getRequestDispatcher("/WEB-INF/views/bbs/view.jsp").forward(req,resp);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
