<%@ page import="model.CarreraModel" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Lista de Carreras Universitarias</title>
        <style>
            table {
                width: 50%;
                border-collapse: collapse;
            }
            table, th, td {
                border: 1px solid black;
            }
            th, td {
                padding: 8px;
                text-align: center;
            }
            th {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <h2>Lista de Carreras</h2>
        <a href="${pageContext.request.contextPath}/jsp/carrera_form.jsp">AGREGAR CARRERA</a>
        <table>
            <thead>
                <tr>
                    <th>Clave</th>
                    <th>Nombre de la carrera</th>
                    <th>Duración en años</th>
                    <th>Campo</th>
                    <th>Nivel</th>
                    <th>Acción</th>
                </tr>
            </thead>
            <tbody>
                <%
                    // Recuperar la lista de carreras pasada desde el servlet
                    ArrayList<CarreraModel> listaCarreras = (ArrayList<CarreraModel>) request.getAttribute("carreras");

                    if (listaCarreras != null && !listaCarreras.isEmpty()) {
                        for (CarreraModel carrera : listaCarreras) {
                %>
                <tr>
                    <td><%= carrera.getClave()%></td>
                    <td><%= carrera.getCarrera()%></td>
                    <td><%= carrera.getDuracion()%></td>
                    <td><%= carrera.getCampo()%></td>
                    <td><%= carrera.getNivel()%></td>
                    <td>
                        <form action="<%= request.getContextPath()%>/bean_servlet" method="GET">
                            <!-- Campo oculto que pasa la clave -->
                            <input type="hidden" name="clave" value="<%= carrera.getClave()%>" />
                            <input type="submit" value="Ver Datos en Bean" />
                        </form>


                        <form action="<%= request.getContextPath()%>/carreras_xml" method="POST">
                            <input type="hidden" name="clave" value="<%= carrera.getClave()%>"/>
                            <input type="hidden" name="carrera" value="<%= carrera.getCarrera()%>"/>
                            <input type="hidden" name="duracion" value="<%= carrera.getDuracion()%>"/>
                            <input type="hidden" name="campo" value="<%= carrera.getCampo()%>"/>
                            <input type="hidden" name="nivel" value="<%= carrera.getNivel()%>"/>
                            <button type="submit">Descargar</button>
                        </form>

                        <form action="<%= request.getContextPath()%>/ver_carreras" method="GET">
                            <input type="hidden" name="clave" value="<%= carrera.getClave()%>"/>
                            <button type="submit">Ver XML</button>
                        </form>
                    </td>
                </tr>
                <%
                    }
                } else {
                %>
                <tr>
                    <td colspan="5">No hay carreras registradas.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
