package Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
 
public class Conection  {
	
 	
public Connection conectar() {
	 Connection conexion=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String user = "root";
		String pass = "1234";
		String host ="localhost";
		String port ="3306";
		String db ="prueba";
		String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?user=" + user + "&password=" + pass + "&useSSL=false";
		System.out.println("Inicio");
		conexion = DriverManager.getConnection(url);
				
		
		System.out.println("Nos conectamos");
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("Error en controlador");
		e.printStackTrace();
	}catch (SQLException e) {
		System.out.println("Error con conexión");
		e.printStackTrace();
	}
	return conexion;
}
public void insertar(String varDNI1,String varNombre1,String varFono1,String varContact1) {
	
	Conection con = new Conection();
	Integer ID = validarID();
	String query ="insert into prueba.usuario values ('"+ID+"','"+varDNI1+"','"+varNombre1+"','"+varFono1+"','"+varContact1+"')";
			
			try {
				Connection conexion = con.conectar();
				
				Statement st = conexion.createStatement();
				
			
				
				st.executeUpdate(query);
				
			st.close();	
				
			} catch (Exception e) {
				System.out.println("error insertar: "+e);			}
	
}
public Integer validarID() {
	
	Conection con = new Conection();
	Integer UsuarioId=0;

	String query ="select max(idusuario) val from PRUEBA.usuario";
				
			try {
				Connection conexion = con.conectar();
				
				Statement st = conexion.createStatement();
				ResultSet values1 = st.executeQuery(query);
				values1.beforeFirst();
				values1.next();
				UsuarioId=values1.getInt(1)+1;
				System.out.println(UsuarioId);
				
				
		     	st.close();	
				
			} catch (Exception e) {
				System.out.println("error ValidarID"+e);
			}
			return UsuarioId;
	
}
}
