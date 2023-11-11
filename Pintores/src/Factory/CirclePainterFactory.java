package Factory;
import Pintor.*;
public class CirclePainterFactory implements PainterFactory {
    @Override
    public Artist createPainter() {
        return new Circle_Painter();
    }
}