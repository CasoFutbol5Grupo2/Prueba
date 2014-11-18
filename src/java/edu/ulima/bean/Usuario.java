package edu.ulima.bean;

public class Usuario {
    
    
    private String usuario;
    private String password;
    private Jugador jugador;

    public Usuario(String usuario, String password, Jugador jugador) {
        this.usuario = usuario;
        this.password = password;
        this.jugador = jugador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    
    
}