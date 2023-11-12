package Art;

import Pintor.*; 
import java.util.*;
import java.awt.*;

public class PaintingStrategy implements Constants {
    private int colorCount = 0;
    private int formCount = 0;
    private Random random = new Random();
    
    public Artist determineNextPainter(Artist lastPainter, Artist[] artistas) {
    	
        if (formCount < CANT_NUM_FORMA) {
            // Si el contador es mayor que el número de veces que se puede repetir una figura
            // se devuelve otro pintor random
        	formCount++;
            return getRandomArtistOfType(artistas, lastPainter.getTipoFigura());
        } else {
            // Seleccionar aleatoriamente un pintor de otro tipo
        	formCount = 0;
            return getRandomArtistNotOfType(artistas, lastPainter.getTipoFigura());
        }
        
    }

    private Artist getRandomArtistOfType(Artist[] artistas, String tipo) {
        Random random = new Random();
        Artist artist = artistas[random.nextInt(artistas.length)];
        if (artist.getTipoFigura().equals(tipo)) {
        	return artist;
        }
        else {
        	return getRandomArtistOfType(artistas,tipo);	
        }
        
    }

    private Artist getRandomArtistNotOfType(Artist[] artistas, String tipo) {
        Random random = new Random();
        Artist artist = artistas[random.nextInt(artistas.length)];
        if (!artist.getTipoFigura().equals(tipo)) {
            return artist;
        } else {
            // Debes retornar el resultado de la llamada recursiva
            return getRandomArtistNotOfType(artistas, tipo);
        }
    }

    public void defineColor(Artist painter, Artist lastPainter) {
        // Lógica para determinar el próximo color
        if (colorCount < CANT_NUM_COLOR) {
            painter.setColor(lastPainter.getColor());
            colorCount++;
        } else {
            painter.setColor(generateRandomColor());
            colorCount = 0;
        }
    }

    public void defineSize(Artist painter, Artist lastPainter) {
        // Lógica para determinar el tamaño de manera más uniforme
    	painter.setWidth(random.nextInt(max_WIDTH) + min_WIDTH);
        painter.setHeight(random.nextInt(max_HEIGHT) + min_HEIGHT);
    }

    public void definePosition(Artist painter, Artist lastPainter) {
        // Lógica para determinar la próxima posición dentro del Canvas
        int newX, newY;

        
        newX = random.nextInt(X - painter.getWidth());
        newY = random.nextInt(Y - painter.getHeight());
        

        painter.setX(newX);
        painter.setY(newY);
    }

    private Color generateRandomColor() {
        Random random = new Random();
        return new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
    }

}
