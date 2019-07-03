/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.bd2.modelo;

/**
 *
 * @author campitos
 */

import java.sql.*;
public class Conexion {
    
    public static boolean autenticado = false;
    
    public static Connection conectarse()throws Exception{
        String url="jdbc:oracle:thin:@localhost:1521:xe";
       Class.forName("oracle.jdbc.OracleDriver");
       Connection con=DriverManager.getConnection(url,"system","system");
       return con;
    }
    public static Connection autenticarse(String login, String password)throws Exception{
        String url="jdbc:oracle:thin:@localhost:1521:xe";
       Class.forName("oracle.jdbc.OracleDriver");
       Connection con=DriverManager.getConnection(url,login,password);
       autenticado = true;
       return con;
    }
}
