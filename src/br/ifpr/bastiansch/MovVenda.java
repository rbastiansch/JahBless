package br.ifpr.bastiansch;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MovVenda extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MovVenda dialog = new MovVenda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MovVenda() {
		setTitle("Venda");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDataDeVenda = new JLabel("Data de Venda:");
			lblDataDeVenda.setBounds(12, 12, 123, 15);
			contentPanel.add(lblDataDeVenda);
		}
		{
			textField = new JTextField();
			textField.setBounds(153, 10, 78, 19);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblQuantidadeVendida = new JLabel("Quantidade Vendida:");
			lblQuantidadeVendida.setBounds(12, 39, 168, 15);
			contentPanel.add(lblQuantidadeVendida);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(179, 37, 52, 19);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel lblPreoUnitrio = new JLabel("Preço Unitário:");
			lblPreoUnitrio.setBounds(12, 66, 123, 15);
			contentPanel.add(lblPreoUnitrio);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(142, 64, 91, 19);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
