package br.ifpr.bastiansch;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadProdutos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_2;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the dialog.
	 */
	public CadProdutos() {
		setTitle("Produtos");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		contentPanel.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(66, 8, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(182, 14, 66, 14);
		contentPanel.add(lblDescrio);
		
		textField_1 = new JTextField();
		textField_1.setBounds(258, 8, 110, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(10, 36, 60, 14);
		contentPanel.add(lblCategoria);
		
		JLabel lblValorDeCusto = new JLabel("Valor de Custo:");
		lblValorDeCusto.setBounds(10, 88, 86, 14);
		contentPanel.add(lblValorDeCusto);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 85, 96, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblValorDeVenda = new JLabel("Valor de Venda:");
		lblValorDeVenda.setBounds(10, 113, 96, 14);
		contentPanel.add(lblValorDeVenda);
		
		textField_4 = new JTextField();
		textField_4.setBounds(106, 110, 76, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblValorDeVenda_1 = new JLabel("Valor de Venda:");
		lblValorDeVenda_1.setBounds(192, 113, 100, 14);
		contentPanel.add(lblValorDeVenda_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(287, 110, 66, 20);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(76, 33, 96, 20);
		contentPanel.add(comboBox);
		
		JButton button = new JButton("...");
		button.setBounds(182, 32, 33, 18);
		contentPanel.add(button);
		
		JLabel lblDataDeCadastro = new JLabel("Data de Cadastro:");
		lblDataDeCadastro.setBounds(10, 138, 110, 14);
		contentPanel.add(lblDataDeCadastro);
		
		textField_2 = new JTextField();
		textField_2.setBounds(116, 135, 76, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblUnMedida = new JLabel("Un. Medida:");
		lblUnMedida.setBounds(202, 138, 76, 14);
		contentPanel.add(lblUnMedida);
		
		textField_6 = new JTextField();
		textField_6.setBounds(287, 135, 66, 20);
		contentPanel.add(textField_6);
		textField_6.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
