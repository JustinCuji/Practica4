package Controlador;

import java.util.ArrayList;
import java.util.Iterator;

import Modelo.Libro;
import Modelo.Prestamo;
import Modelo.Usuario;

public class Biblioteca {
	private String nombre;
    private String direccion;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Usuario> listaUsuarios;

    public Biblioteca(String nombre, String direccion) {
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.listaLibros = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public Libro buscarLibro(String criterio) {
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(criterio) ||
                libro.getAutor().equalsIgnoreCase(criterio) ||
                String.valueOf(libro.getAño()).equalsIgnoreCase(criterio)) {
                return libro;
            }
        }
        return null;
    }

    public void prestarLibro(Libro libro, Usuario usuario) {
        if (libro.isDisponible()) {
            Prestamo prestamo = new Prestamo(libro, usuario);
            usuario.agregarPrestamo(prestamo);
            libro.prestar();
            System.out.println("Préstamo exitoso.");
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }

 
 Iterable<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    void devolverLibro(Libro libroDevolver, Usuario usuarioDevolucion) {
      
        boolean libroPrestado = false;
       
        for (Prestamo prestamo : usuarioDevolucion.getListaPrestamos()) {
            if (prestamo.getLibro().equals(libroDevolver) && prestamo.esPrestamoVigente()) {
                libroPrestado = true;
                break;
            }
        }

        if (libroPrestado) {
           
            libroDevolver.setDisponible(true);

          
            Iterator<Prestamo> iterator = usuarioDevolucion.getListaPrestamos().iterator();
            while (iterator.hasNext()) {
                Prestamo prestamo = iterator.next();
                if (prestamo.getLibro().equals(libroDevolver) && prestamo.esPrestamoVigente()) {
                    iterator.remove();
                    break;
                }
            }

            System.out.println("Devolución exitosa. Libro marcado como disponible.");
        } else {
            System.out.println("Error: El usuario no tiene el libro prestado o el préstamo ha expirado.");
        }
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}

