package com.remcal.web.filter;

import com.remcal.domain.User;
import com.remcal.service.UserService;
import com.remcal.service.impl.UserServiceImpl;
import com.remcal.utils.Base64Utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/11/2
 */
@WebFilter(filterName = "AutoLoginFilter",value = "/index.jsp")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //实现自动登录功能
        //1判断是否已经登录
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        User user = (User) request.getSession().getAttribute("user");
        if(user!=null){
            chain.doFilter(req, resp);
            return;
        }
        //2获取cookie
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("userinfo")){
                    String userinfo = cookie.getValue();
                    userinfo= Base64Utils.decode(userinfo);
                    String[] userinfos = userinfo.split("#");
                    UserService userService=new UserServiceImpl();
                    User user2=userService.login(userinfos[0], userinfos[1]);
                    if(user2!=null&&user2.getFlag()==1){//用户名或密码正确 并且状态正常
                        request.getSession().setAttribute("user", user2);
                        System.out.println("自动登录成功");
                    }else{
                        Cookie cookie2=new Cookie("userinfo", "");
                        cookie2.setMaxAge(0);
                        cookie2.setPath("/");
                        cookie2.setHttpOnly(true);
                        response.addCookie(cookie2);
                    }
                }
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
