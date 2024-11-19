<%@page import="model.CarreraModel"%>
<%
    CarreraModel carrera = (CarreraModel) request.getAttribute("carrera");

    if (carrera != null) {
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Detalles de la Carrera</title>
    </head>
    <body>
        <h3>Detalles de la Carrera</h3>
        <p><strong>Clave:</strong> <%= carrera.getClave() %></p>
        <p><strong>Nombre de la carrera:</strong> <%= carrera.getCarrera() %></p>
        <p><strong>Duración:</strong> <%= carrera.getDuracion() %> años</p>
        <p><strong>Campo:</strong> <%= carrera.getCampo() %></p>
        <p><strong>Nivel:</strong> <%= carrera.getNivel() %></p>
        <a href="<%= request.getContextPath() %>/carrera">Volver a la Lista</a>
    </body>
</html>
<%
    } else {
%>
<p>No hay datos disponibles para mostrar.</p>
<a href="<%= request.getContextPath() %>/carrera">Volver a la Lista</a>
<%
    }
%>
