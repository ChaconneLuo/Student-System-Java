package com.luo.sys.controller.servlet;

import com.luo.sys.entity.TeacherInformation;
import com.luo.sys.entity.User;
import com.luo.sys.service.UserService;
import com.luo.sys.service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Operate/TeacherAccountCreate")
public class TeacherAccountCreateServlet extends HttpServlet {
    private final UserService userService;

    public TeacherAccountCreateServlet() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String collage = req.getParameter("collage");
        String age = req.getParameter("age");
        String home = req.getParameter("home");
        String email = req.getParameter("email");
        if (userService.getUid(username) != null)
        {
            resp.getWriter().print("<script>history.back(-1)</script>");
        }
        else
        {
            Boolean Sex = sex.equals("man")?true:false;
            Integer Age = Integer.valueOf(age);
            User u = new User(0,1,username,password,Sex,Age,email);
            userService.createUser(u);
            Integer uid = userService.getUid(username);
            TeacherInformation teacherInformation = new TeacherInformation(uid,collage,home);
            userService.createTeacher(teacherInformation);
            resp.sendRedirect("/Login/Success.html");
        }
    }
}
