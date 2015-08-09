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
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadFornecedores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtCNPJ;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCEP;
	
	CadCidade cCid = new CadCidade();
	CadEstado cEst = new CadEstado();

	/**
	 * Launch the application.
	 */
	
	//ComboControl cControl = new ComboControl();
	private JComboBox comboBoxCidade;
	private ComboBox cboxCidade;
	

	public int FkRadio(){ 
		
		comboModel combo = (comboModel) cboxCidade.getSelectedItem();  
		return combo.id;
		
	}
	
	public CadFornecedores() {
		setTitle("Fornecedores");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		contentPanel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(61, 8, 86, 20);
		contentPanel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(157, 11, 46, 14);
		contentPanel.add(lblCnpj);
		
		txtCNPJ = new JTextField();
		txtCNPJ.setBounds(207, 8, 148, 20);
		contentPanel.add(txtCNPJ);
		txtCNPJ.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 51, 63, 14);
		contentPanel.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(71, 48, 86, 20);
		contentPanel.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(165, 51, 46, 14);
		contentPanel.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(217, 48, 86, 20);
		contentPanel.add(txtCelular);
		txtCelular.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 76, 46, 14);
		contentPanel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(61, 73, 142, 20);
		contentPanel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 117, 46, 14);
		contentPanel.add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setBounds(61, 114, 142, 20);
		contentPanel.add(txtRua);
		txtRua.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(213, 117, 58, 14);
		contentPanel.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(269, 114, 51, 20);
		contentPanel.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 142, 46, 14);
		contentPanel.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(53, 139, 104, 20);
		contentPanel.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(175, 142, 36, 14);
		contentPanel.add(lblCep);
		
		txtCEP = new JTextField();
		txtCEP.setBounds(223, 139, 97, 20);
		contentPanel.add(txtCEP);
		txtCEP.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 167, 46, 14);
		contentPanel.add(lblCidade);
		
		
		JButton button = new JButton("...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Foda.show(cCid);
				
			}
		});
		button.setBounds(200, 180, 27, 23);
		contentPanel.add(button);
		
		cboxCidade = new ComboBox( "SELECT idCidade, nome FROM cidade" );
		cboxCidade.setBounds(30, 193, 137, 22);
		contentPanel.add(cboxCidade);
		//ComboControl.AtualizaCombo(cboxCidade, "Cidade");
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
						
						
						//int fkEstado = 
						int fkCidade = cboxCidade.getSelectedItemId();//( (comboModel) cboxCidade.getSelectedItem()).getId();//cControl.FkRadio(comboBoxCidade);
						Foda.p("FK1 : "+fkCidade);
						
														
						String contato = "INSERT INTO `jbsystem`.`contato` (`telefone`, `celular`, `email`) VALUES ('" + txtTelefone.getText() + "', '" + txtCelular.getText() + "', '" + txtEmail.getText() + "');";
						
						int idContato = Foda.insert( contato );
						Foda.p("ID CONTATO "+ idContato );
						//AQUI INSERI CONTATo*/
						/*int fkContato = -1 ;
						
								try {
									fkContato = Foda.pegaFk("Contato");
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
		
						System.out.println( fkContato );*/
				
						
						
						String endereco = "INSERT INTO `jbsystem`.`endereco` (`rua`, `numero`, `bairro`, `CEP`, `Cidade_idCidade`) VALUES ('" + txtRua.getText() + "', '" + txtNumero.getText() + "', '" + txtBairro.getText() + "', '" + txtCEP.getText() + "', '" + fkCidade + "')";
						
						int idEndereco = Foda.insert( endereco );
						Foda.p( idEndereco);		
								
								
						String fornecedor = "INSERT INTO `jbsystem`.`fornecedores` (`nome`, `CNPJ`, `Contato_idContato`, `Endereco_idEndereco`) VALUES ('" + txtNome.getText() + "', '" + txtCNPJ.getText() + "', '"+ idContato +"', '"+ idEndereco +"');";
						

	
                      	//MEU COMENT�RIO: estou tentando pegar as chaves de outras janelas, com o umItem.id. Tamb�m separei cada String por nome, sei l�.

						try {
							Conn.ConectaSql(fornecedor);
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
						int a = FkRadio();
						
						Foda.p("AQUI :"+a);
						//setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
