<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <c:set var="PartidosInscritos" scope="session" value="${sessionScope.listaBuscada}"/>
    <head>
        
        <title>..::Pagina de Inscritos::..</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='http://fonts.googleapis.com/css?family=Bevan' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/foundation.css" />
        <link rel="stylesheet" href="css/main.css" />
        
    </head>
    <body>
        <a href="home.jsp">
            <img src="img/logoFutbol.jpg" />
        </a>
    <br><br>
    <center>
        
        <div class="small-12 columns">
                <div class="org">
                <h3>Nombre de Jugador: ${actual.jugador.nombre}&nbsp;${actual.jugador.apellido}</h3>
                </div>
            </div>
        <div class="row">
            <table>
                <tr>
                    <td>
                        IdReserva
                    </td>
                    <td>
                        Organizador
                    </td>
                    <td>
                        Fecha
                    </td>
                    <td>
                        Hora
                    </td>
                    <td>
                        Cancha
                    </td>
                </tr>
                <form action="s08" method="POST">
                    <c:if test="${PartidosInscritos!=null}">
                        <c:forEach var="i" items="${PartidosInscritos}">
                            <tr>
                            <td>
                                <c:url var="url" value="http://localhost:8080/CasoFutbol5Grupo2/s11" >
                                <c:param name="idReserva" value="${i.id}" />
                                </c:url>
                                <a href="s11?idReserva=${url}"><c:out value="${i.id}"/></a>
                            </td>
                            <td>
                                <c:out value="${i.organizador.nombre}"/>
                            </td>
                            <td>
                                <c:out value="${i.fecha}"/>
                            </td>
                            <td>
                                <c:out value="${i.hora}"/>
                            </td>
                            <td>
                                <c:out value="${i.cancha}"/>
                            </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </form>
            </table>
            
            
        
        </div>
     
    </center>
    
    </body>
</html>
