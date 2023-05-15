package com.emergentes.controlador;

import com.emergentes.model.Libro;
import com.emergentes.utils.ConnectionDataBase;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
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
        try {
            String option = request.getParameter("option");
            option = option != null ? option : "list";

            ArrayList<Libro> libros = new ArrayList<Libro>();

            ConnectionDataBase canal = new ConnectionDataBase();
            Connection connection = canal.Connect();
            PreparedStatement ps;
            ResultSet rs;

            if (option.equals("list")) {
                String sql = "select * from libros;";

                ps = connection.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    Libro libro = new Libro();
                    libro.setId(rs.getInt("id"));
                    libro.setNombre(rs.getString("nombre"));
                    libro.setCategoria(rs.getString("categoria"));
                    libro.setIsbn(rs.getInt("isbn"));

                    libros.add(libro);
                }
                request.setAttribute("libros", libros);
                request.getRequestDispatcher("lista.jsp").forward(request, response);
            }

            if (option.equals("edit")) {
                int id = Integer.parseInt((String) request.getParameter("id"));
                String sql = "select * from libros;";
                Libro libro = new Libro();

                ps = connection.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    if (id == rs.getInt("id")) {
                        libro.setId(rs.getInt("id"));
                        libro.setNombre(rs.getString("nombre"));
                        libro.setCategoria(rs.getString("categoria"));
                        libro.setIsbn(rs.getInt("isbn"));
                    }
                }

                request.setAttribute("libro", libro);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            }

            if (option.equals("borrar")) {
                int id = Integer.parseInt((String) request.getParameter("id"));
                String sql = "select * from libros;";
                Libro libro = new Libro();

                ps = connection.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    if (id == rs.getInt("id")) {
                        libro.setId(rs.getInt("id"));
                        libro.setNombre(rs.getString("nombre"));
                        libro.setCategoria(rs.getString("categoria"));
                        libro.setIsbn(rs.getInt("isbn"));
                    }
                }

                request.setAttribute("libro", libro);
                request.getRequestDispatcher("eliminar.jsp").forward(request, response);
            }

            connection.close();
            canal.Disconnect();

        } catch (Exception e) {
            System.out.println("Error en doGET()");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ConnectionDataBase canal = new ConnectionDataBase();
            Connection connection = canal.Connect();
            PreparedStatement ps;
            ResultSet rs;

            String option = (String) request.getParameter("option");
            System.out.println("optionssss: " + option);

            if (option.equals("new")) {
                String nombre = (String) request.getParameter("nombre");
                String categoria = (String) request.getParameter("categoria");
                String isbn = (String) request.getParameter("isbn");
                System.out.println("Nombre: " + nombre);
                String sql = "insert into libros(nombre, categoria, isbn) values('" + nombre + "','" + categoria + "'," + isbn + ");";
                ps = connection.prepareStatement(sql);
                int filasAfectadas = ps.executeUpdate(sql);
                System.out.println("Filas afectadas: " + filasAfectadas);
                response.sendRedirect("MainController");
            }
            
            if (option.equals("edit")) {
                String id = (String)request.getParameter("id");
                String nombre = (String) request.getParameter("nombre");
                String categoria = (String) request.getParameter("categoria");
                String isbn = (String) request.getParameter("isbn");
                System.out.println("Nombre: " + nombre);
                String sql = "update libros set nombre = '"+nombre+"', categoria = '"+categoria+"', isbn = "+isbn+" where id = "+id+";";
                System.out.println("sql: " + sql);
                ps = connection.prepareStatement(sql);
                int filasAfectadas = ps.executeUpdate(sql);
                System.out.println("Filas afectadas: " + filasAfectadas);
                response.sendRedirect("MainController");
            }

            connection.close();
            canal.Disconnect();

        } catch (Exception e) {
            System.out.println("Error: DoPost");
        }

    }

}
