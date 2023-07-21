package controller;

import dao.UserDao;
import model.User;
import org.apache.log4j.Logger;
import utils.ConnectionProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UserController extends HttpServlet {

//    List<User> users= new ArrayList<>();

    public static final Logger logger = Logger.getLogger(UserController.class);
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String password = req.getParameter("password");
        String city = req.getParameter("city");
        String address = req.getParameter("address");
        String dob = req.getParameter("dob");
        String gender = req.getParameter("gender");
//        users.add(user);
        User user = new User(firstname, lastname, email, mobile, dob, address, gender, city, password);

        UserDao userDao = new UserDao(ConnectionProvider.getConnection());

        if (userDao.registerUser(user)){
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<h1>User Registered Successfully !!!!!</h1>");
            out.println("<a href='welcome.jsp'>view user detail</a>");

            logger.info("User Registered Successfully.....");
        }else {
            logger.error("There might be something wrong in creating user........");
        }

//        HttpSession session = req.getSession();
//        session.setAttribute("users", users);
    }
}
