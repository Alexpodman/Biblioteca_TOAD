<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agreagar libro</title>
    </head>
    <body>
        <header>
            <h1>Agregar un Libro</h1>
        </header>
        <main>
            <form method="post" action="MainController">
                <table>
                    <tr>
                        <td>Nombre:</td>
                        <td><input type="text" name="nombre"></td>
                    </tr>
                    <tr>
                        <td>Categoria:</td>
                        <td><input type="text" name="categoria"></td>
                    </tr>
                    <tr>
                        <td>ISBN:</td>
                        <td><input type="text" name="isbn"></td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="option" value="new"></td>
                        <td><input type="submit" value="Agregar libro"></td>
                    </tr>
                </table>
            </form>
        </main>
    </body>
</html>
