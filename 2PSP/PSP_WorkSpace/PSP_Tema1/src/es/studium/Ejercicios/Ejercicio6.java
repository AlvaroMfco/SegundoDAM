package es.studium.Ejercicios;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Ejercicio6 extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio6 frame = new Ejercicio6();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejercicio6()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(46, 56, 346, 194);
		contentPane.add(textArea);

		JButton btnNewButton = new JButton("Seleccionar directorio");
		btnNewButton.setBounds(129, 11, 193, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(ruta(abrirSelector()));
			}
		});
		contentPane.add(btnNewButton);

	}

	public String ruta(String pathname)
	{
		File filePathname = new File(pathname);
		File[] files = filePathname.listFiles();
		String res = "";
		for (File element : files) {
			if(res=="") {
				res = element.getName();
			} else {
				res = res + "\n" + element.getName();
			}
		}
		return res;
	}

	private String abrirSelector()
	{
		JFileChooser jfc = new JFileChooser();
		String res = "";
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			res = jfc.getSelectedFile().getPath();
		}
		return res;
	}
}