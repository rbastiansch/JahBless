package br.ifpr.bastiansch;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	
	CadFornecedores forn = new CadFornecedores();
	CadClientes clie = new CadClientes();
	CadFuncionarios func = new CadFuncionarios();
	CadProdutos prod = new CadProdutos();
	RelCliente relC = new RelCliente();
	CadCidade cida = new CadCidade();
	CadEstado esta = new CadEstado();
	
	RelFornecedores relFor = new RelFornecedores();
	RelFuncionarios  relFun = new RelFuncionarios();
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("JahBlessSystem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		JMenuItem mntmFornecedores = new JMenuItem("Fornecedores");
		mntmFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				forn.setModal(true);
				forn.setVisible(true);
			}
		});
		mnCadastros.add(mntmFornecedores);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mntmProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prod.setVisible(true);
				prod.setModal(true);
			}
		});
		mnCadastros.add(mntmProdutos);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clie.setModal(true);
				clie.setVisible(true);
			}
		});
		mnCadastros.add(mntmClientes);
		
		JMenuItem mntmFuncionrios = new JMenuItem("Funcion\u00E1rios");
		mntmFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				func.setVisible(true);
				func.setModal(true);
			}
		});
		mnCadastros.add(mntmFuncionrios);
		
		JMenuItem mntmCidades = new JMenuItem("Cidades");
		mntmCidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cida.setVisible(true);
				cida.setModal(true);
			}
		});
		mnCadastros.add(mntmCidades);
		
		JMenuItem mntmEstados = new JMenuItem("Estados");
		mntmEstados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				esta.setVisible(true);
				esta.setModal(true);
			}
		});
		mnCadastros.add(mntmEstados);
		
		JMenu mnMovimentacoes = new JMenu("Movimenta\u00E7\u00F5es");
		menuBar.add(mnMovimentacoes);
		
		JMenuItem mntmCompras_1 = new JMenuItem("Compras");
		mnMovimentacoes.add(mntmCompras_1);
		
		JMenuItem mntmVendas_1 = new JMenuItem("Vendas");
		mnMovimentacoes.add(mntmVendas_1);
		
		JMenu mnRelatorios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatorios);
		
		JMenuItem mntmFornecedores_1 = new JMenuItem("Fornecedores");
		mntmFornecedores_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Foda.show(relFor);
			}
		});
		mnRelatorios.add(mntmFornecedores_1);
		
		JMenuItem mntmClientes_1 = new JMenuItem("Clientes");
		mntmClientes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				relC.setModal(true);
				relC.setVisible(true);
			}
			
		});
		mnRelatorios.add(mntmClientes_1);
		
		JMenuItem mntmFuncionarios_1 = new JMenuItem("Funcionarios");
		mntmFuncionarios_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				relFun.setModal(true);
				relFun.setVisible(true);
			}
		});
		mnRelatorios.add(mntmFuncionarios_1);
		
		JMenuItem mntmProdutos_1 = new JMenuItem("Produtos");
		mnRelatorios.add(mntmProdutos_1);
		
		JMenuItem mntmCompras = new JMenuItem("Compras");
		mnRelatorios.add(mntmCompras);
		
		JMenuItem mntmVendas = new JMenuItem("Vendas");
		mnRelatorios.add(mntmVendas);
		
		JMenuItem mntmComprasPorFornecedor = new JMenuItem("Compras por Fornecedor");
		mnRelatorios.add(mntmComprasPorFornecedor);
		
		JMenuItem mntmGeral = new JMenuItem("Geral");
		mnRelatorios.add(mntmGeral);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
