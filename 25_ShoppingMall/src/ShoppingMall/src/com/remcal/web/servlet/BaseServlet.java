package com.remcal.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/10/30
 */
public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String methodname = request.getParameter("method");
        try {
            Method method = this.getClass().getMethod(methodname,HttpServletRequest.class,HttpServletResponse.class);
            if(method!=null){
                String url= (String) method.invoke(this,request,response);
                if(url!=null&&url!=""){
                    if(url.startsWith("redirect:")){
                        //重定向
                        String[] urls = url.split(":");
                        response.sendRedirect(request.getContextPath()+urls[1]);
                    }else {
                        request.getRequestDispatcher(url).forward(request, response);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
