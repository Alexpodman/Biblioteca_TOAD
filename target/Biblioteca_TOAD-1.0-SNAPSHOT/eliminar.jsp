<%@page import="com.emergentes.model.Libro"%>
<%
    Libro libro = (Libro) request.getAttribute("libro");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar</title>
    </head>
    <body>
        <header>
            <h1>Eliminar</h1>
        </header>
        <main>
            <form method="post" action="MainController">
                <input type="hidden" name="option" value="borrar">
                <input type="hidden" name="id" value="<%= libro.getId()%>">
                <table border="1" cellspacing="0">
                    <tr>
                        <td>Id</td>
                        <td><%= libro.getId()%></td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><%= libro.getNombre()%></td>
                    </tr>
                    <tr>
                        <td>Categoria:</td>
                        <td><%= libro.getCategoria()%></td>
                    </tr>
                    <tr>
                        <td>ISBN</td>
                        <td><%= libro.getIsbn()%></td>
                    </tr>

                </table>
                <input type="submit" value="Eliminar">
                <a href="MainController">Cancelar</a>
            </form>
        </main>
    </body>
</html>
