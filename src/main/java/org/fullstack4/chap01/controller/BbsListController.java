package org.fullstack4.chap01.controller;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.chap01.domain.BbsVO;
import org.fullstack4.chap01.dto.BbsDTO;
import org.fullstack4.chap01.service.BbsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet(name = "BbsListController", value = "/bbs/list")
public class BbsListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("===============================================");
        System.out.println("/bbs/list");
        System.out.println("===============================================");

        ServletContext servletContext = req.getServletContext();

        log.info("appName :" + servletContext.getAttribute("appName"));
        List<BbsDTO> dtoList = null; /// 데이터베이스에서 추가한듯 추가댐
        try {
            dtoList = BbsService.INSTANCE.bbsList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("list",dtoList);
        req.getRequestDispatcher("/WEB-INF/views/bbs/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
