package config;

import dao.UserDao;
import model.User;
import org.apache.log4j.Logger;
import utils.ConnectionProvider;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MyFilter implements Filter {

    public static final Logger logger = Logger.getLogger(MyFilter.class);
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        UserDao userDao = new UserDao(ConnectionProvider.getConnection());
        List<User> users = userDao.getAllUsers();
        String newUserEmail = request.getParameter("email");
        boolean flag = false;
        if (users != null) {
            flag = users.stream().anyMatch(user -> user.getEmail().equals(newUserEmail));
        }
        if(flag){
            logger.info("User Already exists with this email!!!!!");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>User Already exists with this email!!!!!</h1>");
            out.println("<a href='index.html'>Register again</a>");
        }else {
            chain.doFilter(request, response);
        }

    }

}
