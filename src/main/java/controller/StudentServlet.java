package controller;

import model.Grade;
import model.Student;
import service.gradeservice.GradeService;
import service.studentService.IStudentService;
import service.studentService.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    IStudentService studentService = StudentService.getInstance();
    GradeService gradeService = GradeService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
//        try {
        switch (action) {
            case "create":
                showCreateStudentForm(request, response);
                break;
            case "edit":
                editStudentShow(request, response);
                break;
            case "deletestudent":
                deleteStudent(request, response);
                break;
            default:
                listStudent(request, response);
                break;
//            }
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
    }

    private void editStudentShow(HttpServletRequest request, HttpServletResponse response) {
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showCreateStudentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
//        try {
        switch (action) {
            case "create":
                CreateNewStudent(request, response);
                break;
            case "edit":
                editStudentShow(request, response);
                break;
            case "deletestudent":
                deleteStudent(request, response);
                break;
            default:
                listStudent(request, response);
                break;
//            }
        }
    }

    private void CreateNewStudent(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int id = Integer.parseInt(request.getParameter("id"));
        int gradeID = Integer.parseInt(request.getParameter("gradID"));
        Grade grade = gradeService.selectGradebyId(gradeID);
        double mark = Double.parseDouble(request.getParameter("mark"));
        String name = request.getParameter("name");
        Student student = new Student(userName, password, dob, address, email, phone, id, grade, mark, name);
        studentService.addNewStudent(student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
