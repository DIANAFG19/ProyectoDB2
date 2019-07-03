/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto.bd2.modelo.Almacen;
import proyecto.bd2.modelo.DAOAlmacen;

/**
 *
 * @author YOO
 */
public class ServletActualizarAlmacen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Vamos a recibir los parametros para guardar un Almacen
        Integer nuevoId = Integer.parseInt(request.getParameter("id"));
        String nuevaUbicacion = request.getParameter("ubicacion");
        //Generamos un objeto de tipo Almacen
         Almacen a = new Almacen(nuevoId, nuevaUbicacion);
         try {
            //Generamos el DAOAlmacen para actualizar
            DAOAlmacen.actualizar(a);
            out.println("Almacen Actualizado con exito");
        }catch (Exception ex) {
            out.println("Hubo un error "+ex.getMessage());
        }
    }
}
