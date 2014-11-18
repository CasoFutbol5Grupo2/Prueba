<!--ESTO QUEDA-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <c:set var="actual" scope="session" value="${sessionScope.actual}"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/normalize2.css"/>
        <link rel="stylesheet" href="css/main2.css"/>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:800,400' rel='stylesheet' type='text/css'>
        <title>..::Mis Partidos::..</title>
    </head>
    <body>
        <a href="home.jsp">
            <img src="img/logoFutbol.jpg" />
        </a>
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
