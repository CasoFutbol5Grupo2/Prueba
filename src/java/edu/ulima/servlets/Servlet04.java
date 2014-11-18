package edu.ulima.servlets;

import edu.ulima.bean.Reserva;
import edu.ulima.bean.Usuario;
import edu.ulima.jdbc.GestionDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Servlet04", urlPatterns = {"/s04"})
public class Servlet04 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession(true);

        Usuario actual = (Usuario) ses.getAttribute("actual");
        String hora = (String) request.getParameter("hora");
            System.out.println(hora);
        String  fecha = (String) request.getParameter("fecha");

        GestionDAO g = new GestionDAO();
        Reserva r = new Reserva(hora, fecha,actual.getJugador());
        Reserva nuevo;
        nuevo = g.crearPartido(r);

        String msj;
        String redireccion;
        
        /*if ( nuevo .getId() == 0){

        if (nuevo.getCancha() ==11){
        msj = "No hay Cancha Dsiponible";
        redireccion="reserva.jsp";
        }else {
        msj= "Ya ha creado un partido a esa hora";
        redireccion="home.jsp";
        }

        }else {

        msj = "Partido Creado";
        redireccion = "home.jsp";
        }*/
        
        if(nuevo == null){
            msj = "Ya ha creado un partido a esa hora";
            redireccion="home.jsp";
        }else if(nuevo.getCancha()==11){
            msj = "No hay Cancha Dsiponible";
            redireccion="reserva.jsp";
        }else{
            msj = "Partido Creado";
            redireccion = "home.jsp";
        }
        
        
        System.out.println(msj);
        ses.setAttribute("reservamsj", msj);

        response.sendRedirect(redireccion);
        
        
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
