package Pintor;

import java.awt.Color; 
import java.awt.Graphics;
public class Circle_Painter extends Artist {
	private int radius;
	private int width, height;
    private int x,y;
	private Color color;
	private String tipoFigura;
	private Artist nextPainter;

    public Circle_Painter() {
    	this.tipoFigura = "Circulo";
    }
    
    @Override
    public void draw(Graphics g) {
    	this.radius = height-width;
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);        
    }
    
    public void setNextPainter(Artist next) {
        this.nextPainter = next;
    }
      
      public void notifyNextPainter(Art.Canvas canvas) {
          if(nextPainter != null) {
           canvas.addShape(nextPainter);
          }
    }
    
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public String getTipoFigura() {
        return tipoFigura;
    }

    
}
