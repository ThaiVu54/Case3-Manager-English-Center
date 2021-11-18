package controller;

import service.AdminManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class loginServlet extends HttpServlet {
    AdminManager adminManager=new AdminManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showLogin(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login(request,response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        boolean check = adminManager.checkAccount(username,password);
        RequestDispatcher dispatcher;
        if (check){
            dispatcher = request.getRequestDispatcher("Admin/showAdmin.jsp");
        }
        else{
            request.setAttribute("mess", "go fuck your self");
            dispatcher = request.getRequestDispatcher("Admin/adminLogin.jsp");
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLogin(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/adminLogin.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
