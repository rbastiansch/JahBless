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
import java.sql.SQLException;

public class CadFuncionarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtEmail;
	
	CadCidade cCid = new CadCidade();
	private JComboBox comboBoxCidade;
	private JComboBox comboBoxEstado;
	
	ComboControl cControl = new ComboControl();
	private JTextField txtBairro;
	private JTextField txtCEP;

	/**
	 * Launch the application.
	 */
	/*static void Click(JComboBox comboBox){ // <-- N�o altere saporra dessa linha vlw flw, deixe comboBox mesmo
		
		
		  String url = "jdbc:mysql://localhost:3306/jbsystem"; // Aqui voc� troca caqui pelo nome do seu banco de dados
		  String usr = "root";
		  String pwd = "ifpr123"; // aqui troca sua senha
		
		
		comboBox.removeAllItems(); // Remove todos os Itens dentro do ComboBox
		
		try {
			
			String sql = "SELECT * from cidade"; // em grupos_produtos, coloque a tabela que quer pegar os nomes para preencher o comboBox 
			Connection conn = (Connection) DriverManager.getConnection( url, usr, pwd ); // faz a conexao com o banco de dados
			Statement sessao = (Statement) conn.createStatement(); // cria uma sess�o 
			ResultSet resposta = sessao.executeQuery( sql ); // executa o comando que esta dentro da String sql
			
			while( resposta.next() ) {
				
				String umNome = resposta.getString( "Nome" ); // troca o "Nome" pelo seu campo dentro da tabela que voce quer colocar dentro do comboBox
				comboBox.addItem(umNome);// Adiciona um novo item no ComboBox
				
				// E assim fica no While(que � um loop) at� adicionar todos os itens que tem na tabela
				
			}
		} catch( Exception e1 ) {
			JOptionPane.showMessageDialog(null, "Aconteceu um erro \n "+e1 ); // mostra uma mensagem se ouver erro 
		}
		
	}*/

	/**
	 * Create the dialog.
	 */
	public CadFuncionarios() {
		setTitle("Funcionarios");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("Nome:");
			label.setBounds(10, 14, 46, 14);
			contentPanel.add(label);
		}
		{
			txtNome = new JTextField();
			txtNome.setColumns(10);
			txtNome.setBounds(59, 11, 86, 20);
			contentPanel.add(txtNome);
		}
		{
			txtCPF = new JTextField();
			txtCPF.setColumns(10);
			txtCPF.setBounds(212, 11, 112, 20);
			contentPanel.add(txtCPF);
		}
		{
			JLabel label = new JLabel("CPF:");
			label.setBounds(155, 14, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Rua:");
			label.setBounds(10, 81, 35, 14);
			contentPanel.add(label);
		}
		{
			txtRua = new JTextField();
			txtRua.setColumns(10);
			txtRua.setBounds(42, 78, 118, 20);
			contentPanel.add(txtRua);
		}
		{
			JLabel label = new JLabel("Numero:");
			label.setBounds(197, 102, 79, 14);
			contentPanel.add(label);
		}
		{
			txtNumero = new JTextField();
			txtNumero.setColumns(10);
			txtNumero.setBounds(268, 100, 56, 20);
			contentPanel.add(txtNumero);
		}
		{
			comboBoxEstado = new JComboBox();
			comboBoxEstado.setBounds(310, 140, 56, 18);
			contentPanel.add(comboBoxEstado);
			cControl.AtualizaCombo(comboBoxEstado, "UF");
		}
			
		{
			JLabel label = new JLabel("Estado:");
			label.setBounds(230, 142, 72, 14);
			contentPanel.add(label);
		}
		{
			JButton button = new JButton("...");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Foda.show(cCid);
				}
			});
			button.setBounds(184, 138, 28, 23);
			contentPanel.add(button);
		}
		{
			comboBoxCidade = new JComboBox();
			comboBoxCidade.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			comboBoxCidade.setBounds(80, 139, 93, 20);
			contentPanel.add(comboBoxCidade);
			cControl.AtualizaCombo(comboBoxCidade, "Cidade");
			//Click(comboBox_1);
		}
		
		{
			JLabel label = new JLabel("Cidade:");
			label.setBounds(10, 142, 87, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Telefone:");
			label.setBounds(10, 170, 87, 14);
			contentPanel.add(label);
		}
		{
			txtTelefone = new JTextField();
			txtTelefone.setColumns(10);
			txtTelefone.setBounds(87, 168, 86, 20);
			contentPanel.add(txtTelefone);
		}
		{
			txtCelular = new JTextField();
			txtCelular.setColumns(10);
			txtCelular.setBounds(280, 170, 86, 20);
			contentPanel.add(txtCelular);
		}
		{
			JLabel label = new JLabel("Celular:");
			label.setBounds(207, 170, 89, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Email:");
			label.setBounds(10, 195, 46, 14);
			contentPanel.add(label);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(58, 192, 175, 20);
			contentPanel.add(txtEmail);
		}
		{
			JLabel lblBairro = new JLabel("Bairro:");
			lblBairro.setBounds(178, 81, 55, 14);
			contentPanel.add(lblBairro);
		}
		{
			txtBairro = new JTextField();
			txtBairro.setBounds(245, 78, 79, 20);
			contentPanel.add(txtBairro);
			txtBairro.setColumns(10);
		}
		{
			JLabel lblCep = new JLabel("CEP:");
			lblCep.setBounds(10, 106, 46, 14);
			contentPanel.add(lblCep);
		}
		{
			txtCEP = new JTextField();
			txtCEP.setBounds(59, 100, 86, 20);
			contentPanel.add(txtCEP);
			txtCEP.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {


						//varnome =  txtNome.getText();
						//varsigla = txtSigla.getText();
						
						
						int fkCidade = cControl.FkRadio(comboBoxCidade);
						int fkEstado = cControl.FkRadio(comboBoxEstado);
						

														
						String contato = "INSERT INTO `jbsystem`.`contato` (`telefone`, `celular`, `email`) VALUES ('" + txtTelefone.getText() + "', '" + txtCelular.getText() + "', '" + txtEmail.getText() + "');";
						
						//AQUI INSERI CONTATo*/
						int fkContato = -1 ;
						
								try {
									fkContato = Foda.pegaFk("Contato");
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
		
								
				
						
						
						String endereco = "INSERT INTO `jbsystem`.`endereco` (`rua`, `numero`, `bairro`, `CEP`, `Cidade_idCidade`) VALUES ('" + txtRua.getText() + "', '" + txtNumero.getText() + "', '" + txtBairro.getText() + "', '" + txtCEP.getText() + "', '" + fkCidade + "');";
						
						
								int fkEndereco = -1 ;
								try {
									fkEndereco = Foda.pegaFk("Endereco");
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						
							
							
								
								
								
						String funcionarios = "INSERT INTO `jbsystem`.`funcionarios` (`nome`, `CPF`, `Contato_idContato`, `Endereco_idEndereco`) VALUES ('" + txtNome.getText() + "', '" + txtCPF.getText() +"', '"+fkContato+"', '"+fkEndereco+"');";


	
                      	//MEU COMENT�RIO: estou tentando pegar as chaves de outras janelas, com o umItem.id. Tamb�m separei cada String por nome, sei l�.

						try {
							Conn.ConectaSql(funcionarios);
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
