package com.remcal.web.servlet;

import cn.dsna.util.images.ValidateCode;
import com.remcal.domain.User;
import com.remcal.service.UserService;
import com.remcal.service.impl.UserServiceImpl;
import com.remcal.utils.Base64Utils;
import com.remcal.utils.RandomUtils;
import com.remcal.utils.StringUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wgy
 * @version 1.0
 * @date 2019/10/30
 */
@WebServlet(name = "UserServlet",value = "/userservlet")
public class UserServlet extends BaseServlet {

    //注册
    public String regist(HttpServletRequest request,HttpServletResponse response) throws Exception{
        //获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        //校验
        if(StringUtils.isEmpty(username)){
            request.setAttribute("registerMsg", "用户不能为空");
            return "/register.jsp";
        }
        if(StringUtils.isEmpty(password)){
            request.setAttribute("registerMsg", "密码不能为空");
            return "/register.jsp";
        }
        if(!password.equals(repassword)){
            request.setAttribute("registerMsg", "两次密码不一致");
            return "/register.jsp";
        }
        if(StringUtils.isEmpty(email)){
            request.setAttribute("registerMsg", "邮箱不能为空");
            return "/register.jsp";
        }
        if(StringUtils.isEmpty(gender)){
            request.setAttribute("registerMsg", "性别不能为空");
            return "/register.jsp";
        }


        User user=new User(0, username, password, email, gender, 0, 1, RandomUtils.createActive());
        UserService userService=new UserServiceImpl();
        try {
            userService.regist(user);
            return "redirect:/registerSuccess.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("registerMsg", e.getMessage());
            return "/register.jsp";
        }


    }
    //登录
    public String login(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String vcode = request.getParameter("vcode");
        String auto = request.getParameter("auto");

        //校验
        if(StringUtils.isEmpty(username)){
            request.setAttribute("msg", "用户名不能为空");
            return "/login.jsp";
        }
        if(StringUtils.isEmpty(password)){
            request.setAttribute("msg", "密码不能为空");
            return "/login.jsp";
        }
        if(StringUtils.isEmpty(vcode)){
            request.setAttribute("msg", "验证码不能为空");
            return "/login.jsp";
        }
        String server_code = (String) request.getSession().getAttribute("server_code");
        if(!vcode.equalsIgnoreCase(server_code)){
            request.setAttribute("msg", "验证码错误");
            return "/login.jsp";
        }
        //调用业务层代码校验输入用户名和密码是否正确
        UserService userService=new UserServiceImpl();
        User user= null;
        try {
            user = userService.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "登录异常");
            return "/login.jsp";
        }
        if(user!=null){//说明用户名和密码正确
            if(user.getFlag()!=1){
                request.setAttribute("msg", "账号未激活或异常");
                return "/login.jsp";
            }
            //成功，放入session
            request.getSession().setAttribute("user", user);
            //判断是否选择了自动登录
            if(auto!=null){//选择了自动登录
                String userinfo=username+"#"+password;
                userinfo= Base64Utils.encode(userinfo);
                Cookie cookie=new Cookie("userinfo", userinfo);
                cookie.setMaxAge(60*60*24*7);
                cookie.setPath("/");
                cookie.setHttpOnly(true);
                response.addCookie(cookie);
            }

           return  "redirect:/index.jsp";


        }else{
            request.setAttribute("msg", "用户名或密码错误");
            return "/login.jsp";
        }


    }
    //验证码
    public String code(HttpServletRequest request,HttpServletResponse response) throws Exception{
        ValidateCode validateCode=new ValidateCode(100, 30, 4, 20);
        String code = validateCode.getCode();
        request.getSession().setAttribute("server_code", code);
        validateCode.write(response.getOutputStream());
        return null;

    }


}
