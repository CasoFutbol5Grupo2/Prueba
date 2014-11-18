/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ulima.servlets;

import edu.ulima.bean.Reserva;
import edu.ulima.bean.Usuario;
import edu.ulima.jdbc.GestionDAO;
import edu.ulima.jdbc.GestionIF;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author D2042
 */
@WebServlet(name = "Servlet12", urlPatterns = {"/s12"})
public class Servlet12 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tipo = request.getParameter("tipo");
        
        GestionIF g = new GestionDAO();
        HttpSession ses = request.getSession(true);
       Reserva r = (Reserva) ses.getAttribute("detalleReserva");
       Usuario u = (Usuario) ses.getAttribute("actual");
        
        String msj;
        if (tipo != null){
        boolean a = g.inscribirseAPartido(u, r, tipo);
        if (a ==true ){
        msj = "Inscripccion Exitosa";
        
        } else {
        msj = "No se ha podido inscribir";
        }
        }else {
        msj = "No ha seleccionado ninguna opción";
        }
        System.out.println(msj);
        ses.setAttribute("msjInscripcion", msj);
        response.sendRedirect("partidosBuscados.jsp");
        
        
      
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
        processRequest(request, response);
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
