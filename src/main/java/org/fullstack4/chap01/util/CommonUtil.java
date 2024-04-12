package org.fullstack4.chap01.util;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommonUtil {
    public static boolean login(HttpSession session){
        return session.getAttribute("user_id") != null;
    }

    public static boolean autologincheck(HttpServletRequest req) {
        String id = CookieUtil.getCookieValue(req, "user_id") ==null?"":CookieUtil.getCookieValue(req, "user_id");
        return id != "";
    }
}
