/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examengps;

/**
 *
 * @author vdviviana
 */
public class ExamenGPS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Modelo modelo =  new Modelo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(modelo, vista);
        
        //LLAMO A FUNCION QUE EJECUTA CADENA DE VALORES
        controlador.ejecutarControladorVistaModelo();
        
        
    }
    
}
