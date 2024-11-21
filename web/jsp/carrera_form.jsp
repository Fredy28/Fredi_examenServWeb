<%-- 
    Document   : carrera_form
    Created on : 13-nov-2024, 19:36:25
    Author     : fredi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Formulario de Carrera</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f9;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            h2 {
                text-align: center;
                color: #333;
            }

            form {
                background: #ffffff;
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
                width: 100%;
                max-width: 400px;
            }

            label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
                color: #555;
            }

            input[type="text"],
            input[type="number"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 16px;
            }

            input[type="submit"] {
                background-color: #007BFF;
                color: white;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
                width: 100%;
            }

            input[type="submit"]:hover {
                background-color: #007BFF;
                transform: scale(1.05);
            }

            a {
                display: block;
                text-align: center;
                margin-top: 20px;
                text-decoration: none;
                color: #007BFF;
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <div>
            <h2>Registra una carrera universitaria</h2>
            <form action="${pageContext.request.contextPath}/carrera" method="POST">
                <label for="clave">Clave</label>
                <input type="number" id="clave" name="clave" required>

                <label for="carrera">Nombre de la carrera</label>
                <input type="text" id="carrera" name="carrera" required>

                <label for="duracion">Duración en años</label>
                <input type="number" id="duracion" name="duracion" required>

                <label for="campo">Campo</label>
                <input type="text" id="campo" name="campo" required>

                <label for="nivel">Nivel</label>
                <input type="text" id="nivel" name="nivel" required>

                <input type="submit" name="accion" value="Enviar">
            </form>
            <a href="${pageContext.request.contextPath}/carrera">Ver las carreras registradas</a>
        </div>
    </body>    
</html>
