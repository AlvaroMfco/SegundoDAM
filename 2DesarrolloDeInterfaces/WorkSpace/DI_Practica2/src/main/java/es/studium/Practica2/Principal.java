package es.studium.Practica2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JMenuBar menuBar = new JMenuBar();
	JMenu mnArticulos = new JMenu("Artículos");
	JMenuItem mniNuevoArticulo = new JMenuItem("Nuevo Artículo");
	JMenuItem mniEditarArticulo = new JMenuItem("Editar Artículo");
	JMenuItem mniConsultaArticulo = new JMenuItem("Consultar Artículos");
	JMenuItem mniBajaArticulo = new JMenuItem("Baja Artículos");
	JMenu mnTickets = new JMenu("Tickets");
	JMenuItem mniNuevoTicket = new JMenuItem("Nuevo Ticket");
	JMenuItem mniConsultaTicket = new JMenuItem("Consultar Tickets");


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setTitle("TiendecitaANC");
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar.setBounds(0, 0, 434, 22);
		contentPane.add(menuBar);
		
		menuBar.add(mnArticulos);
		mnArticulos.add(mniNuevoArticulo);
		mnArticulos.add(mniEditarArticulo);
		mnArticulos.add(mniConsultaArticulo);
		mnArticulos.add(mniBajaArticulo);
		menuBar.add(mnTickets);
		mnTickets.add(mniNuevoTicket);
		mnTickets.add(mniConsultaTicket);
		
		//Listeners
		mniNuevoArticulo.addActionListener(this);
		mniEditarArticulo.addActionListener(this);
		mniConsultaArticulo.addActionListener(this);
		mniBajaArticulo.addActionListener(this);
		mniNuevoTicket.addActionListener(this);
		mniConsultaTicket.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(mniNuevoArticulo)) new NuevoArticulo().setVisible(true);
		
		if(e.getSource().equals(mniEditarArticulo)) new EditarArticulo().setVisible(true);
			
		if(e.getSource().equals(mniConsultaArticulo)) new ConsultarArticulo().setVisible(true);
		
		if(e.getSource().equals(mniBajaArticulo)) new BajaArticulo().setVisible(true);
		
		if(e.getSource().equals(mniNuevoTicket)) new NuevoTicket().setVisible(true);
		
		if(e.getSource().equals(mniConsultaTicket)) new ConsultaTicket().setVisible(true);
		
	}
}
