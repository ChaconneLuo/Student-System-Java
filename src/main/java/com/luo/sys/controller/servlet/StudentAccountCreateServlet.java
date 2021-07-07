package com.luo.sys.controller.servlet;

import com.luo.sys.entity.StudentInformation;
import com.luo.sys.entity.StudentScore;
import com.luo.sys.entity.User;
import com.luo.sys.service.UserService;
import com.luo.sys.service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Operate/StudentAccountCreate")
public class StudentAccountCreateServlet extends HttpServlet {
    private final UserService userService;

    public StudentAccountCreateServlet() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String collage = req.getParameter("collage");
        String major = req.getParameter("major");
        String group = req.getParameter("group");
        String age = req.getParameter("age");
        String studyYear = req.getParameter("studyYear");
        String home = req.getParameter("home");
        String email = req.getParameter("email");
        String grade = req.getParameter("grade");
        if (userService.getUid(username) != null)
        {
            resp.getWriter().print("<script>history.back(-1)</script>");
        }
        else
        {
            Boolean Sex = sex.equals("man")?true:false;
            Integer Group = Integer.valueOf(group);
            Integer StudyYear = Integer.valueOf(studyYear);
            Integer Age = Integer.valueOf(age);
            Integer Grade = Integer.valueOf(grade);
            User u = new User(0,2,username,password,Sex,Age,email);
            userService.createUser(u);
            Integer uid = userService.getUid(username);
            StudentInformation si = new StudentInformation(uid,collage,Grade,major,Group,StudyYear,home);
            userService.createStu(si);
            StudentScore ss = new StudentScore(uid,-1,-1,-1,-1,-1,-1,-1);
            userService.createStuScore(ss);
            resp.sendRedirect("/Login/Success.html");
        }
    }
}
