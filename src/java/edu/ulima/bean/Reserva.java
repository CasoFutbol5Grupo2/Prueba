

package edu.ulima.bean;

import java.util.ArrayList;
import java.util.List;


public class Reserva {
    
    private int id;
    private String hora;
    private String fecha;
    private Jugador organizador;
    private int cancha;
    private List<Jugador> jugGarantizados;
    private List<Jugador> jugProbables;
    private String confimacion;
    private String lleno;

    public Reserva(String hora, String fecha, Jugador organizador) {
        this.hora = hora;
        this.fecha = fecha;
        this.organizador = organizador;
        jugGarantizados = new ArrayList();
        jugProbables = new ArrayList();
        jugGarantizados.add(organizador);
        confimacion = "reserva";
        lleno = "No";
        
    }

    public Reserva(int id, String hora, String fecha, Jugador organizador,int cancha, 
            List<Jugador> jugGarantizados, List<Jugador> jugProbables, String estado, String lleno) {
        this.id = id;
        this.hora = hora;
        this.fecha = fecha;
        this.organizador = organizador;
        this.cancha=cancha;
        this.jugGarantizados = jugGarantizados;
        this.jugProbables = jugProbables;
        this.confimacion = estado;
        this.lleno = lleno;
    }

    public int getCancha() {
        return cancha;
    }

    public void setCancha(int cancha) {
        this.cancha = cancha;
    }

    public String getConfimacion() {
        return confimacion;
    }

    public void setConfimacion(String confimacion) {
        this.confimacion = confimacion;
    }
    
    

    public void agregarJugGarantizado(Jugador j){
    jugGarantizados.add(j);
    
    }
    
    public void agregarJugProblable(Jugador j){
    jugProbables.add(j);
    
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Jugador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Jugador organizador) {
        this.organizador = organizador;
    }

    public List<Jugador> getJugGarantizados() {
        return jugGarantizados;
    }

    public void setJugGarantizados(List<Jugador> jugGarantizados) {
        this.jugGarantizados = jugGarantizados;
    }

    public List<Jugador> getJugProbables() {
        return jugProbables;
    }

    public void setJugProbables(List<Jugador> jugProbables) {
        this.jugProbables = jugProbables;
    }

   

    public String getLleno() {
        return lleno;
    }

    public void setLleno(String lleno) {
        this.lleno = lleno;
    }
    
    
}
