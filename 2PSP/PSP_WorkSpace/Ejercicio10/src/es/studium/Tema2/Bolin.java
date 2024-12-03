package es.studium.Tema2; 

import java.awt.Color; 
import java.awt.Graphics; 
import java.awt.Graphics2D;
import java.awt.Rectangle; 

public class Bolin { 
	int velocidad = 4;
	private int x, y; 
	private Color color; 
	public Bolin(int xx, int yy, Color c) 
	{ 
		this.x = xx; 
		this.y = yy; 
		this.color = c; 
	} 
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public void setColor(Color c) {
	    this.color = c;
	}

	public void mover(int direccion) 
	{ 
		switch(direccion) 
		{ 
		case 0: 
			if(x<450) 
				x+= velocidad; 
			break; 
		case 1: 
			if(y<550) 
				y+= velocidad; 
			break; 
		case 2: 
			if(x>0) 
				x-= velocidad; 
			break; 
		case 3: 
			if(y>0) 
				y-= velocidad; 
			break; 
		} 
	} 
	
	public Rectangle getCollisionArea() {
		return new Rectangle(x, y, 25, 25);
    }
	
	public void pinta(Graphics g) 
	{ 
		Graphics2D g2d = (Graphics2D)g; 
		g2d.setColor(color); 
		g2d.fillOval(x, y, 25, 25); 
	} 
}