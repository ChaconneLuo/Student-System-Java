package com.luo.sys.controller.servlet;

import com.luo.sys.entity.StudentScore;
import com.luo.sys.service.UserService;
import com.luo.sys.service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Operate/StudentScoreEdit")
public class StudentScoreEditServlet extends HttpServlet {
    private final UserService userService;

    public StudentScoreEditServlet() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uid = req.getParameter("uid");
        String math = req.getParameter("math");
        String english = req.getParameter("english");
        String history = req.getParameter("history");
        String python = req.getParameter("python");
        String clang = req.getParameter("clang");
        String physics = req.getParameter("physics");
        String cpp = req.getParameter("cpp");
        //req.getParameterMap()
        StudentScore studentScore = new StudentScore(Integer.valueOf(uid), Integer.valueOf(math), Integer.valueOf(english), Integer.valueOf(clang), Integer.valueOf(python), Integer.valueOf(history), Integer.valueOf(physics), Integer.valueOf(cpp));
        userService.setScore(studentScore);
        resp.sendRedirect("/Login/Success.html");
    }
}
