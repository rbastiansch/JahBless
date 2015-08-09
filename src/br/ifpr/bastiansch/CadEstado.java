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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadEstado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtSigla;

	/**
	 * Launch the application.
	 */
	
	String varnome, varsigla;
	public static void main(String[] args) {
		try {
			CadEstado dialog = new CadEstado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadEstado() {
		setTitle("Cadastro de Estados");
		setBounds(100, 100, 198, 144);
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
			txtNome.setBounds(66, 8, 86, 20);
			contentPanel.add(txtNome);
			txtNome.setColumns(10);
		}
		{
			JLabel lblSigla = new JLabel("Sigla:");
			lblSigla.setBounds(10, 37, 46, 14);
			contentPanel.add(lblSigla);
		}
		{
			txtSigla = new JTextField();
			txtSigla.setBounds(66, 34, 86, 20);
			contentPanel.add(txtSigla);
			txtSigla.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						varnome =  txtNome.getText();
						varsigla = txtSigla.getText();

						String sql = "INSERT INTO `JBSystem`.`UF` (`nome`, `sigla`) VALUES ('"
								+ varnome + "', '" + varsigla + "')";

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
