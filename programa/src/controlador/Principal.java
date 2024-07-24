package controlador;

import java.io.FileWriter;
import java.io.IOException;

import modelo.Logica;
import modelo.vo.PersonaVo;
import vista.VentanaBuscar;
import vista.VentanaPrincipal;
import vista.VentanaRegistro;

public class Principal {

	Logica miLogica;
	VentanaPrincipal miVentanaPrincipal;
	VentanaBuscar miVentanaBuscar;
	VentanaRegistro miVentanaRegistro;
	Administrador miAdministrador;

	public static void main(String[] args) {
		Principal miPrincipal=new Principal();
		miPrincipal.iniciar();
	
	}

	/**
	 * Permite instanciar todas las clases con las que trabaja
	 * el sistema
	 */
	private void iniciar() {
		/*Se instancian las clases*/
		miVentanaPrincipal=new VentanaPrincipal();
		miVentanaRegistro=new VentanaRegistro();
		miVentanaBuscar= new VentanaBuscar();
		miLogica=new Logica();
		miAdministrador= new Administrador();
	
		/*Se establecen las relaciones entre clases*/
		miVentanaPrincipal.setAdministrador(miAdministrador);
		miVentanaRegistro.setAdministrador(miAdministrador);
		miVentanaBuscar.setAdministrador(miAdministrador);
		miLogica.setAdministrador(miAdministrador);
		
		/*Se establecen relaciones con la clase Administrador*/
		miAdministrador.setMiVentanaPrincipal(miVentanaPrincipal);
		miAdministrador.setMiVentanaRegistro(miVentanaRegistro);
		miAdministrador.setMiVentanaBuscar(miVentanaBuscar);
		miAdministrador.setMiLogica(miLogica);
		
	
		
		miVentanaPrincipal.setVisible(true);
	}

}
