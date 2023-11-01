package Dispositivo;

public class Proyector extends DispositivoCasa {
    public Proyector(String nombre, int tamañoPantalla, int volumen) {
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