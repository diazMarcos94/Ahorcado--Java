package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import Vista.Marco;
import Vista.MarcoReves;
import Vista.Ventana;

public class ControladorVentana extends MouseAdapter{
	
	private Ventana ventana;
	private Marco marco;
	
	public ControladorVentana (Marco marco) {
		this.marco = marco;
	}
		
	public void mouseClicked(MouseEvent e) {
		ventana = new Ventana();
		ventana.setVisible(true);
		marco.setVisible(false);
		
	}
		

}
