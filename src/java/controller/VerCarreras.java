/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author fredi
 */
@WebServlet(name = "VerCarreras", urlPatterns = {"/ver_carreras"})
public class VerCarreras extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            File file = new File("C://XML/carrera.xml");
            if (file.exists()) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(file);
                
                document.getDocumentElement().normalize();

                Element root = document.getDocumentElement();
                String clave = root.getElementsByTagName("clave").item(0).getTextContent();
                String carrera = root.getElementsByTagName("carrera").item(0).getTextContent();
                String duracion = root.getElementsByTagName("duracion").item(0).getTextContent();
                String campo = root.getElementsByTagName("campo").item(0).getTextContent();
                String nivel = root.getElementsByTagName("nivel").item(0).getTextContent();

                out.println("<h2>Carrera universitaria</h2>");
                out.println("<p>Clave: " + clave + "</p>");
                out.println("<p>Nombre de la carrera: " + carrera + "</p>");
                out.println("<p>Duración: " + duracion + " años</p>");
                out.println("<p>Campo: " + campo + "</p>");
                out.println("<p>Nivel: " + nivel + "</p>");
            } else {
                out.println("<p>Archivo XML no encontrado.</p>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Ocurrió un error al leer el archivo XML." + e);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
