/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bd2.modelo;
import java.util.*;
import java.sql.*;
/**
 *
 * @author YOO
 */
public class DAOVentas {
    //Primera Operacion
    public static void guardar(Ventas ventas)throws Exception{
        Connection con = Conexion.conectarse();
        try{
            CallableStatement callate = con.prepareCall("{call guardar_ventas(?,?,?,?)}");
            callate.setInt(1, ventas.getId());
            callate.setInt(2, ventas.getNumeroCliente());
            callate.setInt(3, ventas.getNumeroVendedor());
            callate.setFloat(4, ventas.getMonto());
            callate.execute();
            callate.close();
        }catch(Exception e){
           
        }
        finally{
           con.close();
        }
    }
  
  //Actualizar
    public static void actualizar(Ventas ventas) throws SQLException{
        Connection con = null;
        CallableStatement callate = null;
        try{
            con = Conexion.conectarse();
            callate = con.prepareCall("{call ACTUALIZAR_VENTAS(?,?,?,?}");
            System.out.println("numero de venta " + ventas.getId());
            System.out.println("numero de cliente " + ventas.getNumeroCliente());
            System.out.println("numero de vendedor " + ventas.getNumeroVendedor());
            System.out.println("monto " + ventas.getMonto());
            callate.setInt(1, ventas.getId());
            callate.setInt(2, ventas.getNumeroCliente());
            callate.setInt(3, ventas.getNumeroVendedor());
            callate.setFloat(4, ventas.getMonto());
            callate.executeUpdate();
            System.out.println("Se actualizó la venta");        
        }catch(Exception e){
            System.out.println("La excepcion es "+e.getMessage());
        }
        finally{
            con.close();
            callate.close();
        }
    }
    
    //Obtener todos
    public static ArrayList<Ventas> obtenerTodos()throws Exception{
        Connection con = Conexion.conectarse(); 
        Statement st = con.createStatement();
        ArrayList<Ventas> ventasTodas = new ArrayList<>();
        try{
            ResultSet res=st.executeQuery("SELECT * FROM VENTAS");
            while(res.next()){
                Integer idVenta = res.getInt(1);
                Integer numeroCliente = res.getInt(2);
                Integer numeroVendedor = res.getInt(3);
                Float montoVenta = res.getFloat(4);
                Ventas ventas = new Ventas(idVenta, numeroCliente, numeroVendedor, montoVenta);
                ventasTodas.add(ventas);
            }
        }catch(Exception e){
        
        }finally{
            st.close();
            con.close();  
        }
    return ventasTodas;
    }
  
    //Obtener pór id
    public static Ventas obtenerporId(Integer id)throws Exception{
        Ventas ventas = new Ventas();
        Connection con = Conexion.conectarse();
        try{
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM VENTAS WHERE ID = " + id);
            while(res.next()){
                Integer idVentas = res.getInt(1);
                Integer numeroCliente = res.getInt(2);
                Integer numeroVendedor = res.getInt(3);
                Float montoVentas = res.getFloat(4);
                ventas.setId(idVentas);
                ventas.setNumeroCliente(numeroCliente);
                ventas.setNumeroVendedor(numeroVendedor);
                ventas.setMonto(montoVentas);
            }
        }catch(Exception e){
                 
        }finally{
            con.close();
        }
    return ventas;
    }
  
    //Eliminar
    public static void eliminar(Integer id)throws Exception{
        Connection con = null;
        CallableStatement callate = null;
        try{
            con = Conexion.conectarse();
            callate = con.prepareCall("{call ELIMINAR_VENTAS(?)}");
            callate.execute();
            System.out.println("Se elimino la venta");
        }catch(Exception e){
            System.out.println("La excepcion es " + e.getMessage());
        }
        finally{
            con.close();
            callate.close();
        }
    } 
}
