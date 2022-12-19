package com.luo.sys.controller;

import com.luo.sys.service.ManageService;
import com.luo.sys.service.StudentService;
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
public class RootMainController {
    private final UserService userService;
    private final ManageService manageService;
    private final StudentService studentService;

    @PostMapping("/Operate/RootOperatePage")
    public void root(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        Integer permission = (Integer) session.getAttribute("permission");
        System.out.println(username);
        if (permission == null) {
            System.out.println(username);
            resp.sendRedirect("./Login/login.html");
        } else {
            session.setAttribute("Login", 1);
        }
    }
}
