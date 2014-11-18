<!--ESTO QUEDA-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <c:set var="actual" scope="session" value="${sessionScope.actual}"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href='http://fonts.googleapis.com/css?family=Bevan' rel='stylesheet' type='text/css'>
        
        <link rel="stylesheet" href="css/normalize2.css"/>
        <link rel="stylesheet" href="css/main2.css"/>
        <link rel="stylesheet" href="css/foundation.css" />
        <link rel="stylesheet" href="css/main.css" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:800,400' rel='stylesheet' type='text/css'>
        <title>..::Mis Partidos::..</title>
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
        
      <center>
          <br><br>
        <table cellpadding="15">
            <tr>
                <td>
                    <a href="s06">
                    <img src="img/Imagen5.jpg" />
                    </a>
                </td>       
            </tr>
              <tr>
                <td>
                    <a href="s07">
                    <img src="img/Imagen6.jpg" />
                    </a>
                </td>
            </tr>
        </table>
    </center>
    </body>
</html>
