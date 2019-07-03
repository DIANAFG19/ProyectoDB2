/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto.bd2.modelo.Conexion;

/**
 * @author YOO
 */
public class ServletAutenticar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Pedimos los valores
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        //Invocamos al modelo
        try{
            Conexion.autenticarse(login, password);
            //Aqui vamos a invocar la pagina correcta
            RequestDispatcher despachador = request.getRequestDispatcher("/bienvenido.jsp");
            despachador.forward(request, response);
        }catch(Exception e){
            //Aqui va,os a invocar la pagina ncorrecta
            RequestDispatcher despachador = request.getRequestDispatcher("/error.jsp");
            despachador.forward(request, response);
        }
    }
}
