package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import Modelo.ChequeaLetra;
import Vista.Marco;



public class Controlador_Pista extends MouseAdapter{
	
	private Marco marco;
	private ChequeaLetra partida;
	
	
	
	public Controlador_Pista(Marco marco)
	{
		this.marco = marco;
		this.partida = marco.getInicio().getPartida();
		
	}

	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
		if(partida.getNumero_De_Pistas() == 1)
		{
			char letra_A_Devolver= ' ';
			
			String letras_A_Devolver="";
			
			char[] palabra_A_Adivinar= partida.getArrayConLetras();
			char[] en_Busca_De_Una_Letra= partida.getArrayConGuiones();
			
			//Guardar letras correspondientes a guiones
			for(int i=0; i< en_Busca_De_Una_Letra.length; i++)
			{
				if(en_Busca_De_Una_Letra[i] == '-')
				{
					letras_A_Devolver+= "" + palabra_A_Adivinar[i];
				}
			}
			
			//Elegir letra aleatoriamente 
			int numero_Aleatorio= (int) (Math.random()*letras_A_Devolver.length());
			for( int i= 0; i<letras_A_Devolver.length(); i++)
			{
				if(numero_Aleatorio  == i)
					letra_A_Devolver= letras_A_Devolver.charAt(i);
			}
			
			
			//	ESCRIBIR LETRA EN PANTALLA
			String letras_Recibidas= partida.getLetras_recibidas();
			letras_Recibidas += "" + letra_A_Devolver;
			marco.getLetras_Ya_Ingresadas().setText(letras_Recibidas);
			partida.setLetras_recibidas(letras_Recibidas);
			
			// ACTUALIZAR INFORMACION EN PANTALLA
			char arrayDeLetras[]= partida.validarLetra(letra_A_Devolver);
			
			//--ACTUALIZAR PANTALLA SEGUN LETRA RECIBIDA
			String cantidadGuionesSegunCantidadLetras = partida.actualizarPantalla(arrayDeLetras);
			marco.getPalabra_En_Pantalla().setText(cantidadGuionesSegunCantidadLetras);
			
			//--MOSTRAR INTENTOS RESTANTES
			marco.getTexto_Intentos_Restantes().setText("Intentos restantes: " + partida.getVidas());
			
			//VALIDAR SI GANO
			if(partida.getAcertoAlMenosUnaLetra()  )
			{
				if(partida.siGano(arrayDeLetras)) {
					Controlador_De_Letras controlador_De_Letras = new Controlador_De_Letras(marco);
					controlador_De_Letras.reiniciarJuego();

					marco.get_Texto_Respuesta().setText("¡Bien jugado! Has ganado.");

					partida = new ChequeaLetra(marco.modo_De_Juego);
				}
			}
			partida.usoPista();
		
		} else { 
			JOptionPane.showMessageDialog(null,"Lo siento, no quedan más pistas.");
			marco.getRecibe_Letra().setText("");
		}
	}
	
}
