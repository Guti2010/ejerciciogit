package Pintor;

import java.awt.Color; 
import java.awt.Graphics;


public class Triangle_Painter extends Artist  {
	private int sideLength;
	private int width, height;
    private int x,y;
	private String tipoFigura;
	private Color color; 
	private Artist nextPainter;
    public Triangle_Painter() {
    	this.tipoFigura = "Rectangulo";
    }
	
	public void draw(Graphics g) {
		sideLength = height-width;
        g.setColor(color);
        int[] xPoints = {x, x + sideLength, x - sideLength};
        int[] yPoints = {y - sideLength, y + sideLength, y + sideLength};
        g.fillPolygon(xPoints, yPoints, 3);
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
