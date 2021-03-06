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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MinistryServlet", value = "/ministries")
public class MinistryServlet extends HttpServlet {
    private static MinistryService ministryService = new MinistryService();
    private static IAccountMinistry accountMinistry = new AccountMinistry();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "show":
                showMinistryForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "create":
                showNewForm(request, response);
                break;
            case "delete":
                deleteMinistry(request, response);
                break;
            default:
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ministry/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void deleteMinistry(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            ministryService.deleteMinistry(id);
            response.sendRedirect("/ministries?action=show");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int idMinistry = Integer.parseInt(request.getParameter("id"));
        Ministry mnt = ministryService.findById(idMinistry);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ministry/edit.jsp");
        request.setAttribute("ministry", mnt);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showMinistryForm(HttpServletRequest request, HttpServletResponse response) {
        List<Ministry> ministries = ministryService.showMinistry();
        RequestDispatcher dispatcher = request.getRequestDispatcher("ministry/list.jsp");
        request.setAttribute("ministry", ministries);
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
        switch (action) {
            case "edit":
                editMinistry(request, response);
                break;
            case "create":
                createMinistry(request, response);
                break;
        }
    }

    private void createMinistry(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        Ministry ministry = new Ministry(name, email, dob, address, phone);
        try {
            ministryService.addMinistry(ministry);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ministry/create.jsp");
            request.setAttribute("ministry",ministry);
            request.setAttribute("message", "CREATED");
            dispatcher.forward(request, response);
        } catch (SQLException | IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void editMinistry(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        Ministry ministry1 = new Ministry(id, name, email, dob, address, phone);
        try {
            ministryService.updateMinistry(ministry1);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ministry/edit.jsp");
            request.setAttribute("ministry", ministry1);
            request.setAttribute("message", "Successfully edited!");
            dispatcher.forward(request, response);
        } catch (SQLException | IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
