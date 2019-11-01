package com.mvc.web;

import com.mvc.domain.PageBean;
import com.mvc.domain.Student;
import com.mvc.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ListStudentServlet", value = "/liststudent")
public class ListStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNum = request.getParameter("pageNum");//此处是从浏览器接收数据的入口
        String pageSize = request.getParameter("pageSize");//此处是从浏览器接收数据的入口
        int pageN = 0;
        int pageS = 0;
        if (pageNum==null || pageNum.trim().length()==0) {
            pageN = 1;
        } else {
            pageN = Integer.parseInt(pageNum);// String --> Integer
        }
        if (pageSize==null || pageSize.trim().length()==0) {
            pageS = 20;
        } else {
            pageS = Integer.parseInt(pageSize);// String --> Integer
        }

        StudentServiceImpl studentService = new StudentServiceImpl();
        PageBean<Student> pageBean = studentService.findByPage(pageN, pageS);

        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("/student.jsp").forward(request, response);//转发出去的request和response对象是已经设置属性参数的
        System.out.println("pageBean.pageNum="+pageBean.getPageNum());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
