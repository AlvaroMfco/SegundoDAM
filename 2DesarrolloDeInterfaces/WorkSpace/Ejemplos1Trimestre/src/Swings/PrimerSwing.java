package Swings; 
import javax.swing.JFrame; 


public class PrimerSwing 
{ 
	// Constructor 
	public PrimerSwing() 
	{ 
		JFrame ventanaJ = new JFrame("Ejemplo 1"); 
		ventanaJ.setSize(200,100); 
		ventanaJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		ventanaJ.setVisible(true); 
	} 
	public static void main(String args[]) 
	{ 
		new PrimerSwing(); 
	} 
}