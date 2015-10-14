package br.ifpr.bastiansch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JDialog;

import com.mysql.jdbc.PreparedStatement;

public class Foda {

	public static void p( Object o ){
		
		System.out.println( o );
		
	}
	
	public static void show( JDialog w ){
		
		w.setModal( true );
		w.setLocationRelativeTo(null);
		w.setVisible( true );
		
	}
	
	// pega a FK de uma tabela
	public static int pegaFk(String table) throws SQLException{ 
		String sql = "SELECT MAX(id"+table+") as id"+table+" FROM "+table+""; 
		//PreparedStatement stmt = (PreparedStatement) Conn.conectaMySQL().prepareStatement(sql); 
		Statement stmt = Conn.conectaMySQL().createStatement();
		stmt.executeUpdate( sql, Statement.RETURN_GENERATED_KEYS ); 
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next(); 
		int lastId = rs.getInt("id"+table+""); 

		rs.close(); 
		stmt.close(); 

		return lastId;
		
		} 

	public static int insert( String sql ){
		
		int i = -1;

		try {
			
			Statement stmt = Conn.conectaMySQL().createStatement();
			stmt.executeUpdate( sql, Statement.RETURN_GENERATED_KEYS ); 
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next(); 
			i = rs.getInt( 1 );
			stmt.close();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return i;
		
	}

}
