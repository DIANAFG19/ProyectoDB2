/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bd2.modelo;

/**
 *
 * @author T-
 */
public class ProbarTodo {
    
    public static void main(String[] args) {
        //Vamos aprobar nuestro DAO Almacen
        //Primero creamos el lamacen que necesita guardar el DAO
        Almacen a = new Almacen(5,"Ecatepec");
        //Creamos el objeto DAO Almacen
        DAOAlmacen dao = new DAOAlmacen();
        //Le enviamos el mensaje que gusrade alamcen 
        try{
        dao.guardar(a);
        System.out.println("Se guardo con el cliente");
        }catch(Exception e){
            System.out.println("Hubo error" + e.getMessage());
        }
    }
    
}
