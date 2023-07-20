package config;

import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MyFilter implements Filter {


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        List<User> users = (List)session.getAttribute("users");
        String newUserEmail = req.getParameter("email");
        boolean flag = false;
        if (users != null) {
            flag = users.stream().anyMatch(user -> user.getEmail().equals(newUserEmail));
        }
        if(flag){
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>User Already exists with this email!!!!!</h1>");
            out.println("<a href='index.html'>Register again</a>");
        }else {
            chain.doFilter(request, response);
        }

    }

}
