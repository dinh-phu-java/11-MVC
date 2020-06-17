package dinhphu.com.Controller;

import dinhphu.com.Model.Product;
import dinhphu.com.Service.ProductService;
import dinhphu.com.Service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//@WebServlet(name = "ProductServlet",urlPatterns={"/index.jsp"})
public class ProductServlet extends HttpServlet {
    private ProductService products=new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter writer = response.getWriter();
//        writer.print("<p>access productServlet</p>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = products.findAll();
        request.setAttribute("products",productList);
        String action=request.getParameter("action");

        String url="/views/view.jsp";
        if (action==null){
            action="view";
            url="/views/view.jsp";
        }

        switch(action){
            case "edit":
                break;
            case "delete":
                break;
            case "create":
                 url= "/views/create.jsp";
                break;
            default:
                url="/views/view.jsp";
                break;
        }
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }


}
