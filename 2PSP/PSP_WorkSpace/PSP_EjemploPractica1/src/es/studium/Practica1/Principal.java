package es.studium.Practica1;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {
    private static final long serialVersionUID = 1L;

    private JScrollPane scrollPane;
    private JTextField textField;
    private List list = new List();
    private String buscar;

    public static void main(String[] args) {
        new Principal();
    }

    public Principal() {
        setTitle("PRUEBA PRACT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(750, 140, 450, 800);
        scrollPane = new JScrollPane();
        scrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(scrollPane);
        scrollPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(46, 25, 232, 20);
        textField.setColumns(10);
        scrollPane.add(textField);

        list.setBounds(46, 76, 346, 650);
        scrollPane.add(list);

        JButton btnNewButton = new JButton("Leer directorio");
        btnNewButton.setBounds(308, 24, 89, 23);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscar = textField.getText().trim(); // Obtenemos la extensión a buscar
                if (!buscar.startsWith(".")) {
                    buscar = "." + buscar; // Aseguramos que empiece con un punto
                }
                HUEVO(); // Iniciar búsqueda en todos los discos
            }
        });
        scrollPane.add(btnNewButton);

        // Añadir un MouseListener para detectar doble clic en archivos .exe
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {  // Doble clic
                    String selectedItem = list.getSelectedItem();
                    if (selectedItem != null && selectedItem.endsWith(".exe")) {
                        ejecutarArchivo(selectedItem); // Ejecutar archivo .exe
                    }
                }
            }
        });

        setVisible(true);
    }

    // Método para buscar los archivos en todos los discos del sistema
    public void HUEVO() {
        File[] discos = File.listRoots(); // Obtener todos los discos del sistema
        list.removeAll(); // Limpiar lista antes de nueva búsqueda
        for (File disco : discos) {
            obtenerNodos(disco); // Buscar archivos en cada disco
        }
        // Agregamos el mensaje cuando termina la búsqueda
        list.add("La búsqueda ha concluido.");
    }

    // Método recursivo para obtener los archivos en los directorios y subdirectorios
    private void obtenerNodos(File archivo) {
        File[] hijos = archivo.listFiles(); // Listar archivos del directorio actual
        if (hijos == null) return; // Verificar si se puede listar

        for (File hijo : hijos) {
            if (hijo.getName().endsWith(buscar)) { // Coincide con la extensión buscada
                list.add(hijo.getAbsolutePath()); // Agregar ruta completa a la lista
            }
            if (hijo.isDirectory()) { // Si es directorio, seguir buscando recursivamente
                obtenerNodos(hijo);
            }
        }
    }

    // Método para ejecutar archivos .exe
    private void ejecutarArchivo(String filePath) {
        try {
            Runtime.getRuntime().exec(filePath); // Ejecutar el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
