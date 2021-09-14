package az.nakhInternet.hr.controller;

import az.nakhInternet.hr.dao.LoginDao;
import az.nakhInternet.hr.dao.impl.LoginDaoImpl;
import az.nakhInternet.hr.model.Login;
import az.nakhInternet.hr.model.Role;
import az.nakhInternet.hr.service.LoginService;
import az.nakhInternet.hr.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "LoginServlet", value = "/ls")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "";
        String address = "";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginDao loginDao = new LoginDaoImpl();
        LoginService loginService = new LoginServiceImpl(loginDao);
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        try {
            if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
                Login login = loginService.login(username, password);
                if (login != null) {
                    Role role = login.getRole();
                    if (role != null) {
                        String roleName = role.getRole_name();
                        if (roleName.equalsIgnoreCase("role_admin")) {
                            HttpSession session = request.getSession(true);
                            session.setAttribute("login", login);
                            address = "main.jsp";
                        }
                    }
                } else {
                    request.setAttribute("msg", "Username or password is invalid");

                }
            } else {
                request.setAttribute("msg", "Username or password is empty");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (address != null) {
            request.getRequestDispatcher(address).forward(request, response);
        }
    }
}
