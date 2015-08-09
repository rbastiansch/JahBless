package br.ifpr.bastiansch;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import com.mysql.jdbc.PreparedStatement;

public class ComboControl {
	
	Conn Con = new Conn();
	 
	//Get FK ComboBox and return
	public int FkRadio(JComboBox<?> comboBox){ 
		
		comboModel combo = (comboModel) comboBox.getSelectedItem();  
		return comboModel.id;
		
	}
	
	public static void AtualizaCombo(JComboBox<comboModel> comboBox, String tabela){
		
		try{
			ResultSet rs = Conn.consulta("SELECT * from "+tabela);
			
			while(rs.next()){
				//Creating object 
				int id = rs.getInt( 1 );  
		        String nome = rs.getString("Nome");  
		        comboBox.addItem(new comboModel(id,nome));
				
			}
			
		}catch (SQLException e) {
			
			throw new RuntimeException(e);
        
		}
	}

}
