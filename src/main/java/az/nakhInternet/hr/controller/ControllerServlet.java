package az.nakhInternet.hr.controller;

import az.nakhInternet.hr.dao.DbHelper;
import az.nakhInternet.hr.dao.EmployeeDao;
import az.nakhInternet.hr.dao.RoleDao;
import az.nakhInternet.hr.dao.impl.EmployeeDaoImpl;
import az.nakhInternet.hr.dao.impl.RoleDaoImpl;
import az.nakhInternet.hr.model.Employee;
import az.nakhInternet.hr.model.Role;
import az.nakhInternet.hr.service.EmployeeService;
import az.nakhInternet.hr.service.RoleService;
import az.nakhInternet.hr.service.impl.EmployeeserviceImpl;
import az.nakhInternet.hr.service.impl.RoleServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "ControllerServlet", value = "/cs")
public class ControllerServlet extends HttpServlet {
    private String message;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        prosesRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        prosesRequest(request, response);
    }

    public void prosesRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String action = null;
        String address = null;
        RoleDao roleDao = new RoleDaoImpl();
        RoleService roleService = new RoleServiceImpl(roleDao);
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        EmployeeService employeeService = new EmployeeserviceImpl(employeeDao);
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        try {
            if (action.equalsIgnoreCase("register")) {
                Connection con = DbHelper.getConnection();
                if (con != null) {
                    out.write("SUCCESS");
                }
            } else if (action.equalsIgnoreCase("roleList")) {
                List<Role> roleList = roleService.getRoleList();
                request.setAttribute("roleList", roleList);
                address = "WEB-INF/pages/roleList1.jsp";
            } else if (action.equalsIgnoreCase("employeeList")) {
                List<Employee> employeeList = employeeService.getEmployeeList();
                request.setAttribute("employeeList", employeeList);
                address = "WEB_INF/pages/employeeList.jsp";
            } else if (action.equalsIgnoreCase("getEmployeeView")){
                List<Employee> employeeList = employeeService.getEmployeeList();
                request.setAttribute("employeeList", employeeList);
                address = "WEB_INF/pages/employeeList.jsp";
            }
            if (address != null) {
                request.getRequestDispatcher(address).forward(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}