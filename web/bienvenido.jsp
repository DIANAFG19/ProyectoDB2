<%-- 
    Document   : bienvenido
    Created on : 19/07/2017, 08:19:29 PM
    Author     : YOO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <script src="js/jquery.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="jumbotron text-center">
  <h1>Bienvenido al Proyecto Almacén</h1>
  <p>Flores García Diana Laura</p> 
</div>
        <h2>Almacén</h2>
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#guardar">Guardar Almacén</a></li>
    <li><a data-toggle="tab" href="#buscartodos">Mostrar Todos los Almacenes</a></li>
    <li><a data-toggle="tab" href="#buscarid">Buscar un Almacén</a></li>
    <li><a data-toggle="tab" href="#actualizar">Actualizar Almacén</a></li>
    <li><a data-toggle="tab" href="#eliminar">Eliminar Almacén</a></li>
  </ul>
  <div class="tab-content">
    <div id="guardar" class="tab-pane fade in active">
      <h3>Guardar Almacén</h3>
      <input type="text" id="id" placeholder="introduce el id">
        <br>
        <input type="text" id="ubicacion" placeholder="intrdouce ubicacion">
        <button id="guardar">Guardar almacen</button>
        <div class="container">
          </div>
    <div id="buscartodos" class="tab-pane fade">
      <h3>Buscar Todos</h3>
      <div class="container">
  <h2>Basic Table</h2>
  <p>The .table class adds basic styling (light padding and only horizontal dividers) to a table:</p>            
  <table class="table">
    <thead>
      <tr>
        <th>Id de Almacén</th>
        <th>Ubicacion de almacen</th>       
      </tr>
    </thead>
    <tbody id="cuerpo">
    </tbody>
  </table>
</div>
    </div>
    <div id="buscarid" class="tab-pane fade">
      <h3>Buscar por ID</h3>
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
    </div>
    <div id="actualizar" class="tab-pane fade">
      <h3>Actualizar Almacén</h3>
      <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
    </div>
         <div id="eliminar" class="tab-pane fade">
      <h3>Eliminar Almacén</h3>
      <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
    </div>
  </div>
</div>

        <script>
           // console.log("Hola mundo");
          //Vamos a programar el boton
          $($buscartodos).click(function ){
          $.ajax({
                url:'buscar-almacenes',
                type:'get',
                success:function(json){//json es un nombre, no importa el que pongas
                    //for(var i=0;i<json.length;i++){
                        $("$cuerpo").append("<tr><td>algo</td><td>otra cosa</td></tr>");  
                    //}
                }

            });
        }
          
          $("#guardar").click(function(){
        //La logica va aqui
          $.ajax({
            url:'guardar-almacen',
            type:'post',
            data:{
                id:$("#id").val(),
                ubicacion:$("#ubicacion").val()
            },
            success: function(datos){
                alert(datos)        
                    }
             });
         }
        </script>
    </body>
</html>