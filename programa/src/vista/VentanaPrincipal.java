package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import controlador.Administrador;
import javax.swing.ImageIcon;
import java.awt.Color;

public class VentanaPrincipal extends JFrame implements ActionListener{


	private Administrador miAdministrador; //objeto miAdministardor quepermite la relacion entre esta clase yla clase Administrador
	private JTextArea areaIntroduccion;
	private JLabel labelTitulo, labelSeleccion;
	private JButton botonRegistrar,botonBuscar;
	

	//constructor de la clase donde se inicializan todos los componentes
	 // de la ventana principal
	public VentanaPrincipal() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		botonRegistrar = new JButton();
		botonRegistrar.setBounds(99, 264, 120, 25);
		botonRegistrar.setText("Registrar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(239, 264, 120, 25);
		botonBuscar.setText("Buscar");

		labelTitulo = new JLabel();
		labelTitulo.setForeground(Color.GREEN);
		labelTitulo.setText("PROGRAMA REGISTRO PERSONAS ");
		labelTitulo.setBounds(80, 12, 342, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));
		

		labelSeleccion = new JLabel();
		labelSeleccion.setText("Escoja que operacion desea realizar");
		labelSeleccion.setBounds(120, 218, 237, 25);

	

		areaIntroduccion = new JTextArea();
		areaIntroduccion.setBounds(99, 217, 255, 30);
		areaIntroduccion.setEditable(false);
		areaIntroduccion.setFont(new java.awt.Font("Verdana", 0, 14));
		areaIntroduccion.setLineWrap(true);
		areaIntroduccion.setWrapStyleWord(true);
		areaIntroduccion.setBorder(javax.swing.BorderFactory.createBevelBorder(
				javax.swing.border.BevelBorder.LOWERED, null, null, null,
				new java.awt.Color(0, 0, 0)));

		botonRegistrar.addActionListener(this);
		botonBuscar.addActionListener(this);
		getContentPane().add(botonBuscar);
		getContentPane().add(botonRegistrar);
		getContentPane().add(labelSeleccion);
		getContentPane().add(labelTitulo);
		getContentPane().add(areaIntroduccion);
	
		setSize(480, 350);
		setTitle("registro : Proyecto_JAVA_SQL/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\57319\\OneDrive - Universidad Libre\\Desktop\\imagenes de java eclipse\\tramadores.jpeg"));
		lblNewLabel.setBounds(110, 53, 250, 154);
		getContentPane().add(lblNewLabel);

	}


	public void setAdministrador(Administrador miAdministrador) {
		this.miAdministrador=miAdministrador;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonRegistrar) {
			miAdministrador.mostrarVentanaRegistro();			
		}
		if (e.getSource()==botonBuscar) {
			miAdministrador.mostrarVentanaConsulta();			
		}
	}
}
