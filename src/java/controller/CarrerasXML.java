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
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author fredi
 */
@WebServlet(name = "CarrerasXML", urlPatterns = {"/carreras_xml"})
public class CarrerasXML extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CarrerasXML</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CarrerasXML at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        // Leer datos del formulario
        String clave = request.getParameter("clave");
        String carrera = request.getParameter("carrera");
        String duracion = request.getParameter("duracion");
        String campo = request.getParameter("campo");
        String nivel = request.getParameter("nivel");

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element root = document.createElement("carreras");
            document.appendChild(root);

            Element claveElement = document.createElement("clave");
            claveElement.appendChild(document.createTextNode(clave));
            root.appendChild(claveElement);

            Element carreraElement = document.createElement("carrera");
            carreraElement.appendChild(document.createTextNode(carrera));
            root.appendChild(carreraElement);

            Element duracionElement = document.createElement("duracion");
            duracionElement.appendChild(document.createTextNode(duracion));
            root.appendChild(duracionElement);
            
            Element campoElement = document.createElement("campo");
            campoElement.appendChild(document.createTextNode(campo));
            root.appendChild(campoElement);

            Element nivelElement = document.createElement("nivel");
            nivelElement.appendChild(document.createTextNode(nivel));
            root.appendChild(nivelElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            File file = new File("C://XML/carrera.xml");
            file.getParentFile().mkdirs(); //Crear el directorio si no existe

            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

            response.getWriter().println("Archivo XML creado con éxito en " + file.getAbsolutePath());

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
            response.getWriter().println("Ocurrió un error al crear el archivo XML." + e);
        }
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
