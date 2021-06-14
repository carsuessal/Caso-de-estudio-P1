/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casoestudioprogramacion.vista;

import casoestudioprogramacion.controlador.ConexionBD;
import java.sql.Connection;


public class CasoEstudioProgramacion {
  public static void main(String[] args) {
      
    try {
        ConexionBD conexion = new ConexionBD();
        
    }
    catch (Exception e){
        System.out.println("Error al conectar con la base de datos"); 
        
    }
    }
  
  
}

