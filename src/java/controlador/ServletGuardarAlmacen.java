    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto.bd2.modelo.Almacen;
import proyecto.bd2.modelo.DAOAlmacen;

/**
 *
 * @author campitos
 */
public class ServletGuardarAlmacen extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Vamos a recibir los parametros para guardar un Almacen
        Integer id = Integer.parseInt(request.getParameter("id"));
        String ubicacion = request.getParameter("ubicacion");
        //Generamos un objeto de tipo Almacen
         Almacen a = new Almacen(id, ubicacion);
            try {
                //Generamos el DAOAlmacen para guardar
                DAOAlmacen.guardar(a);
                out.println("Almacen guardado con exito");
            }catch (Exception ex) {
                out.println("Hubo un error "+ex.getMessage());
            }
        }
    }
}
