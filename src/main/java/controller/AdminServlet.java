package controller;

import model.Admin;
import service.AdminManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {
    private AdminManager adminManager;
    @Override
    public void init() throws ServletException{
        adminManager=new AdminManager();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "edit":
                showEditAdminForm(request,response);
                break;
            default:
                showAdmin(request,response);
                break;
        }
    }

    private void showEditAdminForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Admin> admin=adminManager.selectAdmin();
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String dob=request.getParameter("dob");
        String address=request.getParameter("address");
        String phone=request.getParameter("phone");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        RequestDispatcher dispatcher=request.getRequestDispatcher("Admin/edit.jsp");
        request.setAttribute("Admin",admin);
        dispatcher.forward(request,response);
    }


    private void showAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Admin> adminList=adminManager.selectAdmin();
        request.setAttribute("Admin",adminList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("Admin/showAdmin.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "edit":
                try {
                    editAdmin(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void editAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String dob=request.getParameter("dob");
        String address=request.getParameter("address");
        String phone=request.getParameter("phone");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Admin admin=new Admin(name,email,dob,address,phone,username,password);
        adminManager.editAdmin(admin);
        RequestDispatcher dispatcher=request.getRequestDispatcher("Admin/edit.jsp");
        dispatcher.forward(request,response);
    }
}
