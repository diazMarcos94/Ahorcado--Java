package Controller;

import java.awt.event.*;

import Modelo.*;
import Vista.Marco;

public class Controlador_Inicial extends WindowAdapter{
			
	private Marco marco;
	private ChequeaLetra partida;
	private String cantidadGuionesSegunCantidadLetras="";
	
	public Controlador_Inicial(Marco marco) {
		this.marco= marco;
		this.partida = new ChequeaLetra(marco.modo_De_Juego);
	}
		
	public ChequeaLetra getPartida() {
		return partida;
	}

	public void windowOpened(WindowEvent e) 
	{
		mostrarGuiones();
		marco.getTexto_Intentos_Restantes().setText("Intentos restantes: " +partida.getVidas());
	}
	
	public void mostrarGuiones ()
	{
		for( char c: partida.getArrayConGuiones())
			marco.getPalabra_En_Pantalla().setText(cantidadGuionesSegunCantidadLetras += "  " +c);
			
	}
		
	

	
	
}
