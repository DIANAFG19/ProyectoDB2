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
import proyecto.bd2.modelo.DAOVentas;
import proyecto.bd2.modelo.Ventas;

/**
 *
 * @author YOO
 */
public class ServletGuardarVenta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Integer numeroCliente = Integer.parseInt(request.getParameter("numeroCliente"));
            Integer numeroVendedor = Integer.parseInt(request.getParameter("numeroVendedor"));
            Float monto = Float.parseFloat(request.getParameter("monto"));
            Ventas v = new Ventas(id, numeroCliente, numeroVendedor, monto);
            try {
                DAOVentas.guardar(v);
                out.println("Venta guardada con exito");
            }catch (Exception ex) {
                out.println("Hubo un error " + ex.getMessage());
            }
        }
    }
}
