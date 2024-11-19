/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CarreraModel;
import utils.CustomResponsive;

/**
 *
 * @author fredi
 */
@WebServlet(name = "CarreraServlet", urlPatterns = {"/carrera_servlet"})
public class CarreraServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    private Connection conn2;

    // Método para obtener la conexión a la base de datos (debes configurarlo según tu base de datos)
    private Connection getConnection() throws SQLException, ClassNotFoundException {
        // Configura la conexión a tu base de datos
        String jdbcURL = "jdbc:mysql://localhost:3306/prueba";
        String jdbcUsername = "root";
        String jdbcPassword = "sql123";
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    /**
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        //Configuración del JSON que responderá la petición 
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<String> list = new ArrayList<>();

        List<CarreraModel> listaCarreras = new ArrayList<>();
        String sql = "SELECT clave, carrera, duracion, campo, nivel FROM carrera";

        try {
            conn2 = getConnection();
            PreparedStatement ps = conn2.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // Itera sobre los resultados y crea objetos UsuarioModel
            while (rs.next()) {
                CarreraModel carrera = new CarreraModel();
                carrera.setClave(rs.getInt("clave"));
                carrera.setCarrera(rs.getString("carrera"));
                carrera.setDuracion(rs.getInt("duracion"));
                carrera.setCampo(rs.getString("campo"));
                carrera.setNivel(rs.getString("nivel"));
            }

        } catch (Exception e) {
        }

        CustomResponsive cResponse = new CustomResponsive(200, "Ok", listaCarreras);

        String jsonResponse = new Gson().toJson(cResponse);
        response.getWriter().write(jsonResponse);
    }

}
