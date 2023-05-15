<%@page import="com.emergentes.model.Libro"%>
<%
    Libro libro = (Libro)request.getAttribute("libro");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
    </head>
    <body>
        <header>
            <h1>Editar</h1>
        </header>
        <main>
            <form method="post" action="MainController">
                <table>
                    <tr>
                        <td>Id:</td>
                        <td><input type="text" name="id" value="<%= libro.getId() %>" readonly></td>
                    </tr>
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="nombre" value="<%= libro.getNombre() %>"></td>
                    </tr>
                    <tr>
                        <td>Categoria:</td>
                        <td><input type="text" name="categoria" value="<%= libro.getCategoria() %>"></td>
                    </tr>
                    <tr>
                        <td>ISBN:</td>
                        <td><input type="text" name="isbn" value="<%= libro.getIsbn() %>"></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="option" value="edit"></td>
                        <td><input type="submit" value="Guardar"></td>
                    </tr>
                </table>
            </form>
        </main>
    </body>
</html>
