package Swings; 
 
import javax.swing.JButton; 
import javax.swing.JFrame; 
 
public class PrimerSwingComponentes 
{ 
 // Constantes y componentes (objetos) 
 JButton miBoton; 
 // Constructor 
 public PrimerSwingComponentes() 
 { 
  JFrame ventanaJ = new JFrame("Ejemplo 2"); 
  miBoton = new JButton("Aceptar"); 
  ventanaJ.add(miBoton); 
  ventanaJ.setSize(200,100); 
  ventanaJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
  ventanaJ.setVisible(true); 
 } 
 public static void main(String args[]) 
 { 
  new PrimerSwingComponentes(); 
 } 
} 