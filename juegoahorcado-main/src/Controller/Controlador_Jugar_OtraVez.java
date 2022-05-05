package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import Vista.Marco;
import Vista.MarcoReves;

public class Controlador_Jugar_OtraVez extends MouseAdapter{
	

	private Marco marco= null;
	private MarcoReves marco_Reves= null;
	private Controlador_Inicial reinicio;
	private Controlador_De_Letras contLetras;
	private String cantidadGuionesSegunCantidadLetras="";
	
	
	public Controlador_Jugar_OtraVez(Marco marco)
	{
		this.marco = marco;
	}
	
	public Controlador_Jugar_OtraVez(MarcoReves marcoReves)
	{
		this.marco_Reves = marcoReves;
	}


	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
		if(this.marco_Reves == null) 
		{
			marco.setVisible(false);
			Marco m = new Marco(marco.modo_De_Juego);
			m.initialize();
		}
		else 
		{
			marco_Reves.setVisible(false);
			JOptionPane pregunta_Palabra= new JOptionPane();
			String palabra_Usuario= pregunta_Palabra.showInputDialog("Ingrese palabra");
			MarcoReves m = new MarcoReves(palabra_Usuario);
			m.initialize();
		}
		
		
	}
	

	
}
