package com.remcal.web.servlet;

import com.remcal.service.UserService;
import com.remcal.service.impl.UserServiceImpl;
import com.remcal.utils.Base64Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: test
 * @Descirption:
 * @Version: V1.01
 * @Author: FAT-Remcal
 * @DateTime: 11/11/2019 6:26 PM
 * @Signature: “闲庭书阁飞玉箫，Coding诗酒醉年华。”
 */
@WebServlet(name = "ActivateServlet",value = "/activate")
public class ActivateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("正在激活，请稍等………………");
        //获取数据
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String email = request.getParameter("e");
        String code = request.getParameter("c");

        UserService userService=new UserServiceImpl();
        try {
            //base64解码
            String realemail=Base64Utils.decode(email);
            String realcode=Base64Utils.decode(code);
            userService.activate(realemail,realcode);
            response.getWriter().write("激活成功！可以登录系统了...");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("对不起，激活失败!");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
