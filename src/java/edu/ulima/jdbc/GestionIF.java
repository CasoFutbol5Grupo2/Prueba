
package edu.ulima.jdbc;

import edu.ulima.bean.Reserva;
import edu.ulima.bean.Usuario;
import java.sql.ResultSet;
import java.util.List;


public interface GestionIF {
    public Usuario registrarJugador(Usuario u);
    public Usuario loginJugador(String usuario, String clave);
    
    public Reserva crearPartido(Reserva p);
    public Reserva verPartido (int id);
    public List<Reserva> verPartidos();
    public boolean inscribirseAPartido(Usuario u, Reserva r, String tipo);      
    public boolean cancelarPartido(Reserva r);
    public boolean confirmarPartido(Reserva r);
    public List<Reserva> buscarPartidosOrganizados(Usuario u);
    public List<Reserva> buscarPartidosInscritos(Usuario u);
    public List<Reserva> buscarPartidosPorOrganizador(String user);
    public List<Reserva> buscarPartidosPorFecha(String fecha);
    public Reserva rellenar (Reserva r);
}
