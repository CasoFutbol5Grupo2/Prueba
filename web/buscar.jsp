<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>..::Buscar::..</title>
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
        <div class="row">
            <form action="s08" method="POST">
            
            <div class="row">
                <div class="small-12 columns">
                    
                    <center class="enzo"><h1><font face="Showcard Gothic">Buscar Partido</font></h1></center>
                        
                </div>
            </div>
            <br>   
            
            <div class="row">
                <div class="small-3 columns"></div>
                    <div class="small-5 columns">
                        <p align="right"><input type="radio" name="eleccion" value="e1"><b><font size=+2>&nbsp&nbsp Organizador: </font></b></p>
                    </div>
                    <div class="small-3 large-4 columns">
                        <p class="left"><input type="text" name="organizador"/></p>
                    </div>
                <div class="small-2 columns"></div>
            </div>
                <br>
                
            <div class="row">                
                <div class="small-3 columns"></div>
                    <div class="small-5 columns">
                        <p align="right"><input type="radio" name="eleccion" value="e2"><b><font size=+2>&nbsp&nbsp Fecha:</font></b></p>
                    </div>
                    <div class="small-3 large-4 columns">
                        <p class="left"><input type="date" name="fechaBusq"/></p>                                        
                    </div>
                <div class="small-2 columns"></div>
            </div>
            <div class="row">                
                <div class="small-3 columns"></div>
                    <div class="small-5 columns">
                        <p align="right"><input type="radio" name="eleccion" value="e3"><b><font size=+2>&nbsp&nbsp Mostrar Todo</font></b></p><br>      
                    </div>
                   
                <div class="small-2 columns"></div>
            </div>
                
                <div class="row">                                         
                    <center><div class="small-12 columns"><button type="submit">Buscar</button>
                    </div></center>
                </div>  
        </form>
        
        </div>
     
    </center>
      
    </body>
</html>
