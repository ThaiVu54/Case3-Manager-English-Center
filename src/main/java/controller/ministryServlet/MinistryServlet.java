package controller.ministryServlet;

import model.Ministry;
import service.accountMinistryService.AccountMinistry;
import service.accountMinistryService.IAccountMinistry;
import service.ministryService.IMinistry;
import service.ministryService.MinistryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MinistryServlet", value = "/ministries")
public class MinistryServlet extends HttpServlet {
    private static IMinistry ministry = new MinistryService();
    private static IAccountMinistry accountMinistry = new AccountMinistry();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "show":
                showMinistryForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "insert":
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int idMinistry = Integer.parseInt(request.getParameter("id"));
    }

    private void showMinistryForm(HttpServletRequest request, HttpServletResponse response) {
        List<Ministry> ministries = ministry.showMinistry();
        RequestDispatcher dispatcher = request.getRequestDispatcher("ministry/list.jsp");
        request.setAttribute("ministry",ministries);
        try {
            dispatcher.forward(request,response);
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
        switch (action){
            case "edit":
                break;
            case "insert":
                break;
        }
    }
}
