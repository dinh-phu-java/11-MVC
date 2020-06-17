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
        String action = request.getParameter("action");
        String url="/views/view.jsp";
        String message="";
        if (action==null){
            action="view";
        }
        switch(action){
            case "add":
                createProduct(request,response);
                url="/views/thanks.jsp";
                message="Them thanh cong";
                break;
            case "edit":
                editProduct(request,response);
                url="/views/thanks.jsp";
                message="Edit Thanh cong";
                break;
            default:
                url="/views/view.jsp";
                break;
        }
        request.setAttribute("message",message);
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        String productName=request.getParameter("productName");
        double productPrice=Double.parseDouble(request.getParameter("productPrice"));
        int productCode=Integer.parseInt(request.getParameter("productCode"));
        Product newProduct = new Product(productName,productPrice);
        products.update(productCode,newProduct);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String productName=request.getParameter("productName");
        double productPrice=Double.parseDouble(request.getParameter("productPrice"));
        Product newProduct = new Product(productName,productPrice);
        products.insert(newProduct);
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
                url="/views/edit.jsp";
                int productCode=Integer.parseInt(request.getParameter("productCode"));
                System.out.println(productCode);
                Product editProduct=products.findProduct(productCode);
                request.setAttribute("editProduct",editProduct);
                break;
            case "delete":
                int deleteCode=Integer.parseInt(request.getParameter("productCode"));
                products.delete(deleteCode);
                url="/views/thanks.jsp";
                request.setAttribute("message","Delete completed!");
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
