package Controlador;

import Dispositivo.DispositivoCasa;

public abstract class DispositivoControl {
    protected DispositivoCasa dispositivoCasa;

    public DispositivoControl(DispositivoCasa dispositivoCasa) {
        this.dispositivoCasa = dispositivoCasa;
    }

    public void mostrarImagen(String foto) {
        dispositivoCasa.mostrarImagen(foto);
    }

    public void ajustarVolumen(int nivel) {
        dispositivoCasa.ajustarVolumen(nivel);
    }
}