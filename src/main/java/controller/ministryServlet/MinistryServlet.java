package controller.ministryServlet;

import model.Ministry;
import service.accountMinistryService.AccountMinistry;
import service.accountMinistryService.IAccountMinistry;
import service.ministryService.MinistryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MinistryServlet", value = "/ministries")
public class MinistryServlet extends HttpServlet {
//    private static MinistryService ministryService = new MinistryService();
//    private static IAccountMinistry accountMinistry = new AccountMinistry();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "show":
//                showMinistryForm(request, response);
//                break;
//            case "edit":
//                showEditForm(request, response);
//                break;
//            case "create":
//                showNewForm(request, response);
//                break;
//            case "delete":
//                deleteMinistry(request, response);
//                break;
//            default:
//                break;
//        }
  

}
