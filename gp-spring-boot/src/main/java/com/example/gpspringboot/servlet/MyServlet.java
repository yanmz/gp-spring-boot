package com.example.gpspringboot.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(
        name = "Myservlet",
        urlPatterns = "/MyServlet",
        initParams = {
                @WebInitParam(name = "name",value = "xiaoyan")
        }
)
public class MyServlet extends HttpServlet {

    public String name;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        name =  servletConfig.getInitParameter("name");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        ServletContext servletContext = getServletContext();
        servletContext.log("MyServlet.....");
        writer.write("<html><body>hello  word  "+name+"</body></html>");

    }
}
