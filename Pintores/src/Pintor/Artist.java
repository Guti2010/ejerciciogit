package Pintor;

import java.awt.Color;   
import Art.*;
import java.awt.*;
public abstract class Artist  {
    private int width, height;
    private int x, y;
    private Color color;
    private String tipoFigura;
    private Artist nextPainter;
    public Artist() {
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

    public void setTipoFigura(String tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

    public abstract void draw(Graphics g);
    
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
