package com.emergentes.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Iniciando proceso");
        String option = (request.getParameter("option") != null) ? request.getParameter("option") : "list";
        System.out.println("Opcion escogida: " + option);
        
        if (option.equals("new")) {
            // operaciones para nuevo
        }
        if (option.equals("edit")) {
            
        }
        if (option.equals("delete")) {
            
        }
        if (option.equals("list")) {
            response.sendRedirect("lista.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
