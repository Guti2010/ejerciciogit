package Factory;
import Pintor.*;
public class TrianglePainterFactory implements PainterFactory {
    @Override
    public Artist createPainter() {
        return new Triangle_Painter();
    }
}
