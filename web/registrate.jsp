<!--ESTO YA NO SIRVE C:-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <c:set var="mensaje" scope="session" value="${sessionScope.registro}"/>
        <title>..::Página de Registro::..</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <link rel="stylesheet" href="css/foundation.css" />
        <link rel="stylesheet" href="css/main3.css" />
        <link href='http://fonts.googleapis.com/css?family=Bevan' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:800,400' rel='stylesheet' type='text/css'>
        
    </head>
    
    <body class="registro">
        <br><br>
    <center>
        <div class="row">
            <form action="s02" method="POST">              
                <div class="row">
                        <div class="small-12 columns">
                        
                            <center class="enzo"><h1><font face="Showcard Gothic">Regístrate</font></h1></center>
                        
                        </div>
                    </div>
                
                <br>    
                <div class="row">
                    
                    <div class="small-6 columns">
                        <p align="right"><font size=+2>Nombres:</font></p></div>
                        <div class="small-3 large-4 columns">
                        <input type="text" name="nombre" required></div>
                    <div class="small-3 columns"></div>
                </div>
                
                
                <div class="row">
                    
                    <div class="small-6 columns">
                        <p align="right"><font size=+2>Apellidos:</font></p>
                    </div>
                        <div class="small-3 large-4 columns">
                        <input type="text" name="apellido" required></div>
                    <div class="small-2 columns"></div>
                </div>     
                    
                <div class="row">
                    <div class="small-6 columns">
                        <p align="right"><font size=+2>Email:</font></p></div>
                    <div class="small-3 large-4 columns">
                        <input type="text" name="email" required></div>
                    <div class="small-2 columns"></div>
                </div>     
                    
                <div class="row">
                    <div class="small-6 columns">   
                        <p align="right"><font size=+2>Teléfono:</font></p></div>
                    <div class="small-3 large-4 columns">
                        <input type="text" name="telefono" required></div>
                    <div class="small-2 columns"></div>
                </div>     
                    
                    
                <div class="row">
                    <div class="small-6 columns">  
                        <p align="right"><font size=+2>Nombre de usuario:</font></p></div>
                    <div class="small-3 large-4 columns">
                        <input type="text" name="usuario" required></div>
                    <div class="small-2 columns"></div>
                </div>     
            
                <div class="row">
                    <div class="small-6 columns">     
                        <p align="right"><font size=+2>Password:</font></p></div>
                    <div class="small-3 large-4 columns">
                        <input id="pass1" type="password" name="password1" required></div>
                        <div class="small-2 columns"></div>
                </div>     
                    
                <div class="row">
                    <div class="small-6 columns"> 
                        <p align="right"><font size=+2 >Confirmar password:</font></p></div>
                    <div class="small-3 large-4 columns">
                        <input id="pass2" type="password" name="password2" required></div>
                        <div class="small-2 columns"></div>
                </div>     
                    
                <div class="row"> 
                    <div class="small-12 columns"><center><button type="submit">Registrar</button></center>
                    </div>
                </div>    
                
                <div>
                    <center class="nuevito">
                            <a href="login.jsp"><font face="Verdana" size=+2>Ya estoy registrado</font></a>
                    </center>
                </div>
                
            </form>
        </div>
        </center>
        <script type="text/javascript">
            $("#pass2").focusout(function(){
                var pass1 = $("#pass1").val();
                var pass2 = $("#pass2").val();
                console.log(pass1 + " " + pass2);
                if(pass1 !== pass2){
                    alert("Las contraseñas deben ser iguales");
                }          
            });
            
        </script>
        <c:if test="${mensaje!=null}">
        <script type="text/javascript">
            alert("${mensaje}");
        </script>
        <c:remove var="mensaje" scope="session"/>
    </c:if>
    </body>
    
</html>
