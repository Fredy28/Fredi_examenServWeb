<%-- 
    Document   : resultado
    Created on : 13-nov-2024, 20:27:26
    Author     : fredi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensaje</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f5f5f5;
                color: #333;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                height: 100vh;
                text-align: center;
            }
            h1 {
                font-size: 2em;
                color: #444;
                margin-bottom: 20px;
            }
            div {
                font-size: 1.2em;
                color: #666;
                margin-bottom: 40px;
            }
            a {
                display: inline-block;
                padding: 10px 20px;
                font-size: 1em;
                text-decoration: none;
                color: #fff;
                background-color: #007BFF;
                border-radius: 5px;
                transition: background-color 0.3s ease, transform 0.2s ease;
            }
            a:hover {
                background-color: #0056b3;
                transform: scale(1.05);
            }
        </style>
    </head>
    <body>
        <h1>Resultado</h1>
        <p><%= request.getAttribute("mensaje")%></p>
        <a href="jsp/carrera_form.jsp">Agregar otra carrera</a><br>
        <a href="http://localhost:8080/fredi3_evaluacion/carrera">Mostrar datos</a>
    </body>
</html>
