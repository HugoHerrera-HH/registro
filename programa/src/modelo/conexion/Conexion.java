package modelo.conexion;

import java.sql.*;

import javax.swing.JOptionPane;



public class Conexion {
   static String bd = "registro";
   static String login = "root";
   static String password = "mortadela10";
   static String url = "jdbc:mysql://localhost:3306/"+bd;

   Connection conn = null;

//constructor Conexion
   public Conexion() {
      try{
         //obtenemos el driver de my sql connector-java para mysql
         Class.forName("com.mysql.cj.jdbc.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,login,password);

         if (conn!=null){
            System.out.println("Conexión a base de datos "+bd+" OK");
         }
      }
      catch(SQLException e){
          JOptionPane.showMessageDialog(null,e.getMessage(),"error en la base de datos",JOptionPane.ERROR_MESSAGE );    	  
          System.out.println(e);
      }catch(ClassNotFoundException e){
          JOptionPane.showMessageDialog(null,e.getMessage(),"error en el Driver",JOptionPane.ERROR_MESSAGE );
          System.out.println(e);

      }catch(Exception e){
         System.out.println(e);
      }
   }
   //Permite retornar la conexión
   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
   }

}