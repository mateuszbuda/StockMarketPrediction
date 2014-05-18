package pl.edu.pw.mini.msi;

import javax.swing.JFrame;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClientDialog client = new ClientDialog();
		client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		client.setSize(300, 300);
		client.setVisible(true);
	}

}
