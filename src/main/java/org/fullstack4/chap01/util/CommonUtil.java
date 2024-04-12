package org.fullstack4.chap01.util;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommonUtil {
    public static boolean login(HttpSession session){
        return session.getAttribute("user_id") != null;
    }
    public static boolean autologincheck(HttpServletRequest req) {
        return CookieUtil.getCookieValue(req, "user_id") != "";
    }
}
