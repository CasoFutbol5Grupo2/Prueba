<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <c:set var="PartidosBuscados" scope="session" value="${sessionScope.listaBuscada}"/>
    <c:set var="msjInscripcion" scope="session" value="${sessionScope.msjInscripcion}"/>
    <head>
        
        <title>..::Pagina de Inscritos::..</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='http://fonts.googleapis.com/css?family=Bevan' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/foundation.css" />
        <link rel="stylesheet" href="css/main.css" />
        
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
                        <p align="right"><b><font size=+1>Fecha:</font></b></p>
                    </div>
                    <div class="small-4 columns blanco">
                        <p class="left">${reserva.fecha}&nbsp;${reserva.hora}</p>
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
                     
                    
                         
            <div class="row">
                    <div class="small-12 columns">
                        <center class="blanco"><h3><font face="Showcard Gothic">Alineación</font></h3></center>
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
                        <center class="blanco01"><h3><font face="Showcard Gothic">Jugadores Probables</font></h3></center>
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
    
    </body>
    <c:if test="${msjInscripcion!=null}">
        <script type="text/javascript">
            alert("${msjInscripcion}");
        </script>
        <c:remove var="msjInscripcion" scope="session"/>
    </c:if>
</html>
