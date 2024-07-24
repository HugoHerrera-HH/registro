package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Logica;
import modelo.vo.PersonaVo;
import controlador.Administrador;


public class VentanaBuscar  extends JFrame implements ActionListener {

	/**
	 * 
	 */

	private Administrador miAdministrador; //objeto miCoordinador que permite la relacion entre esta clase y la clase coordinador
	private JLabel labelTitulo;
	private JTextField textCod,textNombre,textEdad,textTelefono,textProfesion;
	private JLabel cod,nombre,edad,telefono,profesion;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscar() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(50, 220, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(190, 250, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(170, 80, 50, 25);
		botonBuscar.setText("Ok");
		
		botonEliminar = new JButton();
		botonEliminar.setBounds(330, 220, 120, 25);
		botonEliminar.setText("Eliminar");
		
		botonModificar = new JButton();
		botonModificar.setBounds(190, 220, 120, 25);
		botonModificar.setText("Modificar");

		labelTitulo = new JLabel();
		labelTitulo.setText("ADMINISTRAR PERSONAS");
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
		
		profesion=new JLabel();
		profesion.setText("profesion");
		profesion.setBounds(20, 160, 80, 25);
		getContentPane().add(profesion);
		
		edad=new JLabel();
		edad.setText("Edad");
		edad.setBounds(290, 120, 80, 25);
		getContentPane().add(edad);
		
		textCod=new JTextField();
		textCod.setBounds(80, 80, 80, 25);
		getContentPane().add(textCod);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 120, 190, 25);
		getContentPane().add(textNombre);

		textTelefono=new JTextField();
		textTelefono.setBounds(340, 160, 80, 25);
		getContentPane().add(textTelefono);
		
		textProfesion=new JTextField();
		textProfesion.setBounds(80, 160, 190, 25);
		getContentPane().add(textProfesion);
		
		textEdad=new JTextField();
		textEdad.setBounds(340, 120, 80, 25);
		getContentPane().add(textEdad);
		
		botonModificar.addActionListener(this);
		botonEliminar.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);

		getContentPane().add(botonCancelar);
		getContentPane().add(botonBuscar);
		getContentPane().add(botonModificar);
		getContentPane().add(botonEliminar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
				
		setSize(480, 320);
		setTitle("registro : Proyecto_JAVA_SQL/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

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

				miAdministrador.modificarPersona(miPersona);
				
				if (Logica.modificaPersona==true) {
					habilita(true, false, false, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			PersonaVo miPersona=miAdministrador.buscarPersona(textCod.getText());
			if (miPersona!=null)
			{
				muestraPersona(miPersona);
			}
			else if(Logica.consultaPersona==true){
				JOptionPane.showMessageDialog(null, "La persona no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			
				
				
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, true, true, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textCod.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"�Esta seguro de eliminar la Persona?", "Confirmaci�n",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					miAdministrador.eliminarPersona(textCod.getText());
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese un numero en el codigo", "Informaci�n",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}



	/**
	 * permite cargar los datos de la persona consultada
	 * @param miPersona
	 */
	private void muestraPersona(PersonaVo miPersona){
		textNombre.setText(miPersona.getNombrePersona());
		textEdad.setText(miPersona.getEdadPersona()+"");
		textTelefono.setText(miPersona.getTelefonoPersona()+"");
		textProfesion.setText(miPersona.getProfesionPersona());
		
		
		habilita(true, false, false, false, false, true, false, true, true);
	}

	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textCod.setText("");
		textNombre.setText("");
		textEdad.setText("");
		textTelefono.setText("");
		textProfesion.setText("");
		habilita(true, false, false, false, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param codigo
	 * @param nombre
	 * @param edad
	 * @param tel
	 * @param profesion
	 * @param cargo
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean codigo, boolean nombre, boolean edad, boolean tel, boolean profesion,	 boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textCod.setEditable(codigo);
		textNombre.setEditable(nombre);
		textEdad.setEditable(edad);
		textTelefono.setEditable(tel);
		textProfesion.setEditable(profesion);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
