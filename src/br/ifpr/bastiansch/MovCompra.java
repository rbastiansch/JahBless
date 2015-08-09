package br.ifpr.bastiansch;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MovCompra extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MovCompra dialog = new MovCompra();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MovCompra() {
		setTitle("Compra");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDataDeCompra = new JLabel("Data de Compra:");
		lblDataDeCompra.setBounds(12, 27, 119, 15);
		contentPanel.add(lblDataDeCompra);
		
		textField = new JTextField();
		textField.setBounds(149, 25, 91, 19);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JLabel lblPreo = new JLabel("Preço:");
			lblPreo.setBounds(258, 27, 70, 15);
			contentPanel.add(lblPreo);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(324, 25, 85, 19);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel lblQuantidadeComprada = new JLabel("Quantidade Comprada:");
			lblQuantidadeComprada.setBounds(12, 54, 179, 15);
			contentPanel.add(lblQuantidadeComprada);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(196, 52, 63, 19);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			JLabel lblPreoUnitrio = new JLabel("Preço Unitário:");
			lblPreoUnitrio.setBounds(12, 81, 119, 15);
			contentPanel.add(lblPreoUnitrio);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(149, 79, 77, 19);
			contentPanel.add(textField_3);
			textField_3.setColumns(10);
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
