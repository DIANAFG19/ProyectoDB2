/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bd2.modelo;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author campitos
 */
public class DAOAlmacen {
    
    
    //Primera Operacion
  public static void guardar(Almacen almacen)throws Exception{
       Connection con=Conexion.conectarse();
       try{
            CallableStatement callate = con.prepareCall("{call guardar_almacen(?,?)}");
            callate.setInt(1, almacen.getNumeroAlmacen());
            callate.setString(2,almacen.getUbicacionAlmacen());
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
    //Primera Operacion
  public static void actualizar(Almacen almacen) throws SQLException{
      Connection con=null;
      CallableStatement callate=null;
      try{
       con=Conexion.conectarse();
        
         callate=con.prepareCall("{call ACTUALIZAR_ALMACEN(?,?)}");
        System.out.println("numeeo almacen "+almacen.getNumeroAlmacen());
         System.out.println("nombe almacen "+almacen.getUbicacionAlmacen());
        callate.setInt(1, almacen.getNumeroAlmacen());
        callate.setString(2,almacen.getUbicacionAlmacen());

        callate.executeUpdate();
        
      //  int pk=callate.getInt(1);
        System.out.println("Se actualizó el almacen");
        
      }catch(Exception e){
          System.out.println("La excepcion es "+e.getMessage());
      }
      finally{
          con.close();
          callate.close();
      }
       
  }
  
  //Obtener todos
  public static ArrayList<Almacen> obtenerTodos()throws Exception{
    Connection con=  Conexion.conectarse(); 
    Statement st= con.createStatement();
     ArrayList<Almacen> almacenes=new ArrayList<>();
    try{
             
  
 ResultSet res=st.executeQuery("SELECT * FROM ALMACEN");
 while(res.next()){
   Integer numeroAlmacen=  res.getInt(1);
   String nombreAlmacen=res.getString(2);
    Almacen almacen=new Almacen(numeroAlmacen, nombreAlmacen);
   almacenes.add(almacen);
   
     }
 
    }catch(Exception e){
        
    }finally{
        st.close();
      con.close();  
    }
 
 return almacenes;
  }
  
  
  //Obtener pór id
  public static Almacen obtenerporId(Integer id)throws Exception{
     Almacen almacen=new Almacen();
      Connection con=  Conexion.conectarse();
            
             try{
                 
             
             
   Statement st= con.createStatement();
 ResultSet res=st.executeQuery("SELECT * FROM ALMACEN WHERE NUMERO_ALMACEN="+id);
 while(res.next()){
   Integer numeroAlmacen=  res.getInt(1);
   String nombreAlmacen=res.getString(2);
   almacen.setNumeroAlmacen(numeroAlmacen);
   almacen.setUbicacionAlmacen(nombreAlmacen);

   
     }
             }catch(Exception e){
                 
             }finally{
                  con.close();
             }

 return almacen;
  }
  
  //Eliminar

    public static Almacen eliminar(Integer id)throws Exception{
        Almacen almacen = new Almacen();
        Connection con = Conexion.conectarse();
        try{
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("DELETE FROM ALMACEN WHERE NUMERO_ALMACEN="+id);
            while(res.next()){
                Integer numeroAlmacen = res.getInt(1);
                String nombreAlmacen = res.getString(2);
                almacen.setNumeroAlmacen(numeroAlmacen);
                almacen.setUbicacionAlmacen(nombreAlmacen);
            }
        }catch(Exception e){
      
        }finally{
            con.close();
        }
        return almacen;
    }
}
