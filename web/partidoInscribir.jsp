<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>    
    <head>
        <c:set var="reserva" scope="session" value="${sessionScope.detalleReserva}"/>
        <c:set var="msjInscripcion" scope="session" value="${sessionScope.msjInscripcion}"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='http://fonts.googleapis.com/css?family=Bevan' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/foundation.css" />
        <link rel="stylesheet" href="css/main.css" />
        <title>.:Partido:.</title>
    </head>
    
    <body> 
        
        <div class="row" style="background: rgba(50,50,50,0.5);
    border-radius: 8px;">
            <div class="medium-2 columns">
                <a href="home.jsp">
                    <img src="img/logoFutbol.jpg" />
                </a>
            </div>            
            <div class="medium-2 columns"><br>
                <a href="mispartidos.jsp">Mis Partidos</a></div>

            <div class="medium-2 columns"><br>
                <a>Partidos Disponibles</a></div>    

            <div class="medium-2 columns"><br>
                <a>Reservar cancha</a></div>

            <div class="medium-2 columns"><br>
                <a>Mi Perfil</a></div>
            <div class="medium-2 columns"><br>
                <a>Logout</a></div>
                        
        </div>
        
        <br><br>            
            
                <div class="row">
                    <div class="small-12 columns">
                        <center class="enzo"><h1><font face="Showcard Gothic">Información del Partido  ${reserva.id}</font></h1></center>
                    </div>
                </div>
                <br> 
                <div class="row">
                    <div class="small-2 columns"></div>
                    <div class="small-4 columns blanco">
                        <p align="right"><b><font size=+1>Organizado por:</font></b></p>
                    </div>
                    <div class="small-4 columns blanco">
                        <p class="left">${reserva.organizador.nombre}&nbsp;${reserva.organizador.apellido}</p>
                    </div>
                    <div class="small-2 columns"></div>
                </div>
                <br>
                <div class="row">
                    <div class="small-2 columns"></div>
                    <div class="small-4 columns blanco">
                        <p align="right"><b><font size=+1>Hora:</font></b></p>
                    </div>
                    <div class="small-4 columns blanco">
                        <p class="left">${reserva.hora}</p>
                    </div>
                    <div class="small-2 columns"></div>
                </div>
                <br>
                <div class="row">
                    <div class="small-2 columns"></div>
                    <div class="small-4 columns blanco">
                        <p align="right"><b><font size=+1>Fecha:</font></b></p>
                    </div>
                    <div class="small-4 columns blanco">
                        <p class="left">${reserva.fecha}</p>
                    </div>
                    <div class="small-2 columns"></div>
                </div>
                <br>
                <div class="row">
                    <div class="small-2 columns"></div>
                    <div class="small-4 columns blanco">
                        <p align="right"><b><font size=+1>Cancha:</font></b></p>
                    </div>
                    <div class="small-4 columns blanco">
                        <p class="left">${reserva.cancha}</p>
                    </div>
                    <div class="small-2 columns"></div>
                </div>
                    <br>
                    <div class="row">
                        <div class="small-2 columns"></div>
                        <div class="small-4 columns blanco">
                            <p align="right"><b><font size=+1>¿Partido lleno?:</font></b></p>
                        </div>
                        <div class="small-4 columns blanco">
                            <p class="left">${reserva.lleno}</p>
                        </div>
                        <div class="small-2 columns"></div>
                    </div>  
                    
                         
            <div class="row">
                    <div class="small-12 columns">
                        <center class="blanco"><h3><font face="Showcard Gothic">Jugadores Garantizados</font></h3></center>
                    </div>
                </div>
                <br>
            <div class="row">
                <center>
                <table>
                    <tr>
                        <td>Nombre</td>
                        <td>Apellido</td>
                        <td>Email</td>
                        <td>Teléfono</td> 
                    </tr>
                    <c:forEach var="i" items="${detalleReserva.jugGarantizados}">
                        <tr>
                            <td>${i.nombre}</td>
                            <td>${i.apellido}</td> 
                            <td>${i.email}</td>
                            <td>${i.telefono}</td> 
                        </tr>            
                    </c:forEach>
                </table>
                    
            </div>
               
                <div class="row">
                    <div class="small-12 columns">
                        <center class="blanco"><h3><font face="Showcard Gothic">Jugadores Probables</font></h3></center>
                    </div>
                </div>
                <br>
            <div class="row">
                <center>
                <table>
                    <tr>
                        <td>Nombre</td>
                        <td>Apellido</td>
                        <td>Email</td>
                        <td>Teléfono</td> 
                    </tr>
                    <c:forEach var="i" items="${detalleReserva.jugProbables}">
                        <tr>
                            <td>${i.nombre}</td>
                            <td>${i.apellido}</td> 
                            <td>${i.email}</td>
                            <td>${i.telefono}</td> 
                        </tr>            
                    </c:forEach>
                </table>
                </center>
            </div>
                            
    <br>
            <form action="s12" method="POST">
                <div class="small-12 columns">
                    <center>¿Deseas inscribirte en este partido?</center>
                    <br>
                </div>
            <div class="row">                   
                    <div class="small-6 columns"><p align="right"><input type="radio" name="tipo" value="Probable"/>Probable</p>
                    </div>
                
                    <div class="small-6 columns"><p align="left"><input type="radio" name="tipo" value="Garantizado"/>Garantizado</p>
                    </div>
                <center>
                    <div class="small-12 columns"><button type="submit">Inscribirse</button>
                    </div>
                </center>
            </div>
            </form>    
    
    
    </body>
</html>