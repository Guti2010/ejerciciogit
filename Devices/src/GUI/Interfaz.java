package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import Dispositivo.*;
import Controlador.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.sound.sampled.*;
import java.io.File;

public class Interfaz extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DispositivoCasa dispositivoCasaSeleccionado;
    private JLabel pantallaDispositivo;
    private int volumen = 50; // Volumen inicial

    public Interfaz() {
        setTitle("Casa Inteligente");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JComboBox<DispositivoCasa> casaComboBox = new JComboBox<>(new DispositivoCasa[] {
            new SmartTV("Smart TV", 1080,0),
            new Proyector("Proyector Smart", 720,0),
            new Laptop("Laptop", 15, 0)
        });
        
        JButton subirVolumenButton = new JButton("Subir Volumen");
        JButton bajarVolumenButton = new JButton("Bajar Volumen");
        
        controlPanel.add(new JLabel("Selecciona un dispositivo de casa: "));
        controlPanel.add(casaComboBox);
        controlPanel.add(subirVolumenButton);
        controlPanel.add(bajarVolumenButton);
        
        subirVolumenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dispositivoCasaSeleccionado != null) {
                    dispositivoCasaSeleccionado.ajustarVolumen(dispositivoCasaSeleccionado.getVolumen()+1);
                }
            }
        });
        
        bajarVolumenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dispositivoCasaSeleccionado != null) {
                    dispositivoCasaSeleccionado.ajustarVolumen(dispositivoCasaSeleccionado.getVolumen()-1);
                }
            }
        });

        pantallaDispositivo = new JLabel();
        pantallaDispositivo.setPreferredSize(new Dimension(800, 400));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(pantallaDispositivo, BorderLayout.CENTER);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        add(mainPanel);

        casaComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispositivoCasaSeleccionado = (DispositivoCasa) casaComboBox.getSelectedItem();
                actualizarPantalla();
            }
        });
    }

    private void actualizarPantalla() {
        if (dispositivoCasaSeleccionado != null) {
            dispositivoCasaSeleccionado.mostrarImagen("imagen.jpg");
            pantallaDispositivo.setIcon(new ImageIcon("imagen.jpg"));

            dispositivoCasaSeleccionado.reproducirSonido("sound.wav");
            reproducirSonido("sound.wav", volumen);
        }
    }

    private void reproducirSonido(String sonidoPath, int volumen) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sonidoPath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            
            

            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private float calcularGanancia(int volumen) {
        float gain = (float) (20 * Math.log10(volumen / 100.0));
        return Math.max(gain, -80.0f); // Limitar la ganancia a -80 dB
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Interfaz casaUI = new Interfaz();
                casaUI.setVisible(true);
            }
        });
    }
}