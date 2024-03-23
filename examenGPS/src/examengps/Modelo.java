/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examengps;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author vdviviana
 */
public class Modelo {
    private Connection connection;
    private ActionListener listener;
    private ArrayList<String> arrayResultados;
    private ArrayList<String> arrayResultados_2docruce;
    int intentos;

    
    public Modelo() {
        arrayResultados = new ArrayList<>();
        arrayResultados_2docruce= new ArrayList<>();
    }
    // INICIA OBTENER CONEXIÓN A BASE DE DATOS
    private Connection obtenerConexion() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/gps", "root", "");
                } catch (SQLException ex) {
                    Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                reportException(ex.getMessage());

            }
        }
        return connection;
    }

    private void reportException(String message) {
        if (listener != null) {
            ActionEvent evt = new ActionEvent(this, 0, message);
            listener.actionPerformed(evt);
        }
    }
    // FIN OBTENER CONEXIÓN A BASE DE DATOS
    
    // CONSULTA A BASE DE DATOS
     public void buscaSiExisteEsquina(String pecalle1, String pecalle2, String secalle1, String secalle2) throws SQLException {
         String resultado = "";
         arrayResultados= new ArrayList<>();
         int cruces =0;
         boolean encontrado = false;
         intentos =0;
         try {      
             connection = obtenerConexion();
             Statement statement = connection.createStatement();
             ResultSet resulSet;
             System.out.println("--- INICIO ---" );             
             while(!encontrado){
                 if(intentos==0){ // 1ER INTENTO: ALMACENA EN ARRAYRESULTADOS
                     intentos ++;
                     System.out.println("Intento: " + intentos);
                    //AQUI VA MI CONSULTA A LA BASE DE DATOS
                    String query = "SELECT * FROM `sentido` WHERE desde = '"+ pecalle1 + " y " + pecalle2 + 
                            "' OR desde = '" + pecalle2 + " y "+ pecalle1 +"'";
                    resulSet = statement.executeQuery(query);        
                    while (resulSet.next()) {          
                       
                            resultado = resulSet.getString("hasta");
                            if(resultado.equals(secalle1 + " y " + secalle2) || resultado.equals(secalle2 + " y " + secalle1) ){
                                 encontrado=true;
                                System.out.println("Cruce: " + intentos + ". Esquina encontrada exacta: " + resultado);
                                break;
                            }else{
                                arrayResultados.add(resultado);
                                System.out.println("Cruce: " + intentos + ", esquinas: " + resultado);
                                }
                    } // termina while
                    
            
                 }else{ // 2DO INTNETO: RECORRE ARRAYRESULTADOS
                        String resultado_2docruce = "";
                        String nuevo_desde1 ="";
                        String nuevo_desde2="";
                        arrayResultados_2docruce= new ArrayList<>();
                        
                        while(arrayResultados_2docruce.size()==0 && !encontrado){
                            intentos ++;
                            System.out.println("Intento: " + intentos);
                            
                            //CON FOR RECORRO ARRAYRESULTADOS
                            for(int posicion=0; posicion < arrayResultados.size(); posicion ++){
                                String completo = arrayResultados.get(posicion);
                                nuevo_desde1 = completo.substring(0, completo.indexOf(" y "));
                                nuevo_desde2 = completo.substring(completo.indexOf(" y ")+ 3);                                
                           
                            //NUEVA CONSULTA A BASE DE DATOS
                            String query_2docruce = "SELECT * FROM `sentido` WHERE desde = '"+ nuevo_desde1 + " y " + nuevo_desde2 + 
                            "' OR desde = '" + nuevo_desde2 + " y "+ nuevo_desde1 +"'";
                            resulSet = statement.executeQuery(query_2docruce); 
                            while (resulSet.next()) {          
                                resultado_2docruce = resulSet.getString("hasta");
                                if(resultado_2docruce.equals(secalle1 + " y " + secalle2) || resultado_2docruce.equals(secalle2 + " y " + secalle1) ){
                                 encontrado=true;
                                 System.out.println("Cruce: " + intentos + ". Esquina encontrada exacta: " + resultado_2docruce);
                                 break;
                                }else{
                                    arrayResultados_2docruce.add(resultado_2docruce);
                                    System.out.println("Cruce: " + intentos + ", esquinas: " + resultado_2docruce);
                                }
                            } // termina while
                            }// TERMINA FOR
                        } // TERMINA WHILE
                        
                        // MUY IMPORTANTE TRASPASAR LA LISTA NUEVA HACIA LA LISTA VIEJA, CADA VEZ QUE REINICIE EL WHILE MAS GRANDE
                        arrayResultados = new ArrayList<>();
                        arrayResultados = arrayResultados_2docruce;
                 }
             }
             //resulSet.close();
             statement.close();
             System.out.println("--- FIN ---" );
         } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

     }
     
     public String getIntentos() {
        return String.valueOf(intentos);
    }
     //RETORNA RESULTADOS OBTENIDOS DE LA BASE DE DATOS
     public ArrayList getArrayResultados(){
         return arrayResultados;
     }
}
