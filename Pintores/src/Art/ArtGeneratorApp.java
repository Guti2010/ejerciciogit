package Art;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import Factory.*;
import Pintor.*;

public class ArtGeneratorApp extends JFrame implements Constants {
    private Artist artistas[];
    private ArtistIterator artistIterator;
    private Random random = new Random();
    private PaintingStrategy paintingStrategy;
    private Canvas canvas;
    private Artist currentArtist;
    private int shapesGenerated = 1;

    private final Object lock = new Object(); // Objeto para sincronización

    private void generateAndPaintShape() {
        if (artistIterator.hasNext()) {
            Artist nextArtist = artistIterator.next();
            paintingStrategy.defineColor(nextArtist, currentArtist);
            paintingStrategy.defineSize(nextArtist, currentArtist);
            paintingStrategy.definePosition(nextArtist, currentArtist);
            currentArtist.setNextPainter(nextArtist);

            // Sincronizar con el bloqueo para garantizar operaciones atómicas
            synchronized (lock) {
                SwingUtilities.invokeLater(() -> {
                    canvas.addShape(nextArtist);
                    currentArtist = nextArtist;
                    shapesGenerated++;

                    if (shapesGenerated >= NUM_SHAPES) {
                        lock.notify(); // Notificar a otros hilos
                        return;
                    }
                });
            }

            // Pausa de medio segundo antes de generar la próxima forma
            try {
                Thread.sleep(THREAD_RELAX);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Llamar recursivamente para generar la próxima forma
            generateAndPaintShape();
        }
    }

    public ArtGeneratorApp() {
        this.paintingStrategy = new PaintingStrategy();
        setTitle("Generador de Arte Abstracto");
        setSize(X, Y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        artistas = new Artist[CANT_PINTORES_POR_FORMA * 3];

        PainterFactory circlePainterFactory = new CirclePainterFactory();
        PainterFactory rectanglePainterFactory = new RectanglePainterFactory();
        PainterFactory trianglePainterFactory = new TrianglePainterFactory();

        int count = 0;

        for (; count < CANT_PINTORES_POR_FORMA; count++) {
            artistas[count] = circlePainterFactory.createPainter();
        }
        for (; count < CANT_PINTORES_POR_FORMA * 2; count++) {
            artistas[count] = rectanglePainterFactory.createPainter();
        }
        for (; count < CANT_PINTORES_POR_FORMA * 3; count++) {
            artistas[count] = trianglePainterFactory.createPainter();
        }

        artistIterator = new ArtistIterator(artistas);

        // Crear un lienzo personalizado para dibujar
        canvas = new Canvas();
        add(canvas);
        int x = random.nextInt(X);
        int y = random.nextInt(Y);
        Color color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());

        // Seleccionar un pintor aleatorio
        currentArtist = artistIterator.next();
        currentArtist.setWidth(60);
        currentArtist.setHeight(100);
        currentArtist.setX(x);
        currentArtist.setY(y);
        currentArtist.setColor(color);

        canvas.addShape(currentArtist);

        // Crear un hilo para generar y pintar formas durante un número específico de veces
        new Thread(() -> generateAndPaintShape()).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArtGeneratorApp app = new ArtGeneratorApp();
            app.setVisible(true);
        });
    }
}





