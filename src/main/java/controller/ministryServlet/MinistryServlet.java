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
import java.util.List;

@WebServlet(name = "MinistryServlet", value = "/ministries")
public class MinistryServlet extends HttpServlet {
    private static IMinistry ministryService = new MinistryService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createForm(request, response);
                break;
            case "show":
                showAllMinistry(request, response);
                break;
            case "edit":
                editForm(request, response);
                break;
            case "delete":
                deleteMinistry(request, response);
                break;
            default:
                ministryLoginView(request, response);
                break;
        }
    }

    private void deleteMinistry(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            ministryService.deleteMinistry(id);
            response.sendRedirect("ministries");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) {
        int id_ministry = Integer.parseInt(request.getParameter("id"));
        Ministry ministry = ministryService.findById(id_ministry);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ministry/edit");
        request.setAttribute("ministry",ministry);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showAllMinistry(HttpServletRequest request, HttpServletResponse response) {
        List<Ministry> ministryList = ministryService.showMinistry();
        RequestDispatcher dispatcher = request.getRequestDispatcher("ministry/list.jsp");
        request.setAttribute("ministry", ministryList);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ministry/create.jsp");
        dispatcher.forward(request, response);
    }

    private void ministryLoginView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ministry/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addNewMinistry(request,response);
                break;
            case "edit":
                editMinistry(request,response);
                break;
        }
    }

    private void editMinistry(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        try {
            ministryService.updateMinistry(new Ministry(name,email,dob,address,phone));
            RequestDispatcher dispatcher = request.getRequestDispatcher("ministry/edit.jsp");
            dispatcher.forward(request,response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void addNewMinistry(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            ministryService.addMinistry(new Ministry(name,email,dob,address,phone,username,password));
            RequestDispatcher dispatcher = request.getRequestDispatcher("ministry/create");
            dispatcher.forward(request,response);
            request.setAttribute("message","add new ministry");
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }


}
