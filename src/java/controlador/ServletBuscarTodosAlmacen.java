/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto.bd2.modelo.Almacen;
import proyecto.bd2.modelo.DAOAlmacen;


public class ServletBuscarTodosAlmacen extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("application/gson");
            try (PrintWriter out = response.getWriter()) {
            //En este caso no recibimos parametos de parte del cliente
            //Generamos el DAOALmacen y su metodo buscarTodos
                try{ 
                    ArrayList<Almacen> almacenes = DAOAlmacen.obtenerTodos();
                    //Creamos un obejto de la recien cargada biblioteca GSON
                    Gson convertidor=new Gson();
                    String json = convertidor.toJson(almacenes);
                    out.println(json);
                }catch(Exception e){
                    out.println("Algo malo sucedio "+e.getMessage());
           }   
        }
    }
}

        