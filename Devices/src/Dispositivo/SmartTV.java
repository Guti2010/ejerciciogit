package Dispositivo;

public class SmartTV extends DispositivoCasa {
    public SmartTV(String nombre, int tamañoPantalla, int volumen) {
        super(nombre, tamañoPantalla, volumen);
    }

    @Override
    public void mostrarFoto(String foto) {
        System.out.println("Mostrando foto en " + nombre + " con tamaño de pantalla " + tamañoPantalla + ": " + foto);
    }

    @Override
    public void ajustarTamañoFoto(int tamaño) {
        tamañoPantalla = tamaño;
        System.out.println("Ajustando tamaño de pantalla en " + nombre + " a " + tamaño);
    }
}