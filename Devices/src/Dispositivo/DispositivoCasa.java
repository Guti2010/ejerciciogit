package Dispositivo;

public abstract class DispositivoCasa {
    protected String nombre;
    protected int resolucionPantalla;
    protected int volumen;

    public DispositivoCasa(String nombre, int resolucionPantalla, int volumen) {
        this.nombre = nombre;
        this.resolucionPantalla = resolucionPantalla;
        this.volumen = volumen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getResolucionPantalla() {
        return resolucionPantalla;
    }

    public int getVolumen() {
        return volumen;
    }
    
    public String reproducirSonido(String sonido) {
    	return "Reproduciondo sonido " + sonido ;
    }

    public void mostrarImagen(String imagen) {
        System.out.println("Mostrando imagen en " + nombre + ": " + imagen);
        // Lógica para mostrar la imagen en la pantalla del dispositivo
    }

    public void ajustarVolumen(int nivel) {
        System.out.println("Ajustando volumen en " + nombre + " a " + nivel);
        this.volumen = nivel;
        // Lógica para ajustar el volumen del dispositivo
    }
}