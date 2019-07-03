/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto.bd2.modelo.DAOVendedor;
import proyecto.bd2.modelo.Vendedor;

/**
 *
 * @author YOO
 */
public class ServletGuardarVendedor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        //Vamos a recibir los parametros para guardar un Almacen
        Integer id = Integer.parseInt(request.getParameter("id"));
        String ubicacion = request.getParameter("ubicacion");
        String area = request.getParameter("area");
        //Generamos un objeto de tipo Almacen
        Vendedor v = new Vendedor(id, ubicacion, area);
        try {
            //Generamos el DAOAlmacen para guardar
            DAOVendedor.guardar(v);
            out.println("Vendedor guardado con exito");
        }catch (Exception ex) {
            out.println("Hubo un error " + ex.getMessage());
        }
    }
}