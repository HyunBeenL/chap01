package org.fullstack4.chap01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/CalcController", urlPatterns="/calc")
public class CalcController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/input.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");


        if(num1 == null || num2 == null || num1.trim().isEmpty() || num2.trim().isEmpty()){
            System.out.println(String.format("num1:%s , num2:%s",num1,num2));
            request.getRequestDispatcher("/WEB-INF/input.jsp").forward(request, response);
        }
        else{
            response.sendRedirect("/");
        }

    }
}
