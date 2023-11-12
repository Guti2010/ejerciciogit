package Main;
import javax.swing.*; 
import Art.*;
public class main {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ArtGeneratorApp app = new ArtGeneratorApp();
            app.setVisible(true);
        });
    }
}
