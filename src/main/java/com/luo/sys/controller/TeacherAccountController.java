package com.luo.sys.controller;

import com.luo.sys.entity.TeacherInformation;
import com.luo.sys.entity.User;
import com.luo.sys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class TeacherAccountController {
    private final UserService userService;

    @PostMapping("/Operate/TeacherAccountCreate")
    public void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String collage = req.getParameter("collage");
        String age = req.getParameter("age");
        String home = req.getParameter("home");
        String email = req.getParameter("email");
        if (userService.getUid(username) != null) {
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
            resp.sendRedirect("./Login/Success.html");
        }
    }

    @PostMapping("/Operate/TeacherAccountDelete")
    public void delete(@RequestParam("uid") String uid, HttpServletResponse resp) throws IOException {
        if (uid != null) {
            userService.deleteUser(Integer.valueOf(uid));
            resp.sendRedirect("./Login/Success.html");
        } else {

        }
    }
}
