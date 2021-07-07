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
import java.io.IOException;

@WebServlet("/Operate/ManageOperatePage")
public class ManageMainServlet extends HttpServlet {
    private final UserService userService;
    private final ManageService manageService;
    private final StudentService studentService;

    public ManageMainServlet() {
        userService = new UserServiceImpl();
        manageService = new ManageServiceImpl();
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
