package edu.ulima.servlets;

import edu.ulima.bean.Reserva;
import edu.ulima.bean.Usuario;
import edu.ulima.jdbc.GestionDAO;
import edu.ulima.jdbc.GestionIF;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;


@WebServlet(name = "Servlet13", urlPatterns = {"/s13"})
public class Servlet13 extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CasoFutbol-SMSService/FutbolService.wsdl")
    private edu.ulima.ws.FutbolService_Service service;
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
               
        
        String tipo = request.getParameter("conf");
        
        GestionIF g = new GestionDAO();
        HttpSession ses = request.getSession(true);
       Reserva r = (Reserva) ses.getAttribute("detalleReserva");
       Usuario u = (Usuario) ses.getAttribute("actual");
        
        String msj="";
        boolean a;
        if (r.getConfimacion().equalsIgnoreCase("reserva")){
        if (tipo != null){
           if (tipo.equalsIgnoreCase("cancelado")){ 
           
         a= g.cancelarPartido(r);
         msj = "Partido Cancelado";
               notificacion(r.getId());
           }else{
               
           a = g.confirmarPartido(r);
           if(a!=false){g.rellenar(r);
           r=g.verPartido(r.getId());
           msj = "Partido Confirmado";
               confirmado(r.getId());
               rechazo(r.getId());
           }
           }
            if (a ==false ){
                msj = "Se requieren por lo menos 10 jugadores";
            }
        }else {
        msj = "No ha seleccionado ninguna opción";
        }
        }else{
        msj= "El partido ya ha sido actualizado anteriormente";
        }
        System.out.println(msj);
        ses.setAttribute("msjCancelado", msj);
        response.sendRedirect("home.jsp");
          
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

    private String notificacion(int id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        edu.ulima.ws.FutbolService port = service.getFutbolServicePort();
        return port.notificacion(id);
    }

    private String confirmado(int id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        edu.ulima.ws.FutbolService port = service.getFutbolServicePort();
        return port.confirmado(id);
    }

    private String rechazo(int id) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        edu.ulima.ws.FutbolService port = service.getFutbolServicePort();
        return port.rechazo(id);
    }


}
