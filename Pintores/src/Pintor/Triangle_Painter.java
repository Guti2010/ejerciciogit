package Pintor;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle_Painter extends Artist  {
	private int sideLength;
	private int x;
	private int y;
	private Color color; 

    public Triangle_Painter() {}
    
    public void setParameters(int pMinSize, int pMaxSize, int pX, int pY, Color pColor) {
    	this.x = pX;
    	this.y = pY;
    	this.sideLength = pMaxSize-pMinSize;
    	this.color = pColor;
    }

    @Override
	 public void draw(Graphics g) {
		 g.setColor(color);
	     int[] xPoints = {x, x + sideLength, x - sideLength};
	     int[] yPoints = {y - sideLength, y + sideLength, y + sideLength};
	     g.fillPolygon(xPoints, yPoints, 3);
	 }

}
