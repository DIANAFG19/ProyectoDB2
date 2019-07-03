/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bd2.modelo;
import java.sql.*;
import java.util.*;
/**
 *
 * @author YOO
 */
public class DAOVendedor {
    //Primera Operacion
    public static void guardar(Vendedor vendedor)throws Exception{
        Connection con = Conexion.conectarse();
        try{
            CallableStatement callate = con.prepareCall("{call guardar_vendedor(?,?)}");
            callate.setInt(1, vendedor.getNumero());
            callate.setString(2,vendedor.getNombre());
            callate.setString(2,vendedor.getArea());
            callate.execute();
            //  int pk=callate.getInt(1);
            callate.close();
        }catch(Exception e){
           
        }
        finally{
           con.close();
        }
    }
  
  //Actualizar
    public static void actualizar(Vendedor vendedor) throws SQLException{
        Connection con = null;
        CallableStatement callate = null;
        try{
            con = Conexion.conectarse();
            callate = con.prepareCall("{call ACTUALIZAR_VENDEDOR(?,?,?)}");
            System.out.println("numero de vendedor " + vendedor.getNumero());
            System.out.println("nombre de vendedor " + vendedor.getNombre());
            System.out.println("area de ventas " + vendedor.getArea());
            callate.setInt(1, vendedor.getNumero());
            callate.setString(2, vendedor.getNombre());
            callate.setString(3, vendedor.getArea());
            callate.executeUpdate();
            
            System.out.println("Se actualizó el vendedor");
        
        }catch(Exception e){
            System.out.println("La excepcion es "+e.getMessage());
        }
        finally{
            con.close();
            callate.close();
        }
    }
    
    //Obtener todos
    public static ArrayList<Vendedor> obtenerTodos()throws Exception{
        Connection con = Conexion.conectarse(); 
        Statement st = con.createStatement();
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        try{
            ResultSet res=st.executeQuery("SELECT * FROM VENDEDOR");
            while(res.next()){
                Integer numeroVendedor = res.getInt(1);
                String nombreVendedor = res.getString(2);
                String areaVendedor = res.getString(3);
                Vendedor vendedor = new Vendedor(numeroVendedor, nombreVendedor, areaVendedor);
                vendedores.add(vendedor);
            }
        }catch(Exception e){
        
        }finally{
            st.close();
            con.close();  
        }
    return vendedores;
    }
  
    //Obtener pór id
    public static Vendedor obtenerporId(Integer id)throws Exception{
        Vendedor vendedor = new Vendedor();
        Connection con = Conexion.conectarse();
        try{
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM VENDEDOR WHERE NUMERO_VENDEDOR = " + id);
            while(res.next()){
                Integer numeroVendedor = res.getInt(1);
                String nombreVendedor = res.getString(2);
                String areaVendedor = res.getString(3);
                vendedor.setNumero(numeroVendedor);
                vendedor.setNombre(nombreVendedor);
                vendedor.setArea(areaVendedor);
            }
        }catch(Exception e){
                 
        }finally{
            con.close();
        }
    return vendedor;
    }
  
    //Eliminar
    public static void eliminar(Integer id)throws Exception{
        Connection con = null;
        CallableStatement callate = null;
        try{
            con = Conexion.conectarse();
            callate = con.prepareCall("{call ELIMINAR_VENDEDOR(?)}");
            callate.execute();
            System.out.println("Se elimino el vendedor");
        }catch(Exception e){
            System.out.println("La excepcion es " + e.getMessage());
        }
        finally{
            con.close();
            callate.close();
        }
    }
}
