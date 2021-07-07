package com.luo.sys.controller.servlet;

import com.luo.sys.service.UserService;
import com.luo.sys.service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Operate/SearchUid")
public class SearchUidServlet extends HttpServlet {
    private final UserService userService;

    public SearchUidServlet()
    {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var uid = req.getParameter("uid");
        if(uid != null)
        {
            userService.getUser(Integer.valueOf(uid));
        }
    }
}
