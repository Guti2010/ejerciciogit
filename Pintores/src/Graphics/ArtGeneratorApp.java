package Graphics;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import Factory.*;
import Pintor.*;
public class ArtGeneratorApp extends JFrame implements Constants {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int WIDTH = 1000;
    private final int HEIGHT = 700;
    private Artist artistas[];
    private Random random = new Random();

    public ArtGeneratorApp() {
        setTitle("Generador de Arte Abstracto");
        setSize(WIDTH, HEIGHT);
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

        // Crear un lienzo personalizado para dibujar
        Canvas canvas = new Canvas();
        add(canvas);

        // Generar y pintar formas aleatorias en el lienzo cada medio segundo
        new Thread(() -> {
            for (int i = 0; i < NUM_SHAPES; i++) {
                int x = random.nextInt(WIDTH);
                int y = random.nextInt(HEIGHT);
                int shapeType = random.nextInt(3); // 0: Círculo, 1: Rectángulo, 2: Triángulo
                Color color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());


                 
                try {
                    Thread.sleep(THREAD_RELAX); // Pausa de medio segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArtGeneratorApp app = new ArtGeneratorApp();
            app.setVisible(true);
        });
    }
}
