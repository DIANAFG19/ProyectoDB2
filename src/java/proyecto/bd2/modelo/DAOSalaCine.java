/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bd2.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import proyecto.bd2.modelo.SalaCine;

/**
 *
 * @author campitos
 */
public class DAOSalaCine {
    
    
    public static  int guardar(SalaCine sp)throws Exception{
         
        Connection con=Conexion.conectarse();
        
        CallableStatement callate=con.prepareCall("{call guardar_sala_cine(?,?)}");
        callate.registerOutParameter(1,java.sql.Types.INTEGER);
        callate.setString(2,sp.getPelicula());

        callate.execute();
        int pk=callate.getInt(1);
        System.out.println("El id generado es:"+pk);
        con.close();
        return pk;
    }
}
