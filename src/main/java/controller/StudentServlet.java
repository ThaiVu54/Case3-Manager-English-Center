package controller;

import model.Student;
import service.studentService.IStudentService;
import service.studentService.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {
    IStudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
//        try {
            switch (action) {
                case "create":
                    createStudentShow(request, response);
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

    private void createStudentShow(HttpServletRequest request, HttpServletResponse response) {
//        List<Student> studentList = studentService.addNewStudent();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
