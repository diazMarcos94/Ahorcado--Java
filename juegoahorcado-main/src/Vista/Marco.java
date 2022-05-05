package Vista;


import javax.swing.*;

import Controller.*;
import Modelo.ChequeaLetra;


import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Marco extends JFrame{

	private JFrame frame;
	private JTextField recibe_Letra;
	private JLabel palabra_En_Pantalla;
	private JLabel texto_Intentos_Restantes;
	private JLabel texto_Letras_Ya_Ingresadas;
	private JLabel letras_Ya_Ingresadas;
	private JLabel texto_Juego_Terminado;
	private JLabel texto_Respuesta;
	private JButton envia_Letra;
	private JButton jugar_Otra_Vez;
	private Controlador_De_Letras contLetras;
    private Controlador_Inicial inicio;
    private ChequeaLetra cheqLetra;
    private JButton dame_Una_Pista;
    private JButton menuPrincipal;
   
    
    public String modo_De_Juego;


	/**
	 * Create the application.
	 */
	public Marco(String modo) {
		
		this.modo_De_Juego = modo;
		
		this.inicio = new Controlador_Inicial(this);
		
		this.contLetras = new Controlador_De_Letras(this);
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void initialize() {
		
		//--Inicializo Marco
		
		this.frame = new JFrame();
		
		this.frame.getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			}
		});
			
		//--Posicionamiento, ancho, alto, terminar el programa al cerrar y sin Layout.
		frame.setSize(500,500);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
//----------------TEXTO PALABRA A ADIVINAR-------------------------
		JLabel texto_Palabra_A_Adivinar = new JLabel("Palabra a adivinar:");
		texto_Palabra_A_Adivinar.setBounds(155, 44, 150, 23);
		frame.getContentPane().add(texto_Palabra_A_Adivinar);
		
//----------------RECIBO LA LETRA------------------------
		recibe_Letra = new JTextField();	
		recibe_Letra.setBounds(80, 204, 35, 35);
		frame.getContentPane().add(recibe_Letra);
		recibe_Letra.setColumns(10);
		
//----------------PALABRA EN PANTALLA----------------------
		palabra_En_Pantalla = new JLabel("");
		palabra_En_Pantalla.setBounds(150, 80, 300, 42);
		frame.getContentPane().add(palabra_En_Pantalla);
		
//----------------TEXTO INGRESE LETRA------------------------		
		JLabel texto_Ingrese_Una_Letra = new JLabel("Ingrese una letra:");
		texto_Ingrese_Una_Letra.setBounds(70, 109, 155, 144);
		frame.getContentPane().add(texto_Ingrese_Una_Letra);

//----------------BOTON ENVIAR-------------------------
		envia_Letra = new JButton("Enviar");
		envia_Letra.addMouseListener(contLetras);
		envia_Letra.setBounds(116, 205, 89, 35);
		frame.getContentPane().add(envia_Letra);
		
//----------------BOTON PISTA-------------------------
		dame_Una_Pista = new JButton("Pista");
		dame_Una_Pista.addMouseListener(new Controlador_Pista(this));
		dame_Una_Pista.setBounds(100, 245, 89, 35);
		frame.getContentPane().add(dame_Una_Pista);		
	
		
//----------------BOTON JUGAR OTRA VEZ-------------------------
		jugar_Otra_Vez = new JButton("Jugar otra vez");
		jugar_Otra_Vez.addMouseListener(new Controlador_Jugar_OtraVez(this));
		jugar_Otra_Vez.setBounds(40, 390, 199, 35);
		jugar_Otra_Vez.setVisible(false);
		frame.getContentPane().add(jugar_Otra_Vez);
		
//----------------TEXTO INTENTOS RESTANTES------------------------	
		texto_Intentos_Restantes = new JLabel("Intentos restantes:");
		texto_Intentos_Restantes.setBounds(200, 300, 150, 14);
		frame.getContentPane().add(texto_Intentos_Restantes);

//----------------TEXTO LETRAS RECIBIDAS------------------------			
		texto_Letras_Ya_Ingresadas = new JLabel("Letras ya ingresadas:");
		texto_Letras_Ya_Ingresadas.setBounds(300, 173, 155, 14);
		frame.getContentPane().add(texto_Letras_Ya_Ingresadas);
		
//----------------LETRAS RECIBIDAS EN PANTALLA ------------------------			
		letras_Ya_Ingresadas = new JLabel("");
		letras_Ya_Ingresadas.setBounds(300, 203, 150, 14);
		frame.getContentPane().add(letras_Ya_Ingresadas);
		
//----------------TEXTO JUEGO TERMINADO------------------------	
		texto_Juego_Terminado = new JLabel("Juego terminado");
		texto_Juego_Terminado.setBounds(185, 300, 300, 14);
		frame.getContentPane().add(texto_Juego_Terminado);
		texto_Juego_Terminado.setVisible(false);
		
//--------------BOTON MENU PRINCIPAL----------------------
		menuPrincipal = new JButton("Menú principal");
		menuPrincipal.addMouseListener(new ControladorVentana(this));
		menuPrincipal.setVisible(false);
		menuPrincipal.setBounds(260, 390, 199, 35);
		frame.getContentPane().add(menuPrincipal);
		
		
		
//---------------- TEXTO RESPUESTA DE JUEGO------------------------	
		texto_Respuesta = new JLabel("");
		texto_Respuesta.setBounds(170, 330, 400, 14);
		frame.getContentPane().add(texto_Respuesta);
		texto_Respuesta.setVisible(false);

		
		frame.setVisible(true);
		
		//---------PONGO EL MARCO A LA ESCUCHA DE EVENTOS------
		frame.addWindowListener(inicio);
	}
	

	public JTextField getRecibe_Letra() {
		return recibe_Letra;
	}
	
	public JLabel getPalabra_En_Pantalla() {
		return palabra_En_Pantalla;
	}

	public JLabel getTexto_Intentos_Restantes() {
		return texto_Intentos_Restantes;
	}


	public Controlador_Inicial getInicio() {
		return inicio;
	}

	public ChequeaLetra getCheqLetra() {
		return cheqLetra;
	}

	public JLabel getLetras_Ya_Ingresadas() {
		return letras_Ya_Ingresadas;
	}

	public JLabel get_Texto_Respuesta() {
		return texto_Respuesta;
	}

	public JLabel getTexto_Juego_Terminado() {
		return texto_Juego_Terminado;
	}


	public JButton getEnvia_Letra() {
		return envia_Letra;
	}

	public JButton getJugar_Otra_Vez() {
		return jugar_Otra_Vez;
	}
	
	public JButton getDame_Una_Pista() {
		return dame_Una_Pista;
	}
	
	public JButton getMenuPrincipal() {
		return menuPrincipal;
	}





	
	
	

	
}
