package BuscadorFicheros;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ControladorBuscador implements ActionListener, FocusListener, DocumentListener, MouseListener {

	
	private VistaBuscador v;
	private ModeloBuscador m;
	
	
	public ControladorBuscador(VistaBuscador v, ModeloBuscador m) {
		this.v = v;
		this.m = m;
		
		v.btnBuscar.addActionListener(this);
		v.txtExtension.addFocusListener(this);
		v.txtExtension.getDocument().addDocumentListener(this);
		v.list.addMouseListener(this);
		
		setHintTXT();
	}

	
	private void setHintTXT() {
		v.txtExtension.setFont(m.fuenteHint);
		v.txtExtension.setForeground(m.colorHint);
		v.txtExtension.setText(m.HINT_TXT_BUSCAR);
	}
	
	
	private void setNormalTXT() {
		v.txtExtension.setFont(null);
		v.txtExtension.setForeground(null);
		v.txtExtension.setText("");
	}
	
	
	private void setEstadoBoton() {
		boolean txtVacio = v.txtExtension.getText().isEmpty() | v.txtExtension.getText().equals(m.HINT_TXT_BUSCAR);
		v.btnBuscar.setEnabled(txtVacio ? false : true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		v.modeloLista.clear();
		String extension = v.txtExtension.getText();
		if(!extension.startsWith(".")) extension = "." + extension;
		ArrayList<String> archivosFiltrados = m.getArchivosFiltrados(extension);
		for(String archivo: archivosFiltrados)
			v.modeloLista.addElement(archivo);
	}
	
	
	@Override
	public void focusGained(FocusEvent e) {
		if(v.txtExtension.getText().equals(m.HINT_TXT_BUSCAR))
			setNormalTXT();
	}
	
	
	@Override
	public void focusLost(FocusEvent e) {
		if(v.txtExtension.getText().isEmpty()) {
			setHintTXT();
			v.btnBuscar.setEnabled(false);
		}
	}


	@Override
	public void insertUpdate(DocumentEvent e) {
		setEstadoBoton();
	}


	@Override
	public void removeUpdate(DocumentEvent e) {
		setEstadoBoton();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			String archivo = v.list.getSelectedValue();
			if(archivo.endsWith(".exe")) m.abrirArchivoExe(archivo);
		}
	}
	
	
	@Override
	public void changedUpdate(DocumentEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

	
}
