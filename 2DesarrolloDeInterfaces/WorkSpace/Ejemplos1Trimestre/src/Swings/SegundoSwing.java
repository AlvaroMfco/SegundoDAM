package Swings; 

import java.awt.FlowLayout; 
import javax.swing.JButton; 
import javax.swing.JFrame; 

public class SegundoSwing 
{ 
	public SegundoSwing() 
	{ 
		JFrame ventanaJ = new JFrame("Ejemplo 2"); 
		ventanaJ.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20)); 
		for(int i=0;i<10;i++) 
		{ 
			ventanaJ.add(new JButton("Componente "+ (i+1))); 
		} 
		ventanaJ.setSize(400,300); 
		ventanaJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ventanaJ.setVisible(true); 
	} 
	public static void main(String args[]) 
	{ 
		new SegundoSwing(); 
	} 
}