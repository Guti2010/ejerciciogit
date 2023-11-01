package Dispositivo;

public abstract class DispositivoCasa {
	 protected String nombre;
	 protected int tamañoPantalla;
	 protected int volumen;
	
	 public DispositivoCasa(String nombre, int tamañoPantalla, int volumen) {
	     this.nombre = nombre;
	     this.tamañoPantalla = tamañoPantalla;
	     this.volumen = volumen;
	 }
	
	 public abstract void mostrarFoto(String foto);
	 
	 public void ajustarVolumen(int nivel) {
	     this.volumen = nivel;
	     System.out.println("Ajustando volumen en " + nombre + " a " + nivel);
	 }
	
	 public abstract void ajustarTamañoFoto(int tamaño);
	
	 public void mostraryAjustarFoto(String foto, int tamaño) {
	     mostrarFoto(foto);
	     ajustarTamañoFoto(tamaño);
	}
 
}