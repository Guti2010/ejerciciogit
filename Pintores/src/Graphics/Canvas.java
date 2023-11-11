package Graphics;

import java.awt.Graphics; 
import javax.swing.JPanel;
import Pintor.*;

import java.util.*;
class Canvas extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.util.List<Artist> pintores = new ArrayList<>();

    public void addShape(Artist pPintor) {
        pintores.add(pPintor);
        repaint(); // Repintar el lienzo
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Artist pintor : pintores) {
            pintor.draw(g);
        }
    }
}