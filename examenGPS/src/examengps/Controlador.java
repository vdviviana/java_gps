/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examengps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author vdviviana
 */
public class Controlador {
    private Modelo modelo;
    private Vista vista;
    
    public Controlador(Modelo modelo, Vista vista){
        this.modelo = modelo;
        this.vista = vista;
    }
    
    //METODO QUE EJECUTA LA CADENA DE VALORES
    public void ejecutarControladorVistaModelo(){
        try{
        //modelo.buscaSiExisteEsquina();
        //vista.mostrarGetArrayResultado(modelo.getArrayResultados());
        vista.mostrarInterfazUsuario();
        // ESCUCHA SI SE PRESIONA BOTON CALCULAR
        vista.addBotonCalcularListener(new BotonListener());
        }catch(Exception ex){
        System.out.println("Error: " + ex);
        }
    }
    
    // CLASE QUE DELCARA ESCUCHADORES
    private class BotonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            modelo.buscaSiExisteEsquina(vista.getjtextfield_primera_esquina_calle1(), vista.getjtextfield_primera_esquina_calle2(), vista.getjtextfield_segunda_esquina_calle1(), vista.getjtextfield_segunda_esquina_calle2());
            //vista.mostrarGetArrayResultado(modelo.getArrayResultados());
            
            }catch(Exception ex){
                System.out.println("Error: " + ex);
            }
            //vista.mostrarValoresJtextfield();
             vista.mostrarTextFieldResultado(modelo.getIntentos());
        }
    }
}
