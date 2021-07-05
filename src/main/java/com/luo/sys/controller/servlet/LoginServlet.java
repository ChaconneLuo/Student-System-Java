package com.luo.sys.controller.servlet;

import com.luo.sys.service.UserService;
import com.luo.sys.service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Login/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService;

    public LoginServlet() {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String uid = req.getParameter("uid");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        Integer i = null;
        if(uid!=null){
            i = Integer.valueOf(uid);
        }
        Integer temp = userService.Login(i, password);
        if(temp==null)
        {
            resp.sendRedirect("/Login/loginFailure.html");
        }else {
            session.setAttribute("username",userService.getUserName(i));
            if (temp.equals(0)) {
                session.setAttribute("permission",0);
                resp.sendRedirect("/Operate/RootOperatePage.html");
            } else if (temp.equals(1)) {
                session.setAttribute("permission",1);
                resp.sendRedirect("/Operate/ManageOperatePage.html");
            } else if (temp.equals(2)) {
                session.setAttribute("permission",2);
                resp.sendRedirect("/Operate/StudentOperatePage.html");
            }
        }
    }
}
