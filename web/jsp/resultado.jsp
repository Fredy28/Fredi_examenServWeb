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
    </head>
    <body>
        <h2>Resultado</h2>
        <p><%= request.getAttribute("mensaje")%></p>
        <a href="jsp/carrera_form.jsp">Agregar otra carrera</a>
        <a href="http://localhost:8080/fredi3_evaluacion/carrera">Mostrar datos</a>
    </body>
</html>
