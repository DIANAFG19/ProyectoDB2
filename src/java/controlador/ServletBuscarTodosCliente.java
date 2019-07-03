/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import proyecto.bd2.modelo.Cliente;
import proyecto.bd2.modelo.DAOCliente;


/**
 *
 * @author YOO
 */
public class ServletBuscarTodosCliente extends HttpServlet {

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
            try{ 
                ArrayList<Cliente> clientes = DAOCliente.obtenerTodos();
                Gson convertidor = new Gson();
                String json = convertidor.toJson(clientes);
                out.println(json);
            }catch(Exception e){
                out.println("Algo malo sucedio " + e.getMessage());
            }   
        }
    }
}
