package Vista;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Controller.Controlador_Juego_AlReves;
import Controller.Controlador_Jugar_OtraVez;
import Controller.Controlador_Letra_AlReves;

public class MarcoReves extends JFrame{
	
	private Controlador_Juego_AlReves inicio;
	private Controlador_Letra_AlReves contLetra;
	private JFrame frame;
	private JLabel palabra_Usuario;
	private JLabel palabra;
	private JLabel muestra_Letra_Pc;
	private JLabel muestra_Todas_Letras_Pc;
	private JButton siguiente_Letra;
	private String palabra_recibida;
	private JLabel vidas_Restantes;
	private JLabel texto_Letra_Ingresada_Por_Pc;
	private JLabel texto_Resultado_Del_Juego;
	private JButton jugar_Otra_Vez;
	
	public MarcoReves(String p)
	{
		this.palabra_recibida= p;
		inicio = new Controlador_Juego_AlReves(this);
		contLetra = new Controlador_Letra_AlReves(this);
	}
	
	
	public void initialize() 
	{
		
		//--Inicializo Marco
		frame = new JFrame();
		frame.getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
			}
		});
		frame.setVisible(true);
		//--Posicionamiento, ancho, alto, terminar el programa al cerrar y sin Layout.
		frame.setSize(500,500);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		
		//----------------PALABRA DEL USUARIO -------------------------
		palabra_Usuario = new JLabel("");
		palabra_Usuario.setBounds(200, 100, 150, 23);
		frame.getContentPane().add(palabra_Usuario);
		
		//----------------PALABRA EN PANTALLA------------------------
		palabra = new JLabel("");
		palabra.setBounds(200, 180, 200, 42);
		frame.getContentPane().add(palabra);
		
		//----------------TEXTO LETRA INGRESADA POR LA PC------------------------		
		texto_Letra_Ingresada_Por_Pc = new JLabel("Letra ingresada por la pc: ");
		texto_Letra_Ingresada_Por_Pc.setBounds(70, 270, 180, 14);
		frame.getContentPane().add(texto_Letra_Ingresada_Por_Pc);
		
		//---------------- LETRA DE LA MAQUINA------------------------		
		muestra_Letra_Pc = new JLabel("");
		muestra_Letra_Pc.setBounds(250, 270, 121, 14);
		frame.getContentPane().add(muestra_Letra_Pc);
		
		//---------------- LETRAS TOTALES DE LA MAQUINA------------------------		
		muestra_Todas_Letras_Pc = new JLabel("");
		muestra_Todas_Letras_Pc.setBounds(200, 300, 121, 14);
		frame.getContentPane().add(muestra_Todas_Letras_Pc);
		
		//----------------BOTON SIGUIENTE-------------------------
		siguiente_Letra = new JButton("Siguiente");
		siguiente_Letra.setBounds(195, 225, 89, 23);
		siguiente_Letra.addMouseListener(contLetra);
		frame.getContentPane().add(siguiente_Letra);
		
		//---------------- TEXTO INTENTOS RESTANTES------------------------		
		vidas_Restantes = new JLabel("Intentos restantes: 5");
		vidas_Restantes.setBounds(200, 325, 200, 14);
		frame.getContentPane().add(vidas_Restantes);
		
		//---------------- TEXTO RESULTADO DEL JUEGO------------------------		
		texto_Resultado_Del_Juego = new JLabel(" ");
		texto_Resultado_Del_Juego.setBounds(150, 300, 260, 14);
		texto_Resultado_Del_Juego.setVisible(false);
		frame.getContentPane().add(texto_Resultado_Del_Juego);
		
		//----------------BOTON JUGAR OTRA VEZ-------------------------
		jugar_Otra_Vez = new JButton("Jugar otra vez");
		jugar_Otra_Vez.setBounds(200, 325, 120, 23);
		jugar_Otra_Vez.addMouseListener(new Controlador_Jugar_OtraVez(this));
		jugar_Otra_Vez.setVisible(false);
		frame.getContentPane().add(jugar_Otra_Vez);
		
		
		//---------PONGO EL MARCO A LA ESCUCHA DE EVENTOS------
		frame.addWindowListener(inicio);
	}


	public JLabel getPalabra_Usuario() {
		return palabra_Usuario;
	}

	public JLabel getPalabra() {
		return palabra;
	}

	public JLabel getMuestra_Letra_Pc() {
		return muestra_Letra_Pc;
	}

	public JLabel getMuestra_Todas_Letras_Pc() {
		return muestra_Todas_Letras_Pc;
	}


	public JButton getSiguiente_Letra() {
		return siguiente_Letra;
	}


	public Controlador_Juego_AlReves getInicio() {
		return inicio;
	}


	public JLabel getVidasRestantes() {
		return vidas_Restantes;
	}

	public JLabel getTexto_Letra_Ingresada_Por_Pc() {
		return texto_Letra_Ingresada_Por_Pc;
	}
	
	public JLabel getTexto_Resultado_Del_Juego() {
		return texto_Resultado_Del_Juego;
	}
	
	public JButton getJugar_Otra_Vez() {
		return jugar_Otra_Vez;
	}


	public String getPalabra_recibida() {
		return palabra_recibida;
	}

	
}
