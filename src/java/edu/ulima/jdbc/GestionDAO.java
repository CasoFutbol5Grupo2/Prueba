
package edu.ulima.jdbc;

import edu.ulima.bean.Jugador;
import edu.ulima.bean.Reserva;
import edu.ulima.bean.Usuario;
import edu.ulima.utils.DBConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GestionDAO implements GestionIF{
//cambiado para q busq id
    @Override
    public Usuario registrarJugador(Usuario u) {
        Connection con = DBConexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        int idjugador = buscarIdJugador();
        String sql= "INSERT into usuario  values(?,?,?)";
        String rpta;
        
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, idjugador);
            ps.setString(2, u.getUsuario());
            ps.setString(3, u.getPassword());
            ps.executeUpdate();
           
            sql= "INSERT into jugador values(?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            u.getJugador().setId(idjugador);
            ps.setInt(1, idjugador);
            ps.setString(2, u.getJugador().getNombre());
            ps.setString(3, u.getJugador().getApellido());
            ps.setString(4, u.getJugador().getEmail());
            ps.setString(5, u.getJugador().getTelefono());
            ps.executeUpdate();
            return u;
        } catch (SQLException ex) {
            
            
            return null;
            
        }
        
    }

    @Override
    public Usuario loginJugador(String usuario, String clave) {
        Connection con=DBConexion.getConnection();
        Jugador respuesta=null;
        PreparedStatement ps;
        ResultSet rs;
        String sql="SELECT a.idusuario, nombre, apellido, email, telefono FROM usuario a join "
                + "jugador b on a.idusuario=b.idusuario WHERE usuario = ? AND password = ?";
        Usuario u = null;
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            if(rs.next()){
                respuesta = new Jugador(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                u = new Usuario(usuario,clave,respuesta);
            }
            
        } catch (SQLException ex) {
            
            
        }
        
        return u;
    }
    
   
   
    
    @Override
    public Reserva crearPartido(Reserva p){
        
        Connection con = DBConexion.getConnection();
        
        PreparedStatement ps;
        ResultSet rs;
        p = buscarCancha(p);
        p.setId(buscarIdReserva());
        if (p.getCancha() != 11){
            String sql= "INSERT into reserva (idreserva, hora, fecha, organizador,  confirmacion, lleno, cancha) values(?,?,?,?,?,?,?)";
            System.out.println(p.getId());
           
            try {
                ps=con.prepareStatement(sql);
                ps.setInt(1, p.getId());
                ps.setString(2,p.getHora());
                ps.setString(3, p.getFecha());
                ps.setInt(4, p.getOrganizador().getId());
                ps.setString(5, p.getConfimacion());
                ps.setString(6, p.getLleno());
                ps.setInt(7, p.getCancha());

                ps.executeUpdate();




                sql = "INSERT into jxr values(?,?,?)";
                ps=con.prepareStatement(sql);
                ps.setInt(1, p.getOrganizador().getId());
                ps.setInt(2, p.getId());
                ps.setString(3, "Garantizado");
                ps.executeUpdate();

                return p;
            } catch (SQLException ex) {
                
                return null;

            }



        }
        
        return p; 
    }
     
    @Override
    public Reserva verPartido (int id){
    
     Connection con = DBConexion.getConnection();
        
        PreparedStatement ps;
        ResultSet rs;
        String sql= "select * from reserva where idreserva = ?";
        Reserva rpta =null;
        List<Jugador> jugGarantizados = new ArrayList();
        List<Jugador> jugProbables = new ArrayList();
        Jugador organizador = null;
        
        try {
            
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
          
            rs= ps.executeQuery();
            
            int idOrganizador;
      
            if (rs.next()){
                
                idOrganizador= rs.getInt(4);
                rpta = new Reserva(rs.getInt(1), rs.getString(2), rs.getString(3),  
                    organizador,rs.getInt(5), jugGarantizados, jugProbables, rs.getString(6), rs.getString(7));
            
            sql = "select * from jugador where idusuario =?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1, idOrganizador);
             
            rs = ps.executeQuery();
           
            if(rs.next()){
                organizador = new Jugador(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                rpta.setOrganizador(organizador);
            }
            
            sql ="select c.idusuario, nombre, apellido, email, telefono, estado from reserva a join "
                    + "jxr b on a.idreserva=b.idreserva join jugador c on b.idusuario=c.idusuario where a.idreserva = ?";
            
            ps=con.prepareStatement(sql);
            ps.setInt(1, rpta.getId());
             
            rs=ps.executeQuery();
           
            while(rs.next()){
                
                Jugador jug = new Jugador (rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5));
                if(rs.getString(6).equalsIgnoreCase("garantizado")){
                jugGarantizados.add(jug);
                }else{
                jugProbables.add(jug);
                }
            }
            }
            return rpta;
           
        } catch (SQLException ex) {
            
            return null;
        }
    
    
    }
       
   // @Override
    public List<Reserva> verPartidos(){
        List<Reserva> partidos = new ArrayList();
        Connection con = DBConexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String sql= "select * from reserva where confirmacion <> 'cancelado'";
        Reserva res;
        
         try {
             
             ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            
           while(rs.next()){
           res=verPartido(rs.getInt(1));
      
           partidos.add(res);
           }
           return partidos;
         }catch(SQLException ex){
    return null;
    }
    
    
    }
   
    @Override
     public boolean inscribirseAPartido(Usuario u, Reserva r, String tipo){
        Connection con = DBConexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String sql= "insert into jxr values (?,?,?)";
    int count=0;
    try {
        
        for (Jugador j : r.getJugGarantizados()){
        count++;
        }
        if(count <=9){
            ps = con.prepareStatement(sql);
            ps.setInt(1,u.getJugador().getId());
            ps.setInt(2, r.getId());
            ps.setString(3, tipo);
            ps.executeUpdate();
            
           
           return true;
        }else{
            return false;
        }
            
         }catch(SQLException ex){
            return false;
        }
    
    
    

    }
     
    @Override
    public boolean cancelarPartido(Reserva r){
    
    Connection con = DBConexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String sql= "update reserva set confirmacion='cancelado' where idreserva = ?";
    
    try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,r.getId());
                      
            ps.executeUpdate();
            
           
           return true;
         }catch(SQLException ex){
    return false;
    }
    
    
    
    }
    
    @Override
    public boolean confirmarPartido(Reserva r){
    
    Connection con = DBConexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        int count =0;
        String sql1 ="select idreserva, count(*) from jxr where idreserva = ? group by idreserva";
        String sql= "update reserva set confirmacion='confirmado' where idreserva = ?";
    
    try {
            
            ps = con.prepareStatement(sql1);
            ps.setInt(1,r.getId());
                      
           rs= ps.executeQuery();
            if(rs.next()){
            count = rs.getInt(2);
               
            }
           if (count>=10){
               
           ps = con.prepareStatement(sql);
            ps.setInt(1,r.getId());
                      
            ps.executeUpdate();
           return true;
           }else {
           return false;
           }
         }catch(SQLException ex){
    return false;
    }
    
    
    
    }
     
    @Override
    public List<Reserva> buscarPartidosOrganizados(Usuario u){
    List<Reserva> partidos = new ArrayList();
    
    
    Connection con = DBConexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String sql= "select * from reserva where organizador = ?";
        Reserva res;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, u.getJugador().getId());
            rs= ps.executeQuery();
            
           while(rs.next()){
           res=verPartido(rs.getInt(1));
           partidos.add(res);
           }
           return partidos;
        }catch(SQLException ex){
            return null;
        }
    
    
    }
    
    @Override
    public List<Reserva> buscarPartidosInscritos(Usuario u){
        List<Reserva> partidos = new ArrayList();
    
    
        Connection con = DBConexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String sql= "select a.idreserva from reserva a join jxr b on a.idreserva=b.idreserva where b.idusuario= ? and a.organizador <> ?";
        Reserva res;
        
         try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, u.getJugador().getId());
            ps.setInt(2, u.getJugador().getId());
            rs= ps.executeQuery();
            
           while(rs.next()){
           res=verPartido(rs.getInt(1));
           partidos.add(res);
           }
           return partidos;
         }catch(SQLException ex){
    return null;
    }
    
    
    }
    @Override
    public List<Reserva> buscarPartidosPorOrganizador(String user){
    List<Reserva> partidos = new ArrayList();
    
    
    Connection con = DBConexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String sql= "SELECT idreserva from reserva a join usuario b on a.organizador=b.idusuario where b.usuario= ? and confirmacion <> 'cancelado'";
        Reserva res;
        
         try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            rs= ps.executeQuery();
            
           while(rs.next()){
           res=verPartido(rs.getInt(1));
           partidos.add(res);
           }
           return partidos;
         }catch(SQLException ex){
            return null;
        }
    
    
    }
    @Override
    public List<Reserva> buscarPartidosPorFecha(String fecha){
    List<Reserva> partidos = new ArrayList();
    
    
    Connection con = DBConexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String sql= "SELECT idreserva from reserva where fecha =? and confirmacion <> 'cancelado'";
        Reserva res;
        
         try {
            ps = con.prepareStatement(sql);
            ps.setString(1, fecha);
            rs= ps.executeQuery();
            
           while(rs.next()){
           res=verPartido(rs.getInt(1));
           partidos.add(res);
           }
           return partidos;
         }catch(SQLException ex){
             return null;
        }
    
    
    }
    //busca el mayor id y regresa 1+
    private int buscarIdJugador(){
        int id=0;
        Connection con = DBConexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String sql= "select idusuario from usuario order by idusuario";
        try {
            ps = con.prepareStatement(sql);
            
            rs= ps.executeQuery(sql);
            
           while(rs.next()){
               if(rs.getInt(1)-1 ==id){
                   id=rs.getInt(1);
               }
           }
          id++;
         }catch(SQLException ex){
        
        }
    
    return id;
    }
     
    
    private int buscarIdReserva(){
        int id=0;
        Connection con = DBConexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String sql= "select idreserva from reserva order by idreserva";
        try {
            ps = con.prepareStatement(sql);
            
            rs= ps.executeQuery(sql);
            
           while(rs.next()){
              if(rs.getInt(1)-1 ==id){
                   id=rs.getInt(1);
               }
           }
          id++;
         }catch(SQLException ex){
        
        }
    
    return id;
    }
    
    private Reserva buscarCancha(Reserva p){
    
        Connection con = DBConexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String sql= "select cancha from reserva where hora = ? and fecha = ? and confirmacion = 'reserva' or confirmacion = 'confirmado'";
        int cancha = 0;
            
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,p.getHora());
            ps.setString(2, p.getFecha());
            rs=ps.executeQuery();
            while(rs.next()){
                if(rs.getInt(1)-1==cancha){
                cancha = rs.getInt(1);
                }
            }
            
            p.setCancha(cancha+1);
            
        }catch (Exception e){
        
        }
    return p;
    }

    public ResultSet listaContacto(){
        Connection con = DBConexion.getConnection();
        PreparedStatement ps;
        ResultSet rs=null;
        
        
        return rs;
    }
    
    @Override
    public Reserva rellenar (Reserva r){
        Connection con = DBConexion.getConnection();
        PreparedStatement ps;
        int cantGarant = r.getJugGarantizados().size();
        List<Jugador> listaProb = r.getJugProbables();
        int count=0;
        String sql ="update jxr set estado = 'Garantizado' where idreserva= ? and idusuario = ?";
        while (cantGarant==10){
            try{
                ps=con.prepareStatement(sql);
                ps.setInt(1, r.getId());
                ps.setInt(2, listaProb.get(count).getId());
                ps.executeUpdate();
                count++;
            }catch (SQLException e){
                
            }
            cantGarant++;
        }
        
        return r;
    }
}


