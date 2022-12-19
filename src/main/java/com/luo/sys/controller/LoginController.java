package com.luo.sys.controller;

import com.luo.sys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @PostMapping("/Login/login")
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        String uid = req.getParameter("uid");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        Integer i = null;
        if (uid != null) {
            i = Integer.valueOf(uid);
        }
        Integer temp = userService.Login(i, password);
        if (temp == null)
        {
            resp.sendRedirect("./Login/loginFailure.html");
        }else {
            session.setAttribute("username",userService.getUserName(i));
            if (temp.equals(0)) {
                session.setAttribute("permission",0);
                resp.sendRedirect("/Operate/RootOperatePage.html");
            } else if (temp.equals(1)) {
                session.setAttribute("permission",1);
                resp.sendRedirect("./Operate/ManageOperatePage.html");
            } else if (temp.equals(2)) {
                session.setAttribute("permission",2);
                resp.sendRedirect("./Operate/StudentOperatePage.html");
            }
        }
    }
}
