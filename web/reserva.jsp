<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*,java.text.*" %>

<html>
    <c:set var="reservamsj" scope="session" value="${sessionScope.reservamsj}"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/foundation.css" />
        <link rel="stylesheet" href="css/main.css" />
        <link href='http://fonts.googleapis.com/css?family=Bevan' rel='stylesheet' type='text/css'>
        <title>..:Pagina de Reserva:..</title>
    </head>
    <body>
        
        <a href="home.jsp">
            <img src="img/logoFutbol.jpg" />
        </a>
        
        <br><br>
        <center>
            
                <div class="row">
                    <form action="s04" method="POST">
                        <div class="row">
                            <div class="small-12 columns">
                                <center class="enzo">
                                    <h1><font face="Showcard Gothic">Reservar cancha</font></h1>
                                </center>
                            </div>
                        </div>
                        <br>   
                        <div class="row">
                            <div class="small-3 columns"></div>
                            <div class="small-5 columns">
                                <p align="right"><b><font size=+2>Fecha:</font></b></p>
                            </div>
                            <div class="small-3 large-4 columns">
                                <p class="left"><input type="date" name="fecha"/></p>
                            </div>
                            <div class="small-2 columns"></div>
                        </div>
                        <br>
                        <div class="row">                
                            <div class="small-3 columns"></div>
                            <div class="small-5 columns">
                                <p align="right"><b><font size=+2>Hora:</font></b></p>
                            </div>                            
                            <div class="small-3 large-2 columns">
                                <select name="hora" id="hora">
                                    <option value="8">08:00 - 09:00</option>
                                    <option value="9">09:00 - 10:00</option>
                                    <option value="10">10:00 - 11:00</option>
                                    <option value="11">11:00 - 12:00</option>
                                    <option value="12">12:00 - 13:00</option>
                                    <option value="13">13:00 - 14:00</option>
                                    <option value="14">14:00 - 15:00</option>
                                    <option value="15">15:00 - 16:00</option>
                                    <option value="16">16:00 - 17:00</option>
                                    <option value="17">17:00 - 18:00</option>
                                    <option value="18">18:00 - 19:00</option>
                                    <option value="19">19:00 - 20:00</option>    
                                </select>
                            </div>
                            <div class="small-2 columns"></div>
                        </div>
                        <div class="row">   
                            <center><div class="small-12 columns"><button type="submit">Reservar</button>
                                </div></center>
                        </div> 
                
              </form>                    
        </div> 
    </center>
    <c:if test="${reservamsj!=null}">
        <script type="text/javascript">
            alert("${reservamsj}");
        </script>
        <c:remove var="reservamsj" scope="session"/>
    </c:if>
    </body>
</html>
