package Art;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import Pintor.*;
public class Canvas extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Artist> artistas = new ArrayList<>();

    public void addShape(Artist artista) {
        artistas.add(artista);
        repaint(); // Repintar el lienzo
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Artist artista : artistas) {
        artista.draw(g);
        }
    }
}