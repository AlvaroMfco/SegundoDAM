package es.studium.dibujoSwing; 

import javax.swing.JFrame; 

public class DibujoSwing extends JFrame  
{ 
	private static final long serialVersionUID = 1L; 

	public DibujoSwing()  
	{ 
		setTitle("Ejemplo de dibujo"); 
		add(new MiPanel());
		setSize(250, 100); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setVisible(true); 
	} 
	public static void main(String[] args)  
	{ 
		new DibujoSwing(); 
	} 
} 