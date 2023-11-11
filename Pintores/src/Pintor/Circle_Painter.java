package Pintor;

import java.awt.Color;
import java.awt.Graphics;

public class Circle_Painter extends Artist {
	private int radius;
	private int x;
	private int y;
	private Color color;

    public Circle_Painter() {}
    
    public void setParameters(int pMinSize, int pMaxSize, int pX, int pY, Color pColor) {
    	this.x = pX;
    	this.y = pY;
    	this.radius = pMaxSize-pMinSize;
    	this.color = pColor;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

}
