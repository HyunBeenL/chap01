package org.fullstack4.chap01.filter;

import lombok.extern.log4j.Log4j2;
import org.fullstack4.chap01.util.CommonUtil;
import org.fullstack4.chap01.util.CookieUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebFilter(urlPatterns = {"/*"})
public class AutoLoginCheck implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("auto login check");
        HttpServletRequest req =(HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        if(CommonUtil.autologincheck(req) && session.getAttribute("user_id") == null){
            session.setAttribute("user_id", CookieUtil.getCookieValue(req,"user_id"));
        }

        chain.doFilter(req,resp);

    }
}
