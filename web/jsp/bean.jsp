<%@page import="model.CarreraModel"%>
<%
    CarreraModel carrera = (CarreraModel) request.getAttribute("carrera");

    if (carrera != null) {
%>
<!DOCTYPE html>
<html>
<head>
    <title>Detalles de la Carrera</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            color: #333;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background: #fff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h3 {
            text-align: center;
            font-size: 1.5em;
            color: #444;
        }
        p {
            line-height: 1.6;
            font-size: 1em;
        }
        strong {
            color: #555;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 0.9em;
            text-decoration: none;
            color: #fff;
            background-color: #007BFF;
            border-radius: 5px;
            text-align: center;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h3>Detalles de la Carrera</h3>
        <p><strong>Clave:</strong> <%= carrera.getClave() %></p>
        <p><strong>Nombre de la carrera:</strong> <%= carrera.getCarrera() %></p>
        <p><strong>Duración:</strong> <%= carrera.getDuracion() %> años</p>
        <p><strong>Campo:</strong> <%= carrera.getCampo() %></p>
        <p><strong>Nivel:</strong> <%= carrera.getNivel() %></p>
        <a href="<%= request.getContextPath() %>/carrera">Volver a la Lista</a>
    </div>
</body>
</html>
<%
    } else {
%>
<!DOCTYPE html>
<html>
<head>
    <title>No hay datos disponibles</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
            color: #333;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        .message {
            text-align: center;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 0.9em;
            text-decoration: none;
            color: #fff;
            background-color: #007BFF;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="message">
        <p>No hay datos disponibles para mostrar.</p>
        <a href="<%= request.getContextPath() %>/carrera">Volver a la Lista</a>
    </div>
</body>
</html>
<%
    }
%>
