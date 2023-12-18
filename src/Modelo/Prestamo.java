package Modelo;

import java.util.Date;

public class Prestamo {

    private Libro libro;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = new Date();
    }

    public int calcularDiasPrestamo() {
        long tiempoPrestamo = new Date().getTime() - fechaPrestamo.getTime();

        return (int) (tiempoPrestamo / (1000 * 60 * 60 * 24));
    }

    public boolean esPrestamoVigente() {

        int maxDiasPrestamo = 14;

        return calcularDiasPrestamo() <= maxDiasPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
}
