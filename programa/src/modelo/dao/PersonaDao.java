package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import controlador.Administrador;
import modelo.conexion.Conexion;
import modelo.vo.PersonaVo;




//clase que permite el acceso a la base de datos 
public class PersonaDao
{

	public void registrarPersona(PersonaVo miPersona)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO persona VALUES ('"+miPersona.getIdPersona()+"', '"
					+miPersona.getNombrePersona()+"', '"+miPersona.getEdadPersona()+"', '"
					+miPersona.getProfesionPersona()+"', '"+miPersona.getTelefonoPersona()+"')");
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Informaci�n",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}
//metodo buscar
	public PersonaVo buscarPersona(int codigo) 
	{
		Conexion conex= new Conexion();
		PersonaVo persona= new PersonaVo();
		boolean existe=false;
		try {
			//Statement estatuto = conex.getConnection().createStatement();
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM persona where id = ? ");
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				persona.setIdPersona(Integer.parseInt(res.getString("id")));
				persona.setNombrePersona(res.getString("nombre"));
				persona.setEdadPersona(Integer.parseInt(res.getString("edad")));
				persona.setProfesionPersona(res.getString("profesion"));
				persona.setTelefonoPersona(Integer.parseInt(res.getString("telefono")));
			 }
			res.close();
			conex.desconectar();
					
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return persona;
			}
			else return null;				
	}
//metodo modificar
	public void modificarPersona(PersonaVo miPersona) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE persona SET id= ? ,nombre = ? , edad=? , profesion=? , telefono= ? WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, miPersona.getIdPersona());
            estatuto.setString(2, miPersona.getNombrePersona());
            estatuto.setInt(3, miPersona.getEdadPersona());
            estatuto.setString(4, miPersona.getProfesionPersona());
            estatuto.setInt(5,miPersona.getTelefonoPersona());
            estatuto.setInt(6, miPersona.getIdPersona());
            estatuto.executeUpdate();

          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmaci�n",JOptionPane.INFORMATION_MESSAGE);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}
//metodo eliminar 
	public void eliminarPersona(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("DELETE FROM persona WHERE id='"+codigo+"'");
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Informaci�n",JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

		 
	}

	
