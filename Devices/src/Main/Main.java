package Main;

import Dispositivo.*; 
import Controlador.*;
//Ejemplo de uso
public class Main {
    public static void main(String[] args) {
        DispositivoCasa smartTV = new SmartTV("Smart TV", 1080, 40);
        DispositivoCasa proyectorSmart = new Proyector("Proyector Smart", 720, 30);
        DispositivoCasa laptop = new Laptop("Laptop", 720, 20);

        Control smartphone = new Smartphone(smartTV);
        Control googleHome = new GoogleHome(proyectorSmart);
        Control alexa = new Alexa(laptop);
        Control firestick = new Firestick(laptop);

        smartphone.mostrarImagen("Foto1.jpg");
        smartphone.ajustarVolumen(60);

        googleHome.mostrarImagen("Foto2.jpg");
        googleHome.ajustarVolumen(50);

        alexa.mostrarImagen("Foto3.jpg");
        alexa.ajustarVolumen(70);

        firestick.mostrarImagen("Foto4.jpg");
        firestick.ajustarVolumen(80);
    }
}