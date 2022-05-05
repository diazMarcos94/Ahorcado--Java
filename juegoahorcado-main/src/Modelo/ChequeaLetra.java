package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import Vista.*;
public class ChequeaLetra {
	
	private String palabra;
	private char arrayConLetras[];
	private char arrayConGuiones[];

	private Set letrasIngresadas= new HashSet();
	private int vidas = 5;
	
	private boolean acertoAlMenosUnaLetra=false; //sirve para validar si gana
	private String modo_De_Juego;
	
	private String letras_Recibidas="";
	private int numero_De_Pistas= 1;
	
	
	
	
	
	public ChequeaLetra(String modo) {
		
		this.modo_De_Juego = modo;
		
		//--CREO ARRAYS INICIALES
		palabra = elegirPalabra();
		arrayConLetras = new char[palabra.length()];
		arrayConGuiones = new char[palabra.length()];
		
		for(int i= palabra.length(); i>=1; i--) {
			arrayConLetras[i-1] = palabra.charAt(i-1);
			arrayConGuiones[i-1] = '-';
		}

		
		
	}
	
	
//------------------------------------------------------------------------------	
	public String elegirPalabra() {
		
		try {
			
			//Uso File Reader para leer el archivo.
			
			FileReader entrada;

			if(this.modo_De_Juego.equals("Espanol") || this.modo_De_Juego.equals("Dificil") || this.modo_De_Juego.equals("Ingles"))
			{
				if(this.modo_De_Juego.equals("Espanol")) 
					entrada= new FileReader("palabras.txt");
				else if(this.modo_De_Juego.equals("Dificil")) 
					entrada= new FileReader("palabras_dificiles.txt");
				else 
					entrada= new FileReader("palabras_ingles.txt");
				
		
				BufferedReader mibuffer= new BufferedReader(entrada);
					
				String linea="";
				
				int posicionAleatoria = (int)Math.floor(Math.random()*(100));
				
				boolean encontrePalabra= false;
			
				int i= 0;
				
				while(!encontrePalabra) {
						
					linea= mibuffer.readLine();
						
					if( i == posicionAleatoria) {
						encontrePalabra= true;
					}
					
					else
						i++;
				}
			
				return linea != null? linea.toUpperCase(): "";
				
			} else
				return this.modo_De_Juego.toUpperCase();	
			
        } catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
        }
		return "";
	}
	
	
	
//------------------------------------------------------------------------------
	//--DEVUELVE EL ARRAY CON GUIONES QUE SE MUESTRA POR PANTALLA, AUNQUE COMPARA CADA UNO
	//CON LA LETRA INGRESADA. EN CASO DE COINCIDIR LO REEMPLAZA.
	public char[] validarLetra(char letraRecibida) {	
		
		boolean acierto_De_letra= false;
		
		agregarLetraIngresadaALista(letraRecibida);
		//-- Recorro el array de las letras de mi palabra, y comparo cada letra
		//con la letra recibida. En caso de que coincida la letra, reemplazo dentro
		//del array que muestra los guiones en pantalla la posicion donde coincide la letra.
		
		for(int posicionLetra= arrayConLetras.length; posicionLetra>=1; posicionLetra--) 
		{
			if(letraRecibida == arrayConLetras[posicionLetra-1]) {
				arrayConGuiones[posicionLetra-1] = letraRecibida;
				acierto_De_letra= true;
				acertoAlMenosUnaLetra= true;
			}
		}
		if(!acierto_De_letra)
			vidas-= 1;
		
		
		//CASO DE PERDER DEVUELVO TODOS GUIONES
		if(vidas < 1) 
		{	
			for (char c : arrayConGuiones)
				c = '-';	
			return arrayConGuiones;
		}
		return arrayConGuiones;
	}
	
	
//------------------------------------------------------------------------------	
	public void agregarLetraIngresadaALista (char letraRecibida) {
		char letra= Character.toUpperCase(letraRecibida); //-- Recibo la letra del usuario
		letrasIngresadas.add(letra); //--GUARDO LETRA EN ARRAY LETRAS UTILIZADAS
	}
	
	
	
//------------------------------------------------------------------------------	
	public boolean validarLetraRepetida(char c, String letras) {
		
		for (int i=0 ; i < letras.length() ; i++)
		{
			if (letras.charAt(i) == c)
			{
				return true;
			}
		}
		
		return false;
	}

	
//------------------------------------------------------------------------------	
	public String actualizarPantalla(char[] array_de_letras)
	{
		String cantidadGuionesSegunCantidadLetras = "";
		
		for( char letra : array_de_letras)
		{
			cantidadGuionesSegunCantidadLetras += letra + "  ";	
		}
		return cantidadGuionesSegunCantidadLetras;
	}

	
//------------------------------------------------------------------------------
	public boolean siGano(char[] array_de_letras)
	{
		boolean gano= true;
		
		for( char letra : array_de_letras)
		{
			 if(letra == '-')
				 gano=false;
		}
		return gano;
	}
		
//------------------------------------------------------------------------------
	
	public char eleccionDeLetraDePc(int contador, char[]vocales, char[]consonantes, char[]todas) {
		
		char letra=' ';
		
		if (contador < 2)
		{
			int letraAleatoria = (int) (Math.random()*5);
			
			letra= vocales[letraAleatoria];
					
		}
		else if(contador < 5 && contador >= 2)
		{
			int letraAleatoria = (int) (Math.random()*8);
			
			letra= consonantes[letraAleatoria];	
			
		}
		else
		{
			int letraAleatoria = (int) (Math.random()*26);
			
			letra= todas[letraAleatoria];
					
		}
		
		return letra;
		
	}
	
	

//------------------------------------------------------------------------------
public void usoPista()
{
	numero_De_Pistas --;
}
//------------------------------------------------------------------------------	
	public int getVidas() {
		return vidas;
	}

	public char[] getArrayConGuiones() {
		return arrayConGuiones;
	}
	
	public char[] getArrayConLetras() {
		return arrayConLetras;
	}

	public String getPalabra() {
		return palabra;
	}

	public boolean getAcertoAlMenosUnaLetra() {
		return acertoAlMenosUnaLetra;
	}
	
	public String getLetras_recibidas() {
		return letras_Recibidas;
	}
	
	public void setLetras_recibidas(String s) {
		letras_Recibidas= s;
	}
	
	public int getNumero_De_Pistas() {
		return numero_De_Pistas;
	}


}
