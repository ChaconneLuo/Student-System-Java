package com.luo.sys.controller.servlet;

import com.luo.sys.service.ManageService;
import com.luo.sys.service.StudentService;
import com.luo.sys.service.UserService;
import com.luo.sys.service.serviceImpl.ManageServiceImpl;
import com.luo.sys.service.serviceImpl.StudentServiceImpl;
import com.luo.sys.service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Operate/RootOperatePage")
public class RootMainServlet extends HttpServlet {
    private final UserService userService;
    private final ManageService manageService;
    private final StudentService studentService;

    public RootMainServlet() {
        userService = new UserServiceImpl();
        manageService = new ManageServiceImpl();
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        Integer permission = (Integer) session.getAttribute("permission");
        System.out.println(username);
        if (permission == null) {
            System.out.println(username);
            resp.sendRedirect("/Login/login.html");
        } else {
            session.setAttribute("Login", 1);
        }
    }
}
