/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
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
public class ServletBuscarIdVendedor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             Integer id = Integer.parseInt(request.getParameter("id"));
            try {
                Vendedor v = new Vendedor();
                v = DAOVendedor.obtenerporId(id);
                out.println(v);
            }catch (Exception ex) {
                out.println("Hubo un error " + ex.getMessage());
            }
        }
    }
}
