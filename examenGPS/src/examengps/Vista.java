/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examengps;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author vdviviana
 */
public class Vista {
    private JFrame jframe; // CONTENEDOR PRINCIPAL
    private JPanel jpanel0; // CONTENEDOR INTERIOR
    private JPanel jpanel1; // CONTENEDOR INTERIOR
    private JPanel jpanel2; // "Primera esquina: "
    private JPanel jpanel3; // "Calle 1 y CUADRO DE TEXTO"
    private JPanel jpanel4; // "Calle 2 y CUADRO DE TEXTO"
    private JPanel jpanel5; // "Segunda esquina: "
    private JPanel jpanel6; // "Calle 1 y CUADRO DE TEXTO"
    private JPanel jpanel7; // "Calle 2 y CUADRO DE TEXTO"
    private JPanel jpanel8; // "Calcular"
    private JPanel jpanel9; // "Cantidad de cruces de calles CUADRO DE TEXTO" 
    
    private JLabel jlabel_titulo_principal; // "Contador de cruces de calles"
    private JLabel jlabel_subtitulo1; // "Primera esquina: "
    private JLabel jlabel_primera_esquina_calle1; // "Calle 1:"
    private JTextField jtextfield_primera_esquina_calle1; // CUADRO DE TEXTO
    private JLabel jlabel_primera_esquina_calle2; // "Calle 2:"
    private JTextField jtextfield_primera_esquina_calle2; // CUADRO DE TEXTO
    
    private JLabel jlabel_subtitulo2; // "Segunda esquina: "
    private JLabel jlabel_segunda_esquina_calle1; // "Calle 1:"
    private JTextField jtextfield_segunda_esquina_calle1; // CUADRO DE TEXTO
    private JLabel jlabel_segunda_esquina_calle2; // "Calle 2:"
    private JTextField jtextfield_segunda_esquina_calle2; // CUADRO DE TEXTO
    
    private JButton jbutton_boton_calcular; // "Calcular"
    private JLabel jlabel_resultado_cantidad_cruces; // "Cantidad de cruces de calles:"
    private JTextField jtextfield_total_cruces;  // CUADRO DE TEXTO
    
    public Vista() {
        jframe = new JFrame();
        jpanel0 = new JPanel();
        jpanel1 = new JPanel();
        jpanel2 = new JPanel(); // "Primera esquina: "
        jpanel3 = new JPanel(); // "Calle 1 y CUADRO DE TEXTO"
        jpanel4 = new JPanel(); // "Calle 2 y CUADRO DE TEXTO"
        jpanel5 = new JPanel(); // "Segunda esquina: "
        jpanel6 = new JPanel(); // "Calle 1 y CUADRO DE TEXTO"
        jpanel7 = new JPanel(); // "Calle 2 y CUADRO DE TEXTO"
        jpanel8 = new JPanel(); // "Calcular"
        jpanel9 = new JPanel(); // "Cantidad de cruces de calles CUADRO DE TEXTO" 
        
        jlabel_titulo_principal = new JLabel("Contador de cruces de calles");
        jlabel_subtitulo1 = new JLabel("Primera esquina:");
        jlabel_primera_esquina_calle1 = new JLabel("Calle 1:");
        jtextfield_primera_esquina_calle1= new JTextField(16);
        jlabel_primera_esquina_calle2 = new JLabel("Calle 2:");
        jtextfield_primera_esquina_calle2= new JTextField(16);
        
        jlabel_subtitulo2 = new JLabel("Segunda esquina:"); // "Segunda esquina: "
        jlabel_segunda_esquina_calle1 = new JLabel("Calle 1:");
        jtextfield_segunda_esquina_calle1= new JTextField(16);
        jlabel_segunda_esquina_calle2 = new JLabel("Calle 2:");
        jtextfield_segunda_esquina_calle2= new JTextField(16);
        
        jbutton_boton_calcular  = new JButton("Calcular");
        jlabel_resultado_cantidad_cruces = new JLabel("Cantidad de cruces de calles:");
        jtextfield_total_cruces = new JTextField(5);
        jtextfield_total_cruces.setEditable(false);
        
        //ADJUNTO TODOS LOS EMEMENTOS DENTRO DE JPANEL
        jpanel0.add(jlabel_titulo_principal);
        jpanel2.add(jlabel_subtitulo1);
        jpanel3.add(jlabel_primera_esquina_calle1);
        jpanel3.add(jtextfield_primera_esquina_calle1);
        jpanel4.add(jlabel_primera_esquina_calle2);
        jpanel4.add(jtextfield_primera_esquina_calle2);
        
        jpanel5.add(jlabel_subtitulo2);
        jpanel6.add(jlabel_segunda_esquina_calle1);
        jpanel6.add(jtextfield_segunda_esquina_calle1);
        jpanel7.add(jlabel_segunda_esquina_calle2);
        jpanel7.add(jtextfield_segunda_esquina_calle2);
        
        jpanel8.add(jbutton_boton_calcular);
        jpanel9.add(jlabel_resultado_cantidad_cruces);
        jpanel9.add(jtextfield_total_cruces);
        
        //COLOR
         //jpanel1.setBackground(Color.blue);
         
        //ADJUNTO JPANEL DENTRO DE JFRAME
        jpanel0.add(jpanel1);
        jpanel0.add(jpanel2);
        jpanel0.add(jpanel3);
        jpanel0.add(jpanel4);
        jpanel0.add(jpanel5);
        jpanel0.add(jpanel6);
        jpanel0.add(jpanel7);
        jpanel0.add(jpanel8);
        jpanel0.add(jpanel9);
        
        jframe.getContentPane().add(jpanel0);
    }
    
    public void mostrarGetArrayResultado(ArrayList<String> list){
        for(String esquina: list){
            //System.out.println("Esquina: " + esquina);
        }
    }
    
    // MOSTRAR JFRAME CUADRO EN PANTALLA
    public void mostrarInterfazUsuario(){
        
        jframe.setTitle("Contador de cruces de calles");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(310, 360);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);
        //jframe.setBackground(Color.yellow);
        jframe.setVisible(true);
    }
    
    // CAPTURA VALOR DEL JTEXTFIELD
    public String getjtextfield_primera_esquina_calle1(){
        return jtextfield_primera_esquina_calle1.getText(); // PRIMERA ESQUINA CALLE 1
    }
    
    public String getjtextfield_primera_esquina_calle2(){
        return jtextfield_primera_esquina_calle2.getText(); // PRIMERA ESQUINA CALLE 2
    }
    
    public String getjtextfield_segunda_esquina_calle1(){
        return jtextfield_segunda_esquina_calle1.getText(); // SEGUNDA ESQUINA CALLE 1
    }
    
    public String getjtextfield_segunda_esquina_calle2(){
        return jtextfield_segunda_esquina_calle2.getText(); // SEGUNDA ESQUINA CALLE 2
    }
    
    // EVENTO DEL BOTON CALCULAR
    public void addBotonCalcularListener(ActionListener actionlistener) {
        jbutton_boton_calcular.addActionListener(actionlistener);
    }
    
    // CARGO LA CANTIDAD DE CRUCES EN LA INTERFAZ DE USUARIO
    void mostrarTextFieldResultado(String intentos) {
            jtextfield_total_cruces.setText(intentos);
    }
    
    // MOSTRAR EN PANTALLA LOS VALORES DE LOS JTEXTFIELD
    public void mostrarValoresJtextfield(){
        System.out.println("Primera esquina: Calle 1 " + getjtextfield_primera_esquina_calle1());
        System.out.println("Primera esquina: Calle 2 " + getjtextfield_primera_esquina_calle2());
        System.out.println(" ");
        System.out.println("Segunda esquina: Calle 1 " + getjtextfield_segunda_esquina_calle1());
        System.out.println("Segunda esquina: Calle 2 " + getjtextfield_segunda_esquina_calle2());
        
    }
        
       
}
