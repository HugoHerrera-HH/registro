package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.vo.PersonaVo;

import controlador.Administrador;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.Color;
import java.awt.TextArea;


public class VentanaRegistro extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private Administrador miAdministrador; //objeto miCoordinador que permite la relacion entre esta clase y la clase coordinador
	private JLabel labelTitulo;
	private JTextField textCod,textNombre,textEdad,textTelefono,textProfesion;
	private JLabel cod,nombre,edad,telefono,profesion;
	private JButton botonGuardar,botonCancelar;
	private JButton botonMostrar;
	private JButton botonEscribir;
	private JTextArea textArea;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistro() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE PERSONAS");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		cod=new JLabel();
		cod.setText("Codigo");
		cod.setBounds(20, 80, 80, 25);
		getContentPane().add(cod);
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(20, 120, 80, 25);
		getContentPane().add(nombre);

		telefono=new JLabel();
		telefono.setText("telefono");
		telefono.setBounds(290, 160, 80, 25);
		getContentPane().add(telefono);
		
		edad=new JLabel();
		edad.setText("Edad");
		edad.setBounds(290, 120, 80, 25);
		getContentPane().add(edad);
		
		profesion=new JLabel();
		profesion.setText("Profesion");
		profesion.setBounds(20, 160, 80, 25);
		getContentPane().add(profesion);
		
		textCod=new JTextField();
		textCod.setBounds(80, 80, 80, 25);
		getContentPane().add(textCod);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 120, 190, 25);
		getContentPane().add(textNombre);

		textTelefono=new JTextField();
		textTelefono.setBounds(340, 160, 80, 25);
		getContentPane().add(textTelefono);
		
		textEdad=new JTextField();
		textEdad.setBounds(340, 120, 80, 25);
		getContentPane().add(textEdad);
		
		textProfesion=new JTextField();
		textProfesion.setBounds(80, 160, 190, 25);
		getContentPane().add(textProfesion);
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
		setSize(498, 431);
		setTitle("registro : Proyecto_JAVA_SQL/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		botonMostrar = new JButton("Mostrar Informaci\u00F3n");
		botonMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String codigo = textCod.getText();
			String nombre = textNombre.getText();
			String edad = textEdad.getText();
			String telefono = textTelefono.getText();
			String profesion = textProfesion.getText();
			textArea.setText("Codigo:"+codigo+"\n"+"Nombre:"+nombre+"\n"+"Edad:"+edad+"\n"+"Telefono:"+telefono+"\n"+"profesion:"+profesion);
			
			}
		});
		botonMostrar.setBounds(20, 270, 150, 25);
		getContentPane().add(botonMostrar);
		
		botonEscribir = new JButton("Escribir en el Fichero");
		botonEscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String codigo = textCod.getText();
				String nombre = textNombre.getText();
				String edad = textEdad.getText();
				String telefono = textTelefono.getText();
				String profesion = textProfesion.getText();
				textArea.setText("Codigo:"+codigo+"Nombre:"+nombre+"Edad:"+edad+"Telefono:"+telefono+"Profesion:"+profesion);
				String pasareltextarea=textArea.getText();
				File fichero= new File("archivo.txt");
				try {
				BufferedWriter fichero2=new BufferedWriter(new FileWriter(fichero));
						fichero2.append("codigo"+codigo);
						fichero2.newLine();
						fichero2.append("Nombre"+nombre);
						fichero2.newLine();
						fichero2.append("Edad"+edad);
						fichero2.newLine();
						fichero2.append("Telefono"+telefono);
						fichero2.newLine();
						fichero2.append("Profesion"+profesion);
						fichero2.newLine();
						fichero2.append("El text Area"+pasareltextarea);
						fichero2.newLine();
						fichero2.close();
				}catch(IOException ex) {
					Logger.getLogger(VentanaRegistro.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
		botonEscribir.setBounds(20, 306, 150, 25);
		getContentPane().add(botonEscribir);
		
		textArea = new JTextArea();
		textArea.setBounds(180, 251, 263, 127);
		
		getContentPane().add(textArea);

	}


	private void limpiar() 
	{
		textCod.setText("");
		textNombre.setText("");
		textEdad.setText("");
		textTelefono.setText("");
		textProfesion.setText("");
	}


	public void setAdministrador(Administrador miAdministrador) {
		this.miAdministrador=miAdministrador;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				PersonaVo miPersona=new PersonaVo();
				miPersona.setIdPersona(Integer.parseInt(textCod.getText()));
				miPersona.setNombrePersona(textNombre.getText());
				miPersona.setTelefonoPersona(Integer.parseInt(textTelefono.getText()));
				miPersona.setEdadPersona(Integer.parseInt(textEdad.getText()));
				miPersona.setProfesionPersona(textProfesion.getText());
				
				miAdministrador.registrarPersona(miPersona);	
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
	}
}
