<%-- 
    Document   : index
    Created on : 15/07/2017, 09:29:38 AM
    Author     : YOO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <div class="jumbotron text-center">
  <h1>Proyecto Datacentrico con ORACLE</h1>
  <p>Flores García Diana Laura</p> 
</div>
  
<div class="container">
  <h2> Ingresa tu Login y Password </h2>
            <form action = "autenticar" method="post">
            <input type="text" name = "login" placeholder="login">
            <input type="password" name = "password" placeholder="password">
            <input type="submit" value="ACEPTAR" class="btn btn-success">
            </form>
    </div>
    </head>
    <body>
        
        <%
            /*Este es un scripble y aceptra codigo JAVA
            float x = 5.2f;
            float y = 8.2f;
            float suma = x + y;
            out.println("La suma es: " + suma);*/
            %>
        
    </body>
</html>
