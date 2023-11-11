package Estrategia;
import Pintor.*;

public class DeterministicPaintingStrategy implements PaintingStrategy {
    private int colorCount = 0;
    private int shapeCount = 0;

    @Override
    public void defineColor(Artist painter, Artist lastPainter) {
        if (colorCount >= Constants.CANT_NUM_COLOR) {
            colorCount = 0;
            painter.setColor(new Color(Math.random(), Math.random(), Math.random()));
        } else {
            painter.setColor(lastPainter.getColor());
        }
        colorCount++;
    }

    @Override
    public void defineSize(Artist painter, Artist lastPainter) {
        int size = (int) (Math.random() * (Constants.max_WIDTH - Constants.min_WIDTH + 1) + Constants.min_WIDTH);
        painter.setSize(size);
    }

    @Override
    public void definePosition(Artist painter, Artist lastPainter) {
        int x = lastPainter.getX() + lastPainter.getSize();
        int y = lastPainter.getY() + lastPainter.getSize();
        painter.setPosition(x, y);
    }

    @Override
    public Artist determineNextPainter(Artist[] painters, Artist lastPainter) {
        if (shapeCount >= Constants.CANT_NUM_FORMA) {
            shapeCount = 0;
            // Lógica para seleccionar un nuevo tipo de figura (puedes usar una lógica específica aquí)
        } else {
            // Utiliza el mismo tipo de figura que el último pintor
        }
        shapeCount++;

        return painters[(int) (Math.random() * painters.length)]; // Puedes ajustar la lógica para seleccionar el próximo pintor
    }
}