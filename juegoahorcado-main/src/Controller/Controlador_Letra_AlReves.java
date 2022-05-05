package Controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Modelo.ChequeaLetra;
import Vista.MarcoReves;

public class Controlador_Letra_AlReves extends MouseAdapter{
	private MarcoReves marco;
	private ChequeaLetra partida;
	private String letras_recibidas=" ";
	private char[] vocales= {'a' ,'e', 'i', 'o', 'u'};
	private char[] consonantes_Mas_Usadas= {'r' ,'m', 'n', 't', 's', 'l','p','c'};
	private char[] todas= {'a' ,'b', 'c', 'd', 'e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private int contadorDeLetras= 0;


 	
	public Controlador_Letra_AlReves(MarcoReves marco) 
	{
		this.marco= marco;
		partida = marco.getInicio().getPartida();
	}

	
	
	
	
	
	
	
	//Quiero que primero elija al azar 2 vocales. Luego dos Consonantes mas usadas. Luego cualquier letra-
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
		char letra= ' ';
		
		//ELEGIR LETRA Y VALIDAR SI ES REPETIDA
		while(partida.validarLetraRepetida(letra, letras_recibidas)) {
			letra= partida.eleccionDeLetraDePc(contadorDeLetras, vocales, consonantes_Mas_Usadas, todas);
			letra= Character.toUpperCase(letra);
		}	
		
		//SUMO CANTIDAD DE LETRAS ELEGIDAS QUE LLEVA LA PC
		contadorDeLetras++;
		
		
		//MUESTRO LA LETRA INGRESADA POR LA PC
		marco.getMuestra_Letra_Pc().setText(letra+""); //INDIVIDUALMENTE
		this.letras_recibidas+= letra;
		marco.getMuestra_Todas_Letras_Pc().setText(letras_recibidas);//CONJUNTO DE LETRAS
		
		//VALIDAR LETRA SI ES CORRECTA
		char arrayDeLetras[]= partida.validarLetra(letra);
		
//	 	VALIDAR SI PERDIO
		if(partida.getVidas() < 1) 
		{
			marco.getTexto_Resultado_Del_Juego().setText("Has ganado, la PC no ha adivinado!");
			reiniciarJuego();
		}
		
		
//    	VALIDAR SI GANO
		if(partida.getAcertoAlMenosUnaLetra() )
		{
			if(partida.siGano(arrayDeLetras)) 
			{
				marco.getTexto_Resultado_Del_Juego().setText("Lo siento has perdido! La PC ha adivinado.");
				reiniciarJuego();
			}
		}
		
		//--ACTUALIZAR PANTALLA SEGUN LETRA RECIBIDA
		String cantidadGuionesSegunCantidadLetras = partida.actualizarPantalla(arrayDeLetras);
		marco.getPalabra().setText(cantidadGuionesSegunCantidadLetras);
		
		//--MOSTRAR INTENTOS RESTANTES
		marco.getVidasRestantes().setText("Intentos restantes: " + partida.getVidas());
	}
		
	public void reiniciarJuego() 
	{
			marco.getSiguiente_Letra().setEnabled(false);
			marco.getPalabra().setEnabled(false);
			marco.getTexto_Letra_Ingresada_Por_Pc().setVisible(false);
			marco.getMuestra_Letra_Pc().setVisible(false);
			marco.getMuestra_Todas_Letras_Pc().setVisible(false);
			marco.getVidasRestantes().setVisible(false);
			marco.getTexto_Resultado_Del_Juego().setVisible(true);
			marco.getJugar_Otra_Vez().setVisible(true);
			
	}	
	
	
	
	
	
	
	
	
	
	
}
