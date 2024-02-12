/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import Modelo.Estacion;
import Modelo.Tren;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bernardomartinez
 */
public class SvEstacion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvEstacion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvEstacion at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        String nombreEstacion=request.getParameter("nombreEstacion");
        String nombreCiudad=request.getParameter("nombreCiudad");
        List<Tren> trenes= (List<Tren>)session.getAttribute("trenLista");
        String[] listaCodigos=request.getParameterValues("trenesSeleccionados");
        List<Tren> trenesFiltrados=Tren.filtrarPorIdLocomotora(listaCodigos, trenes);
        Estacion estacion=new Estacion(nombreEstacion,nombreCiudad,trenesFiltrados);
        List<Estacion> listaEstaciones=(List<Estacion>)session.getAttribute("listaEstaciones");
        if(listaEstaciones==null){
            listaEstaciones=new ArrayList<>();
        }
        listaEstaciones.add(estacion);
        //Una lista de estaciones almacenada en la sesión 
        session.setAttribute("listaEstaciones",listaEstaciones);
        response.sendRedirect("resumenEstaciones.jsp");

        
        
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
