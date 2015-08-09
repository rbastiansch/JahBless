package br.ifpr.bastiansch;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;


public class ComboBox extends JComboBox<Item>{

	private String query;
	
	public ComboBox( String whichQuery ){ // select com ordem id e nome
		
		super();
		query = whichQuery;
		atualizeItens();
		
	}
	
	public void atualizeItens(){
		
		removeAllItems();
		ResultSet rs = Conn.consulta( query ); //  CHAME SUA FUNÇÃO DE CONSULTA AQUI 
		
		try {
			
			while( rs.next() ){
				
				addItem( new Item( rs.getInt(1), rs.getString(2) ) );
				
			}
			
		} catch (SQLException e) {
			
			//debug JOptionPane.showMessageDialog( null, "Erro na consulta de construção do ComboBox \n" + e.getMessage() );
			
		}
		
	}
	
	public void selectItemById( int id ){
		
		for( int i = 0; i < getItemCount(); i++ ){
			
			if( getItemAt( i ).getId() == id ){
				
				setSelectedIndex( i );
				
			}
			
		}
		
	}
	
	public int getSelectedItemId(){

		//if( getSelectedIndex() < 0 ) return -1; // Caso o ComboBox for Editavel, descomente essa linha
		return ( (Item) getSelectedItem() ).getId();
		
	}

}

class Item {
	
	private int id;
	private String nome;
	
	public Item( int whichId, String whichName ){
		
		id = whichId;
		nome = whichName;
		
	}
	
	public int getId(){
		
		return id;
		
	}
	
	public String getName(){
		
		return nome;
		
	}
	
	@Override
	public String toString(){
		
		return nome;
		
	}

}