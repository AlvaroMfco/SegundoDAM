package BuscadorFicheros;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VistaBuscador extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
	private JPanel contentPane = new JPanel();
	protected JTextField txtExtension = new JTextField();
	protected JButton btnBuscar = new JButton("Buscar");
	protected DefaultListModel<String> modeloLista = new DefaultListModel<String>();
	protected JList<String> list = new JList<String>(modeloLista);

	
	public VistaBuscador() {
		setTitle("Mis ficheros");
		setBounds(100, 100, 650, 450);
		setResizable(false);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnBuscar.setEnabled(false);
		
		btnBuscar.setBounds(229, 346, 176, 23);
		contentPane.add(btnBuscar);
		
		txtExtension.setHorizontalAlignment(SwingConstants.LEFT);
		txtExtension.setBounds(133, 312, 367, 23);
		txtExtension.setColumns(10);
		contentPane.add(txtExtension);
		
		list.setFont(getFont()); //Para quitar los elementos en negrita
		JScrollPane scrollpane = new JScrollPane(list);
		scrollpane.setBounds(55, 33, 523, 255);
		contentPane.add(scrollpane);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	
}
