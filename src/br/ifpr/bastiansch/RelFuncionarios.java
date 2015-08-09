package br.ifpr.bastiansch;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RelFuncionarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
public void capeta() throws SQLException{
		
		String url = "jdbc:mysql://localhost:3306/jbsystem"; 
		String usr = "root";
		String pwd = "ifpr123";
		String sql = "Select clientes.nome,rua, cidade.nome, email  From clientes, endereco, cidade, contato where Cidade_idCidade = idCidade and idContato = Contato_idContato and idEndereco = Endereco_idEndereco;";
			
		Connection conn = (Connection) DriverManager.getConnection( url, usr, pwd ); // faz a conexao com o banco de dados
		Statement sessao = (Statement) conn.createStatement(); // cria uma sessão 
		ResultSet resposta = sessao.executeQuery( sql ); // executa o comando que esta dentro da String sql
		
		textPane.setText("Nome         Rua           Cidade                    Email");
		try {
			
			while( resposta.next() ) {	
				
				 
				String umNome = resposta.getString( "clientes.nome" );
				String umaRua = resposta.getString( "rua" ); 
				String umaCity = resposta.getString( "cidade.nome" );
				String umEmail = resposta.getString("email");
				
				String old = textPane.getText();
				textPane.setText(old+"\n "+umNome+"        "+umaRua+"        "+umaCity+"           "+umEmail);	
			}
		} catch( Exception e1 ) {
			JOptionPane.showMessageDialog(null, "Aconteceu um erro \n "+e1 );
		}
}

	/**
	 * Create the dialog.
	 */
	public RelFuncionarios() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextPane textPane = new JTextPane();
			textPane.setBounds(59, 53, 312, 93);
			contentPanel.add(textPane);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							capeta();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
