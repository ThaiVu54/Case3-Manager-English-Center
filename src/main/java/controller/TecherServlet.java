package controller;
import model.Teacher;
import service.courseservice.CourseService;
import service.teacherservice.TeacherSevice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TecherServlet", value = "/teacherservlet")
public class TecherServlet extends HttpServlet {
    private TeacherSevice teacherService;
    private CourseService courseService;

    @Override
    public void init() throws ServletException {
        teacherService = new TeacherSevice();
        courseService = new CourseService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default: teacherLoginView(request, response); break;
        }
    }

    private void teacherLoginView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("teacherview/teacherlogin.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default: teacherLogin(request, response); break;
        }
    }

    private void teacherLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Teacher teacher = null;
        boolean check = false;
        List<Teacher> teachers = teacherService.selectAllTeacher();
        for (Teacher teach: teachers){
            if (teach.getUserName().equals(username) && teach.getPassword().equals(password)){
                teacher = teach;
                check = true;
                break;
            }
        }
        if (check){
            request.setAttribute("teacher", teacher);
            RequestDispatcher dispatcher = request.getRequestDispatcher("teacherview/welcometeacher.jsp");
            dispatcher.forward(request, response);
        }
        else {
            request.setAttribute("message", "Khong thanh cong");
            RequestDispatcher dispatcher = request.getRequestDispatcher("teacherview/teacherlogin.jsp");
            dispatcher.forward(request, response);
        }
    }
}
