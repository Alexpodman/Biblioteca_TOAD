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
        <title>Biblioteca TOAD</title>
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
                            <form method="get" action="MainController">
                                <input type="hidden" name="option" value="edit">
                                <input type="hidden" name="id" value="<%= li.getId() %>">
                                <input type="submit" value="Editar">
                            </form>
                        </td>
                        <td>
                            <form method="get" action="MainController">
                                <input type="hidden" name="option" value="borrar">
                                <input type="hidden" name="id" value="<%= li.getId() %>">
                                <input type="submit" value="Eliminar">
                            </form>
                        </td>
                    </tr>
                    <% } %>
                </table>
            </div>
        </main>
    </body>
</html>
