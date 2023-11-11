package Factory;
import Pintor.*;
public class RectanglePainterFactory implements PainterFactory {
    @Override
    public Artist createPainter() {
        return new Rectangle_Painter();
    }
}