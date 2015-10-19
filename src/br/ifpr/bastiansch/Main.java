package br.ifpr.bastiansch;

import java.awt.EventQueue;

import javax.swing.JDialog;

//Aqui chama a Janela principal
public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
