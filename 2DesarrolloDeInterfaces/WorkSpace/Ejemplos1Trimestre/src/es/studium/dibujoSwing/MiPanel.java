package es.studium.dibujoSwing; 
 
import java.awt.Graphics; 
import javax.swing.JPanel; 
 
public class MiPanel extends JPanel  
{ 
 private static final long serialVersionUID = 1L; 
 
 public void paintComponent(Graphics g)  
 { 
  super.paintComponent(g); 
  g.drawString("Interfaz gráfica", 40, 40); 
 } 
}