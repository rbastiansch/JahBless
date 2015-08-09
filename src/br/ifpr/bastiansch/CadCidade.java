package br.ifpr.bastiansch;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CadCidade extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	
	CadEstado Cestado = new CadEstado();
	ComboControl cControl = new ComboControl();
	
	String varNome, varEstado;
	private JComboBox cboxEstado;
	
	static void Click(JComboBox comboBox, String num){ // <-- N�o altere saporra dessa linha vlw flw, deixe comboBox mesmo
		
		
		  String url = "jdbc:mysql://localhost:3306/JBSystem"; // Aqui voc� troca caqui pelo nome do seu banco de dados
		  String usr = "root";
		  String pwd = "ifpr123"; // aqui troca sua senha
		
		
		comboBox.removeAllItems(); // Remove todos os Itens dentro do ComboBox
		
		try {
			String sql = null;
			
			if (num == "uf")
			{
			
			 sql = "SELECT * from uf";
			
			}else if(num == "cidade"){
				 sql = "SELECT * from cidade";
			}
		
		
			Connection conn = (Connection) DriverManager.getConnection( url, usr, pwd ); // faz a conexao com o banco de dados
			Statement sessao = (Statement) conn.createStatement(); // cria uma sess�o 
			ResultSet resposta = sessao.executeQuery( sql ); // executa o comando que esta dentro da String sql
			
			while( resposta.next() ) {
				
				
				String umNome = resposta.getString( "nome" ); // troca o "Nome" pelo seu campo dentro da tabela que voce quer colocar dentro do comboBox
				comboBox.addItem(umNome);// Adiciona um novo item no ComboBox
				
				// E assim fica no While(que � um loop) at� adicionar todos os itens que tem na tabela
				
			}
		} catch( Exception e1 ) {
			JOptionPane.showMessageDialog(null, "Aconteceu um erro \n "+e1 ); // mostra uma mensagem se ouver erro 
		}
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadCidade dialog = new CadCidade();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadCidade() {
		setTitle("Cadastro de Cidades");
		setBounds(100, 100, 237, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNome = new JLabel("Nome:");
			lblNome.setBounds(10, 11, 72, 14);
			contentPanel.add(lblNome);
		}
		
		txtNome = new JTextField();
		txtNome.setBounds(66, 8, 97, 20);
		contentPanel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 36, 72, 14);
		contentPanel.add(lblEstado);
		
		cboxEstado = new JComboBox();
		cboxEstado.setBounds(105, 32, 66, 22);
		contentPanel.add(cboxEstado);
		//Atualizando ComboBox Estado 
		cControl.AtualizaCombo(cboxEstado, "UF");
		
		
		JButton button = new JButton("...");
		button.setBounds(173, 10, 38, 18);
		contentPanel.add(button);
		
		JButton button_1 = new JButton("...");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Foda.show(Cestado);
				
				
			}
		});
		button_1.setBounds(183, 36, 42, 16);
		contentPanel.add(button_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
							
							varNome =  txtNome.getText();
							int fkEstado = cControl.FkRadio(cboxEstado);

							String sql = "INSERT INTO `jbsystem`.`cidade` (`nome`, `UF_idUF`) "
									+ "VALUES "
									+ "('"+varNome+"', '"+fkEstado+"')";

							try {
								Conn.ConectaSql(sql);
								JOptionPane.showMessageDialog(null,
										"Cadastro efetuado com sucesso!");

							} catch (Exception e) {
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
