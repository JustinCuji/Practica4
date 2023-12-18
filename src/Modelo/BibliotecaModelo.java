package Modelo;

import Controlador.Biblioteca;

public class BibliotecaModelo {
 
	    private Biblioteca biblioteca;

	    public BibliotecaModelo() {
	        this.biblioteca = new Biblioteca("Biblioteca Central", null);
	    }

		public Biblioteca getBiblioteca() {
			return biblioteca;
		}

		public void setBiblioteca(Biblioteca biblioteca) {
			this.biblioteca = biblioteca;
		}

}