package com.luo.sys.controller;

import com.luo.sys.entity.StudentInformation;
import com.luo.sys.entity.StudentScore;
import com.luo.sys.entity.User;
import com.luo.sys.service.StudentService;
import com.luo.sys.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private final UserService userService;

    private final StudentService studentService;

    @PostMapping("/Operate/StudentAccountCreate")
    public void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
            User u = new User(0, 2, username, password, Sex, Age, email);
            userService.createUser(u);
            Integer uid = userService.getUid(username);
            StudentInformation si = new StudentInformation(uid, collage, Grade, major, Group, StudyYear, home);
            userService.createStu(si);
            StudentScore ss = new StudentScore(uid, -1, -1, -1, -1, -1, -1, -1);
            userService.createStuScore(ss);
            resp.sendRedirect("./Login/Success.html");
        }
    }

    @PostMapping("/Operate/StudentScoreEdit")
    public void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
        resp.sendRedirect("./Login/Success.html");
    }

    @PostMapping("/Operate/StudentAccountDelete")
    public void delete(@RequestParam("uid") String uid, HttpServletResponse resp) throws IOException {
        if (uid != null) {
            userService.deleteUser(Integer.valueOf(uid));
            resp.sendRedirect("./Login/Success.html");
        } else {

        }
    }

    @PostMapping("/Operate/SearchUid")
    public void search(@RequestParam("uid") String uid, HttpServletResponse resp) throws IOException {
        if (uid != null) {
            List<User> u = userService.getUser(Integer.valueOf(uid));
            for (User user : u) {
                if (user.getDeleted().equals(false)) {
                    System.out.println(user);
                }
            }
        }
    }

    @PostMapping("/Operate/GetStudentScore")
    public void getScore(@RequestParam("uid") String uid, HttpServletResponse resp) throws IOException {
        if (uid != null) {
            Map<String, Integer> stuScore = studentService.getStuScore(Integer.valueOf(uid));
            for (String key : stuScore.keySet()) {
                resp.getWriter().write(" " + key + ":" + stuScore.get(key) + " ");
            }
        }
    }
}
