package Graphics;

public interface Constants {
	public final static int THREAD_RELAX = 300; //tiempo entre que se pinta figura y figura
	public final static int NUM_SHAPES = 40;  //cantidad de figuras que dura el thread
	public final static int CANT_PINTORES_POR_FORMA = 3; //pintores de cada tipo 
	public final static int CANT_NUM_COLOR = 1; //Cantitad de veces que se puede pintar un color antes de cambiar
	public final static int CANT_NUM_FORMA = 1; //Cantidad de veces que se pinta una figura antes de cambiar
	public final static int min_WIDTH = 20; //minimo de ancho
	public final static int max_WIDTH = 60; //max de ancho
	public final static int min_HEIGHT = 20; //min altura
	public final static int max_HEIGHT = 60; //max altura
}
