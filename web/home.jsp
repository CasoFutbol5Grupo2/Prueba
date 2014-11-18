<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <c:set var="actual" scope="session" value="${sessionScope.actual}"/>
    <c:set var="reservamsj" scope="session" value="${sessionScope.reservamsj}"/>
    <c:set var="msjCancelado" scope="session" value="${sessionScope.msjCancelado}"/>
  <head>
      
        <title>..::Pagina de Inicio::..</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/normalize2.css"/>
        <link rel="stylesheet" href="css/main2.css"/>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:800,400' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <br>
        <div class="welcome" align="right">
            <h1>Bienvenido: 
                ${actual.jugador.nombre}&nbsp;${actual.jugador.apellido}
            </h1>
        </div>
        
    <center>
        
        <table cellpadding="15">
            <tr>
                <td>
                    <a href="reserva.jsp">
                    <img src="img/Imagen1.jpg" />
                    </a>
                </td>
                <td>
                    <a href="mispartidos.jsp">
                    <img src="img/Imagen3.jpg" />
                    </a>
                </td>               
            </tr>
              <tr>
                <td>
                    <a href="buscar.jsp">
                    <img src="img/Imagen2.jpg" />
                    </a>
                </td>
                <td>
                    <a href="s03">
                    <img src="img/Imagen4.jpg" />
                    </a>
                </td>    
            </tr>
        </table>
    </center>
    
    <c:if test="${reservamsj!=null}">
        <script type="text/javascript">
            alert("${reservamsj}");
        </script>
        <c:remove var="reservamsj" scope="session"/>
    </c:if>
        
        <c:if test="${msjCancelado!=null}">
        <script type="text/javascript">
            alert("${msjCancelado}");
        </script>
        <c:remove var="msjCancelado" scope="session"/>
    </c:if>
    </body>
</html>
