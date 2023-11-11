package Estrategia;
import Pintor.*;
public interface PaintingStrategy {
    void defineColor(Artist painter);
    void defineSize(Artist painter);
    void definePosition(Artist painter);
    Artist determineNextPainter(Artist[] painters);
}
