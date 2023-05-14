<%@page import="java.util.List"%>
<%@page import="com.emergentes.model.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Libro> libros = (List<Libro>)request.getAttribute("libros");
%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <h1>Libros</h1>
        </header>
        <main>
            <div>
                <h2>Libros encontrados</h2>
                <button onclick="window.location.href='agregar.jsp'">Agregar</button>
                <br><br>
                <table border="1" cellspacing="0">
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Categoria</th>
                        <th>ISBN</th>
                        <th colspan="2" >Modificar</th>
                    </tr>
                    <% for (Libro li : libros) { %>
                    <tr>
                        <td><%= li.getId() %></td>
                        <td><%= li.getNombre() %></td>
                        <td><%= li.getCategoria() %></td>
                        <td><%= li.getIsbn() %></td>
                        <td>
                            <button onclick="window.location.href='editar.jsp?id=<%= li.getId() %>'">Editar</button>
                        </td>
                        <td>
                            <button onclick="window.location.href='eliminar.jsp?id=<%= li.getId() %>'">Elimiar</button>
                        </td>
                    </tr>
                    <% } %>
                </table>
            </div>
        </main>
    </body>
</html>
