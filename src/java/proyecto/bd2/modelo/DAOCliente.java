/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bd2.modelo;
import java.sql.*;
import java.util.*;
/**
 * @author YOO
 */
public class DAOCliente {
    //Primera Operacion
    public static void guardar(Cliente cliente)throws Exception{
        Connection con = Conexion.conectarse();
        try{
            CallableStatement callate = con.prepareCall("{call guardar_cliente(?,?)}");
            callate.setInt(1, cliente.getNumero());
            callate.setInt(2, cliente.getNumeroAlmacen());
            callate.setString(3,cliente.getNombre());
            callate.execute();
            callate.close();
        }catch(Exception e){
           
        }
        finally{
           con.close();
        }
    }
  
  //Actualizar
    public static void actualizar(Cliente cliente) throws SQLException{
        Connection con = null;
        CallableStatement callate = null;
        try{
            con = Conexion.conectarse();
            callate = con.prepareCall("{call ACTUALIZAR_CLIENTE(?,?,?)}");
            System.out.println("numero de cliente " + cliente.getNumero());
            System.out.println("numero de almacen " + cliente.getNumeroAlmacen());
            System.out.println("nombre de cliente " + cliente.getNombre());
            callate.setInt(1, cliente.getNumero());
            callate.setInt(2, cliente.getNumeroAlmacen());
            callate.setString(3, cliente.getNombre());
            callate.executeUpdate();
            
            System.out.println("Se actualizó el cliente");
        
        }catch(Exception e){
            System.out.println("La excepcion es "+e.getMessage());
        }
        finally{
            con.close();
            callate.close();
        }
    }
    
    //Obtener todos
    public static ArrayList<Cliente> obtenerTodos()throws Exception{
        Connection con = Conexion.conectarse(); 
        Statement st = con.createStatement();
        ArrayList<Cliente> clientes = new ArrayList<>();
        try{
            ResultSet res=st.executeQuery("SELECT * FROM CLIENTE");
            while(res.next()){
                Integer numeroCliente = res.getInt(1);
                Integer numeroAlmacen = res.getInt(2);
                String nombreCliente = res.getString(3);
                Cliente cliente = new Cliente(numeroCliente, numeroAlmacen, nombreCliente);
                clientes.add(cliente);
            }
        }catch(Exception e){
        
        }finally{
            st.close();
            con.close();  
        }
    return clientes;
    }
  
    //Obtener pór id
    public static Cliente obtenerporId(Integer id)throws Exception{
        Cliente cliente = new Cliente();
        Connection con = Conexion.conectarse();
        try{
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM CLIENTE WHERE NUMERO_CLIENTE = " + id);
            while(res.next()){
                Integer numeroCliente = res.getInt(1);
                Integer numeroAlmacen = res.getInt(2);
                String nombreCliente = res.getString(3);
                cliente.setNumero(numeroCliente);
                cliente.setNumeroAlmacen(numeroAlmacen);
                cliente.setNombre(nombreCliente);
            }
        }catch(Exception e){
                 
        }finally{
            con.close();
        }
    return cliente;
    }
  
    //Eliminar
    public static void eliminar(Integer id)throws Exception{
        Connection con = null;
        CallableStatement callate = null;
        try{
            con = Conexion.conectarse();
            callate = con.prepareCall("{call ELIMINAR_CLIENTE(?)}");
            callate.execute();
            System.out.println("Se elimino el cliente");
        }catch(Exception e){
            System.out.println("La excepcion es " + e.getMessage());
        }
        finally{
            con.close();
            callate.close();
        }
    } 
}
