package Controlador;
import Dispositivo.*;

public abstract class Control {
    protected DispositivoCasa dispositivoCasa;

    public Control(DispositivoCasa dispositivoCasa) {
        this.dispositivoCasa = dispositivoCasa;
    }

    public void mostrarImagen(String foto) {
        dispositivoCasa.mostrarFoto(foto);
    }

    public void ajustarVolumen(int nivel) {
        dispositivoCasa.ajustarVolumen(nivel);
    }
}