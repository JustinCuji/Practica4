package Controlador;

import java.util.Scanner;

import Modelo.BibliotecaModelo;
import Modelo.Libro;
import Modelo.Usuario;
import Vista.BibliotecaVista; 

public class BibliotecaControlador {
	private BibliotecaModelo model;
    private BibliotecaVista view;
    private Scanner scanner;

    public BibliotecaControlador(BibliotecaModelo model, BibliotecaVista view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        int opcion;

        do {
            view.mostrarMenu();
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    registrarUsuario();
                    break;
                case 3:
                    buscarLibro();
                    break;
                case 4:
                    prestarLibro();
                    break;
                case 5:
                    devolverLibro();
                    break;
                case 6:
                    view.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    view.mostrarMensaje("Opción no válida. Por favor intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    private void agregarLibro() {
        view.mostrarMensaje("Ingrese el título del libro: ");
        String tituloLibro = scanner.nextLine();
        view.mostrarMensaje("Ingrese el autor del libro: ");
        String autorLibro = scanner.nextLine();
        view.mostrarMensaje("Ingrese el año del libro: ");
        int añoLibro = scanner.nextInt();
        Libro nuevoLibro = new Libro(tituloLibro, autorLibro, añoLibro);
        model.getBiblioteca().agregarLibro(nuevoLibro);
        view.mostrarMensaje("Libro agregado con éxito.");
    }

    private void registrarUsuario() {
        view.mostrarMensaje("Ingrese el nombre del usuario: ");
        String nombreUsuario = scanner.nextLine();
        view.mostrarMensaje("Ingrese la identificación del usuario: ");
        String idUsuario = scanner.nextLine();
        view.mostrarMensaje("Ingrese el correo del usuario: ");
        String correoUsuario = scanner.nextLine();
        Usuario nuevoUsuario = new Usuario(nombreUsuario, idUsuario, correoUsuario);
        model.getBiblioteca().registrarUsuario(nuevoUsuario);
        view.mostrarMensaje("Usuario registrado con éxito.");
    }

    private void buscarLibro() {
        view.mostrarMensaje("Ingrese el título, autor o año del libro a buscar: ");
        String criterioBusqueda = scanner.nextLine();
        Libro libroEncontrado = model.getBiblioteca().buscarLibro(criterioBusqueda);
        if (libroEncontrado != null) {
            libroEncontrado.mostrarInformacion();
        } else {
            view.mostrarMensaje("Libro no encontrado.");
        }
    }

    private void prestarLibro() {
        view.mostrarMensaje("Ingrese el título del libro a prestar: ");
    String tituloLibro = scanner.nextLine();
    Libro libroPrestar = model.getBiblioteca().buscarLibro(tituloLibro);

    if (libroPrestar != null && libroPrestar.isDisponible()) {
        view.mostrarMensaje("Ingrese la identificación del usuario que realizará el préstamo: ");
        String idUsuario = scanner.nextLine();
        Usuario usuarioPrestamo = null;

        // Buscar el usuario por identificación
        for (Usuario usuario : model.getBiblioteca().getListaUsuarios()) {
            if (usuario.getIdentificacion().equals(idUsuario)) {
                usuarioPrestamo = usuario;
                break;
            }
        }

        if (usuarioPrestamo != null) {
            model.getBiblioteca().prestarLibro(libroPrestar, usuarioPrestamo);
            view.mostrarMensaje("Préstamo realizado con éxito.");
        } else {
            view.mostrarMensaje("Usuario no encontrado. Verifique la identificación.");
        }
    } else if (libroPrestar == null) {
        view.mostrarMensaje("Libro no encontrado.");
    } else {
        view.mostrarMensaje("El libro no está disponible para préstamo.");
    }
}// Implementación para prestar libro
        // Puedes completar según la lógica necesaria
    

    private void devolverLibro() {
    view.mostrarMensaje("Ingrese el título del libro a devolver: ");
    String tituloLibro = scanner.nextLine();
    Libro libroDevolver = model.getBiblioteca().buscarLibro(tituloLibro);

    if (libroDevolver != null && !libroDevolver.isDisponible()) {
        view.mostrarMensaje("Ingrese la identificación del usuario que devolverá el libro: ");
        String idUsuario = scanner.nextLine();
        Usuario usuarioDevolucion = null;

        // Buscar el usuario por identificación
        for (Usuario usuario : model.getBiblioteca().getListaUsuarios()) {
            if (usuario.getIdentificacion().equals(idUsuario)) {
                usuarioDevolucion = usuario;
                break;
            }
        }

        if (usuarioDevolucion != null) {
            model.getBiblioteca().devolverLibro(libroDevolver, usuarioDevolucion);
            view.mostrarMensaje("Devolución realizada con éxito.");
        } else {
            view.mostrarMensaje("Usuario no encontrado. Verifique la identificación.");
        }
    } else if (libroDevolver == null) {
        view.mostrarMensaje("Libro no encontrado.");
    } else {
        view.mostrarMensaje("El libro ya está disponible o no fue prestado por esta biblioteca.");
    }   
        
    }
}

