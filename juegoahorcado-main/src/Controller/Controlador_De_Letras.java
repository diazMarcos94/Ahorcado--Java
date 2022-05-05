package Controller;
import java.awt.event.*;

import javax.swing.JOptionPane;
import Modelo.ChequeaLetra;
import Vista.Marco;


public class Controlador_De_Letras extends MouseAdapter{
	
	//ATRIBUTOS------------
	private Marco marco;
	private ChequeaLetra partida;
	
	
	public Controlador_De_Letras(Marco marco) 
	{
		this.marco=marco;
		partida = marco.getInicio().getPartida();
		
	}

	
	//TODO LO QUE SUCEDE A PARTIR DE HACER CLICK EN EL BOTON-----------
	
	
	@Override
	public void mouseClicked(MouseEvent e) {

		//Evito que tire error si apreto Enviar sin escribir nada. (La primera vez es null, la siguiente "") y que ingrese mas de una letra
			
		if(marco.getRecibe_Letra().getText() != "" && marco.getRecibe_Letra().getText() != null && 
			marco.getRecibe_Letra().getText().length() == 1 && Character.isLetter(marco.getRecibe_Letra().getText().charAt(0)))
		{
			
			char letraRecibida = marco.getRecibe_Letra().getText().toUpperCase().charAt(0); //GUARDO LETRA RECIBIDA
			marco.getRecibe_Letra().setText("");
			marco.getRecibe_Letra().requestFocus();//--VUELVO A DEJAR EN BLANCO EL TEXTAREA
			
			String letras_recibidas= partida.getLetras_recibidas();
			
			//-----VALIDAR QUE LETRA  NO SEA REPETIDA---
			if(!partida.validarLetraRepetida(letraRecibida, letras_recibidas ))
			{
				// 	ESCRIBO LA LETRA RECIBIDA EN PANTALLA
				letras_recibidas += "" + letraRecibida;
				marco.getLetras_Ya_Ingresadas().setText(letras_recibidas);
				partida.setLetras_recibidas(letras_recibidas);
				
				//    VALIDAR LETRA SI ES CORRECTA 	
				char arrayDeLetras[]= partida.validarLetra(letraRecibida); //--Array de guiones/letras que se muestra en la pantalla.
				
				
				// 	VALDIAR SI PERDIO
				if(partida.getVidas() < 1) {
					reiniciarJuego();
					marco.get_Texto_Respuesta().setText("La palabra era: " + partida.getPalabra());
					partida = new ChequeaLetra(marco.modo_De_Juego);
				}
				
				
				// VALIDAR SI GANO
				//Gana si el array ingresado cada letra es distinta de '-'. En caso de
				//ingresar la primer letra una letra equivocada segun el codigo tambien ganaria.
				//por eso controla usando una nueva variable que valida que al menos haya acertado una letra
				if(partida.getAcertoAlMenosUnaLetra()  )
				{
					if(partida.siGano(arrayDeLetras)) {
						reiniciarJuego();

						marco.get_Texto_Respuesta().setText("Bien jugado! Has ganado.");

						partida = new ChequeaLetra(marco.modo_De_Juego);
					}
				}
				
				
				//--ACTUALIZAR PANTALLA SEGUN LETRA RECIBIDA
				String cantidadGuionesSegunCantidadLetras = partida.actualizarPantalla(arrayDeLetras);
				marco.getPalabra_En_Pantalla().setText(cantidadGuionesSegunCantidadLetras);
				
				
				//--MOSTRAR INTENTOS RESTANTES
				marco.getTexto_Intentos_Restantes().setText("Intentos restantes: " + partida.getVidas());
				
				

				}
			
			}else {
			// abre un cuadro de dialogo que informa que  se ingreso mas de una letra y lo pone en blanco
				JOptionPane.showMessageDialog(null,"Ingrese una unica LETRA.");
				marco.getRecibe_Letra().setText("");
			}
		}
	
	
	//------------------------------------------------------------------------------
		public void reiniciarJuego() 
		{
			marco.getEnvia_Letra().setEnabled(false);
			marco.getRecibe_Letra().setEnabled(false);
			marco.getTexto_Intentos_Restantes().setVisible(false);
			marco.getDame_Una_Pista().setEnabled(false);		
			marco.getTexto_Juego_Terminado().setVisible(true);
			marco.getJugar_Otra_Vez().setVisible(true);
			marco.getMenuPrincipal().setVisible(true);
			
			partida.setLetras_recibidas("");

			marco.getLetras_Ya_Ingresadas().setText("");
			String cantidadGuionesSegunCantidadLetras = partida.actualizarPantalla(partida.getArrayConGuiones());
			marco.getPalabra_En_Pantalla().setText(cantidadGuionesSegunCantidadLetras);
			marco.get_Texto_Respuesta().setVisible(true);


		}
	
}

