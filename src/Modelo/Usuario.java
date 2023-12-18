package Modelo;

import java.util.ArrayList;

import Controlador.Persona;

public class Usuario extends Persona {
    private String correo;
    private ArrayList<Prestamo> listaPrestamos;

    public Usuario(String nombre, String identificacion, String correo) {
        super(nombre, identificacion);
        this.correo = correo;
        this.listaPrestamos = new ArrayList<>();
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Identificación: " + identificacion);
        System.out.println("Correo: " + correo);
    }

   public void solicitarPrestamo(Libro libro) {
    if (libro.isDisponible()) {
        Prestamo prestamo = new Prestamo(libro, this);
        libro.prestar();
        agregarPrestamo(prestamo);
        System.out.println("Préstamo solicitado con éxito.");
    } else {
        System.out.println("El libro no está disponible para préstamo.");
    }
}

    public void devolverLibro(Libro libro) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getLibro().equals(libro) && prestamo.esPrestamoVigente()) {
                libro.devolver();
                listaPrestamos.remove(prestamo);
                System.out.println("Devolución exitosa. Libro marcado como disponible.");
                return;
            }
        }
        System.out.println("Error: El usuario no tiene el libro prestado o el préstamo ha expirado.");
    }

    public void agregarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }

    public Iterable<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

}

