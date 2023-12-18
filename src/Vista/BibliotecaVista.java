package Vista;

public class BibliotecaVista {
	public void mostrarMenu() {
        System.out.println("Bienvenido al Sistema de Gestión de Biblioteca");
        System.out.println("1. Agregar Libro");
        System.out.println("2. Registrar Usuario");
        System.out.println("3. Buscar Libro");
        System.out.println("4. Prestar Libro");
        System.out.println("5. Devolver Libro");
        System.out.println("6. Salir");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
