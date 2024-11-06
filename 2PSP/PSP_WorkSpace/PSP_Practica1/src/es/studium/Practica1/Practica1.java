package es.studium.Practica1;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Practica1 extends JFrame implements MouseListener, FocusListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtExtension;
	private String vExtension;
	private DefaultListModel<String> modeloTabla = new DefaultListModel<String>();
	private JList<String> lista = new JList<String>(modeloTabla);

	//Agregar archivos con la extensión a la lista.
	private void agregarFicheros(File f, String extension) {
		//Recorrer directorios padres e hijos.
		File archivos[] = f.listFiles();
		if(archivos != null) {
			for(int i = 0; i<archivos.length; i++) {
				String nombre = archivos[i].getAbsolutePath();
				//Si tiene la extensión indicada, lo añadimos a la lista
				if(nombre.endsWith(extension)) {
					modeloTabla.addElement(nombre);
				}
				//Si el hijo es a su vez un directorio, se vuelve a llamar a esta función.
				if(archivos[i].isDirectory()) {
					agregarFicheros(archivos[i], extension);
				}
			}
		}
	}

	//Buscar archivos en todos los discos.
	public void encontrarFicheros(String extension){
		File equipo[] = File.listRoots();
		for (int i = 0; i<equipo.length; i++) {
			//Se llama a agregarFicheros para cada disco existente.
			agregarFicheros(equipo[i], extension);
		}
	}


	public Practica1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 510, 332);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(lista);
		lista.addMouseListener(this);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(415, 363, 89, 23);
		contentPane.add(btnBuscar);

		txtExtension = new JTextField();
		txtExtension.setBounds(50, 364, 328, 22);
		contentPane.add(txtExtension);
		txtExtension.setColumns(10);
		txtExtension.addFocusListener(this);


		//Al pulsar buscar
		btnBuscar.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e) {
				//Si no se ha introducido ninguna extensión, no realizamos ninguna búsqueda.
				String msgError = "Debes introducir una extensión";
				if(txtExtension.getText().isEmpty() || txtExtension.getText().equals(msgError)) {
					//Sonidito para error
					Toolkit.getDefaultToolkit().beep();
					txtExtension.setText(msgError);
					return;
				}
				//Se vacía la lista.
				modeloTabla.clear();
				vExtension =  txtExtension.getText();
				//Si la extensión no comienza por ".", agregamos uno.
				if(!vExtension.startsWith(".")) {
					vExtension = "." + vExtension;
				}
				encontrarFicheros(vExtension); 
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Si se hace doble click
		if(e.getClickCount() == 2) {
			//Cogemos la extensión y comprobamos si es ".exe".
			String archivo = lista.getSelectedValue();
			//Si el archivo clicado no es una ruta vacía y acaba en ".exe", se ejecutará.
			if(archivo != null && archivo.endsWith(".exe")) {
				try {
					ProcessBuilder pb = new ProcessBuilder(new String[] {archivo});
					pb.start();
				}
				catch(IOException err){
					System.out.println("Error al ejecutar el archivo");
				}
			}
			else if(archivo != null && !archivo.endsWith(".exe")) {
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void focusGained(FocusEvent e) {
		if(txtExtension.getText().equals("Debes introducir una extensión")) {
			txtExtension.setText("");
		}
	}
	@Override
	public void focusLost(FocusEvent e) {}
}
