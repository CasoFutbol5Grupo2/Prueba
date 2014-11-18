package edu.ulima.servlets;

import edu.ulima.bean.Jugador;
import edu.ulima.bean.Usuario;
import edu.ulima.jdbc.GestionDAO;
import edu.ulima.jdbc.GestionIF;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Servlet02", urlPatterns = {"/s02"})
public class Servlet02 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession(true);
        GestionIF dao = new GestionDAO();
        String usuario = request.getParameter("usuario");
        String password1 = request.getParameter("password1");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        
        Jugador element = new Jugador(nombre, apellido, email, telefono);
        Usuario u = new Usuario(usuario, password1, element);
        
        u = dao.registrarJugador(u);
        
        if(u==null){
            ses.setAttribute("registro", "Usuario ya registrado");
            RequestDispatcher rd = request.getRequestDispatcher("registrate.jsp");
            rd.forward(request, response);
        }else{
            ses.setAttribute("registro", "Usuario registrado satisfactoriamente");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
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
