package br.ifpr.bastiansch;

public class comboModel {

	public static int id;
	   public String nome; 
	   
	   public comboModel(int id,String nome){  
	       this.id = id;  
	       this.nome = nome;  
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
