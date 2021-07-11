package com.luo.sys.controller.servlet;

import com.luo.sys.entity.User;
import com.luo.sys.service.UserService;
import com.luo.sys.service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
        String uid = req.getParameter("uid");
        if(uid != null)
        {
           List<User> u = userService.getUser(Integer.valueOf(uid));
           for(User user:u)
           {
               if(user.getDeleted().equals(false)) {
                   System.out.println(user);
               }
           }
        }
    }
}
