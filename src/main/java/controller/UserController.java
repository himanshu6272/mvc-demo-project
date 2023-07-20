package controller;

import model.User;
import org.apache.log4j.Logger;

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

    List<User> users= new ArrayList<>();

    public static final Logger logger = Logger.getLogger(UserController.class);
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//        Map<String, User> users= new HashMap<String, User>();
        User user = new User();
        user.setFirstName(req.getParameter("firstname"));
        user.setLastName(req.getParameter("lastname"));
        user.setEmail(req.getParameter("email"));
        user.setMobile(req.getParameter("mobile"));
        user.setPassword(req.getParameter("password"));
        user.setCity(req.getParameter("city"));
        user.setAddress(req.getParameter("address"));
        user.setDob(req.getParameter("dob"));
        user.setGender(req.getParameter("gender"));
//        users.put(user.getEmail(), user);
        users.add(user);

        HttpSession session = req.getSession();
        session.setAttribute("users", users);

//        System.out.println(user);
//        System.out.println(users);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>User Registered Successfully !!!!!</h1>");
        out.println("<a href='welcome.jsp'>view user detail</a>");

        logger.info("User Registered Successfully.....");

    }
}
