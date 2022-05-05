package Vista;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Ventana extends JFrame {

	private JPanel panel;
	private JButton play = new JButton("JUGAR");
	private JButton dificil = new JButton("MODO DIFICIL");
	private JButton lenguaje = new JButton("CAMBIAR LENGUAJE");
	private JButton exit = new JButton("SALIR");
	private JButton juegoAlReves = new JButton("JUEGO AL REVES");
	
	public Ventana() {
		this.panel = new JPanel();
		this.setSize(700,600);//tamaño de la ventana
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("PROGRAMACION 3 - AHORCADO"); //Titulo de la ventana
		this.setLocationRelativeTo(null); //se establece la ventana en el centro de la pantalla
		this.setResizable(false); //no permite agrandar la pantalla
		iniciarComponente();
	
	}
	
	private void iniciarComponente() {
		this.getContentPane().add(panel); // agregamos el panel a la ventana
		this.panel.setLayout(null);
		colocarBotones();
	}

	private void colocarBotones() {
	
		play.setBounds(410,150,170,40);
		play.setFont(new Font("arial",Font.BOLD,12));
		play.setBackground(Color.WHITE);
		play.addActionListener(accion);
		panel.add(play);
		
		
		lenguaje.setBounds(410,220,170,40);
		lenguaje.setFont(new Font("arial",Font.BOLD,12));
		lenguaje.setBackground(Color.WHITE);
		lenguaje.addActionListener(accion);
		panel.add(lenguaje);
		
		
		dificil.setBounds(410,290,170,40);
		dificil.setFont(new Font("arial",Font.BOLD,12));
		dificil.setBackground(Color.WHITE);
		dificil.addActionListener(accion);
		panel.add(dificil);
		
		juegoAlReves.setBounds(410,360,170,40);
		juegoAlReves.setFont(new Font("arial",Font.BOLD,12));
		juegoAlReves.setBackground(Color.WHITE);
		juegoAlReves.addActionListener(accion);
		panel.add(juegoAlReves);
		
		exit.setBounds(410,430,170,40);
		exit.setFont(new Font("arial",Font.BOLD,12));
		exit.setBackground(Color.WHITE);
		exit.addActionListener(accion);
		panel.add(exit);
		
		

	
	}
	
	ActionListener accion= new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == play) {
				Marco m = new Marco("Espanol");
				m.initialize();
				setVisible(false);
				
			}
			if(e.getSource()== lenguaje) {
				Marco m = new Marco("Ingles");
				m.initialize();
				setVisible(false);
			}
			if(e.getSource() == dificil) {
				Marco m = new Marco("Dificil");
				m.initialize();
				setVisible(false);
		
			}
			
			if(e.getSource() == juegoAlReves) {
				JOptionPane pregunta_Palabra= new JOptionPane();
				String palabra_Usuario= pregunta_Palabra.showInputDialog("Ingrese palabra");
				MarcoReves m = new MarcoReves(palabra_Usuario);
				m.initialize();
				setVisible(false);
		
			}
			
			if(e.getSource()==exit) {
				setVisible(false);
			}
		}
	};
	

		//imagen de fondo
	public void paint (Graphics g) {
		Dimension tam = getSize();
		ImageIcon imagenFondo= new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/fondo.jpg")).getImage());
		g.drawImage(imagenFondo.getImage(), 0,0,getWidth(),getHeight(),this);
	}

}
