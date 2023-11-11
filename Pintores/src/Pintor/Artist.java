package Pintor;

import java.awt.Color;
import java.awt.Graphics;
public abstract class Artist {
    public  Artist() {}
    public abstract void setParameters(int minSize, int maxSize, int x, int y, Color color);
    public abstract void draw(Graphics g);
}
