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
</head>
<body>
    <h2>Registra una carrera universitaria</h2>
    <form action="${pageContext.request.contextPath}/carrera" method="POST">
        Clave <input type="number" name="clave" required><br>
        Nombre de la carrera <input type="text" name="carrera" required><br>
        Duración en años <input type="number" name="duracion" required><br>
        Campo: <input type="text" name="campo" required><br>
        Nivel: <input type="text" name="nivel" required><br>
        <input type="submit" name="accion" value="Enviar">
        
    </form>
        <a href="${pageContext.request.contextPath}/carrera">Ver las carreras</a>
</body>
</html>
