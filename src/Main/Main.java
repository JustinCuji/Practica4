package Main;

import Controlador.BibliotecaControlador;
import Modelo.BibliotecaModelo;
import Vista.BibliotecaVista;

public class Main { 
	public static void main(String[] args) {
        BibliotecaModelo model = new BibliotecaModelo();
        BibliotecaVista view = new BibliotecaVista();
        BibliotecaControlador controller = new BibliotecaControlador(model, view);

        controller.ejecutar();
    }
}
