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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class CadClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtEmail;

	CadCidade cCid = new CadCidade();
	
	
	ComboControl cControl = new ComboControl();
	//private JComboBox comboBoxCidade;
	private JComboBox comboBoxEstado;
	private ComboBox comboBoxCidade;
	private JTextField txtBairro;
	private JTextField txtCEP;
	/**
	 * Launch the application.
	 */
public int FkRadio(){ 
		
		comboModel combo = (comboModel) comboBoxCidade.getSelectedItem();  
		return combo.id;
		
	}

	/**
	 * Create the dialog.
	 */
	public CadClientes() {
		setTitle("Clientes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNome = new JLabel("Nome:");
			lblNome.setBounds(10, 11, 46, 14);
			contentPanel.add(lblNome);
		}
		{
			txtNome = new JTextField();
			txtNome.setBounds(59, 8, 86, 20);
			contentPanel.add(txtNome);
			txtNome.setColumns(10);
		}
		{
			JLabel lblCpf = new JLabel("CPF:");
			lblCpf.setBounds(165, 11, 46, 14);
			contentPanel.add(lblCpf);
		}
		{
			txtCPF = new JTextField();
			txtCPF.setBounds(221, 8, 112, 20);
			contentPanel.add(txtCPF);
			txtCPF.setColumns(10);
		}
		{
			JLabel lblRua = new JLabel("Rua:");
			lblRua.setBounds(143, 65, 35, 14);
			contentPanel.add(lblRua);
		}
		{
			txtRua = new JTextField();
			txtRua.setBounds(188, 62, 135, 20);
			contentPanel.add(txtRua);
			txtRua.setColumns(10);
		}
		{
			JLabel lblNumero = new JLabel("Numero:");
			lblNumero.setBounds(211, 93, 56, 14);
			contentPanel.add(lblNumero);
		}
		{
			txtNumero = new JTextField();
			txtNumero.setBounds(267, 90, 56, 20);
			contentPanel.add(txtNumero);
			txtNumero.setColumns(10);
		}
		{
			JLabel lblCidade = new JLabel("Cidade:");
			lblCidade.setBounds(10, 137, 46, 14);
			contentPanel.add(lblCidade);
		}
		{
			comboBoxCidade = new ComboBox("SELECT idCidade, nome FROM cidade" );
			comboBoxCidade.setBounds(62, 134, 93, 20);
			contentPanel.add(comboBoxCidade);
			
			//cControl.AtualizaCombo(comboBoxCidade, "Cidade");
		}
		{
			JButton button = new JButton("...");
			button.setBounds(155, 133, 28, 23);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Foda.show(cCid);
				}
			});
			contentPanel.add(button);
		}
		{
			comboBoxEstado = new JComboBox();
			comboBoxEstado.setBounds(237, 138, 79, 18);
			contentPanel.add(comboBoxEstado);
			
			cControl.AtualizaCombo(comboBoxEstado, "UF");
		}
		{
			JLabel lblEstado = new JLabel("Estado:");
			lblEstado.setBounds(190, 140, 46, 14);
			contentPanel.add(lblEstado);
		}
		{
			JLabel lblTelefone = new JLabel("Telefone:");
			lblTelefone.setBounds(10, 166, 56, 14);
			contentPanel.add(lblTelefone);
		}
		{
			txtTelefone = new JTextField();
			txtTelefone.setBounds(59, 163, 86, 20);
			contentPanel.add(txtTelefone);
			txtTelefone.setColumns(10);
		}
		{
			JLabel lblCelular = new JLabel("Celular:");
			lblCelular.setBounds(10, 191, 46, 14);
			contentPanel.add(lblCelular);
		}
		{
			txtCelular = new JTextField();
			txtCelular.setBounds(59, 188, 86, 20);
			contentPanel.add(txtCelular);
			txtCelular.setColumns(10);
		}
		{
			JLabel lblEmail = new JLabel("Email:");
			lblEmail.setBounds(10, 212, 46, 14);
			contentPanel.add(lblEmail);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setBounds(59, 209, 175, 20);
			contentPanel.add(txtEmail);
			txtEmail.setColumns(10);
		}
		
		txtBairro = new JTextField();
		txtBairro.setBounds(59, 65, 64, 20);
		contentPanel.add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 68, 46, 14);
		contentPanel.add(lblBairro);
		{
			JLabel lblCep = new JLabel("CEP:");
			lblCep.setBounds(10, 93, 46, 14);
			contentPanel.add(lblCep);
		}
		{
			txtCEP = new JTextField();
			txtCEP.setBounds(59, 90, 86, 20);
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
						
						/*int fkCidade = cControl.FkRadio(comboBoxCidade);
						int fkEstado = cControl.FkRadio(comboBoxEstado);*/
						int fkCidade = comboBoxCidade.getSelectedItemId();//( (comboModel) cboxCidade.getSelectedItem()).getId();//cControl.FkRadio(comboBoxCidade);
						Foda.p("FK1 : "+fkCidade);

														
						String contato = "INSERT INTO `jbsystem`.`contato` (`telefone`, `celular`, `email`) VALUES ('" + txtTelefone.getText() + "', '" + txtCelular.getText() + "', '" + txtEmail.getText() + "');";
						int fkContato = Foda.insert(contato);
						Foda.p(fkContato);
						
						//AQUI INSERI CONTATo*/
						/*int fkContato = -1 ;
						
								try {
									fkContato = Foda.pegaFk("Contato");
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}	*/				
						
						
						String endereco = "INSERT INTO `jbsystem`.`endereco` (`rua`, `numero`, `bairro`, `CEP`, `Cidade_idCidade`) VALUES ('" + txtRua.getText() + "', '" + txtNumero.getText() + "', '" + txtBairro.getText() + "', '" + txtCEP.getText() + "', '" + fkCidade + "');";
						int fkEndereco = Foda.insert( endereco );
						Foda.p( fkEndereco);
						//int fkEndereco = Foda.insert(endereco);
						//Foda.p(fkEndereco);
								/*int fkEndereco = -1 ;
								try {
									fkEndereco = Foda.pegaFk("Endereco");
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}	*/					
								
								
						String cliente = "INSERT INTO `jbsystem`.`clientes` (`nome`, `CPF`, `Contato_idContato`, `Endereco_idEndereco`) VALUES ('" + txtNome.getText() + "', '" + txtCPF.getText() +"', '"+ fkContato +"', '"+ fkEndereco +"');";
						

	
                      	//MEU COMENTÁRIO: estou tentando pegar as chaves de outras janelas, com o umItem.id. Também separei cada String por nome, sei lá.

						try {
							Conn.ConectaSql(cliente);
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
