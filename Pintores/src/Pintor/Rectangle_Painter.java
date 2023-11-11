package Pintor;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle_Painter extends Artist  {
    private int width, height;
    private int x,y;
    private Color color;

    public Rectangle_Painter() {}
    
    public void setParameters(int pMinSize, int pMaxSize, int pX, int pY, Color pColor) {
    	this.x = pX;
    	this.y = pY;
    	this.color = pColor;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}

