package Modelo;

public class Libro {
	 private String titulo;
	    private String autor;
	    private int año;
	    private boolean disponible;

	    public Libro(String titulo, String autor, int año) {
	        this.titulo = titulo;
	        this.autor = autor;
	        this.año = año;
	        this.disponible = true;
	    }

	    public void prestar() {
	        disponible = false;
	    }

	    public void devolver() {
	        disponible = true;
	    }

	    public void mostrarInformacion() {
	        System.out.println("Título: " + titulo);
	        System.out.println("Autor: " + autor);
	        System.out.println("Año: " + año);
	        System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
	    }

	    

	    public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getAutor() {
			return autor;
		}

		public void setAutor(String autor) {
			this.autor = autor;
		}

		public int getAño() {
			return año;
		}

		public void setAño(int año) {
			this.año = año;
		}

		public boolean isDisponible() {
	        return disponible;
	    }

	    public void setDisponible(boolean disponible) {
	        this.disponible = disponible;
	    }
	    
	   
	}


