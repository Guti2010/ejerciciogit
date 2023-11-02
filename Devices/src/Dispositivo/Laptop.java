package Dispositivo;

public class Laptop extends DispositivoCasa {
    public Laptop(String nombre, int tamañoPantalla, int volumen) {
        super(nombre, tamañoPantalla, volumen);
    }

    @Override
    public void mostrarImagen(String foto) {
        System.out.println("Mostrando foto en " + nombre + " con tamaño de pantalla " + resolucionPantalla + ": " + foto);
    }

    @Override
    public void ajustarVolumen(int tamaño) {
    	resolucionPantalla = tamaño;
        System.out.println("Ajustando tamaño de pantalla en " + nombre + " a " + tamaño);
    }
}