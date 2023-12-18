package Modelo;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BibliotecaGui extends Frame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button agregarLibroButton;
    private Button registrarUsuarioButton;
    private Button buscarLibroButton;
    private Button prestarLibroButton;
    private Button devolverLibroButton;
    private TextField inputField;
    private Label outputLabel;

    public BibliotecaGui() {

        setLayout(new FlowLayout());

        agregarLibroButton = new Button("Agregar Libro");
        registrarUsuarioButton = new Button("Registrar Usuario");
        buscarLibroButton = new Button("Buscar Libro");
        prestarLibroButton = new Button("Prestar Libro");
        devolverLibroButton = new Button("Devolver Libro");
        inputField = new TextField(20);
        outputLabel = new Label("");

        // Agregar acciones a los botones
        agregarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción "Agregar Libro"
                outputLabel.setText("Agregar Libro seleccionado");
            }
        });

        // Agrega otros ActionListener para los demás botones

        // Agregar componentes al contenedor
        add(agregarLibroButton);
        add(registrarUsuarioButton);
        add(buscarLibroButton);
        add(prestarLibroButton);
        add(devolverLibroButton);
        add(inputField);
        add(outputLabel);

        // Configurar el cierre de la ventana
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        setSize(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BibliotecaGui();
    }
}

 