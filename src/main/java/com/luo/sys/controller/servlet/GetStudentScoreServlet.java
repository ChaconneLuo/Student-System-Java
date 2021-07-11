package com.luo.sys.controller.servlet;

import com.luo.sys.service.StudentService;
import com.luo.sys.service.serviceImpl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/Operate/GetStudentScore")
public class GetStudentScoreServlet extends HttpServlet {
    private final StudentService studentService;

    public GetStudentScoreServlet()
    {
        studentService = new StudentServiceImpl();
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
            Map<String, Integer> stuScore = studentService.getStuScore(Integer.valueOf(uid));
            for (String key:stuScore.keySet())
            {
                resp.getWriter().write(" "+key+":"+stuScore.get(key)+" ");
            }
        }
    }
}
