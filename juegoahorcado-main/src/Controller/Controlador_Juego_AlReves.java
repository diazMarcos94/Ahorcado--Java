package Controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Modelo.ChequeaLetra;
import Vista.MarcoReves;

public class Controlador_Juego_AlReves extends WindowAdapter{
	
	private MarcoReves marco;
	private ChequeaLetra partida;
	private String cantidadGuionesSegunCantidadLetras="";
	
	public Controlador_Juego_AlReves(MarcoReves marco) {
		this.marco= marco;
		this.partida = new ChequeaLetra(marco.getPalabra_recibida());	
	}
	
	public void windowOpened(WindowEvent e) 
	{
		mostrarGuiones();
	}
	
	public void mostrarGuiones ()
	{
		
		//MOSTRAR GUIONES EN PANTALLA
		for( char c: partida.getArrayConGuiones())
			marco.getPalabra().setText(cantidadGuionesSegunCantidadLetras += "  " +c);
		
		//REUTILIZO LA VARIABLE
		cantidadGuionesSegunCantidadLetras= "";
		
		//MOSTRAR PALABRA A ADIVINAR
		for( char c: partida.getArrayConLetras())
			marco.getPalabra_Usuario().setText(cantidadGuionesSegunCantidadLetras += "  " +c);
			
	}
		
	public ChequeaLetra getPartida() {
		return partida;
	}
}
