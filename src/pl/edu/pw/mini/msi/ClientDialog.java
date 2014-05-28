package pl.edu.pw.mini.msi;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import pl.edu.pw.mini.msi.utils.PatternParser;

public class ClientDialog extends JFrame {
	public JLabel lblPattern1;
	public JLabel lblMatch1;
	public JLabel lblPattern2;
	public JLabel lblMatch2;
	public JLabel lblPattern3;
	public JLabel lblMatch3;
	public JComboBox<String> stockOptions;
	public PatternParser patternParser;
	static final String[] STOCKS = { "GOOG", "FB", "TWTR", "YHOO", "AAPL",
			"CSCO", "T", "INTC", "MSFT", "ORCL", "ZNGA", "EBAY", "GE", "GRPN",
			"GM", "FOXA", "VZ", "NOK", "HPQ", "MCD" };

	public ClientDialog() throws HeadlessException {
		patternParser = new PatternParser(this);

		Box verticalBox = Box.createVerticalBox();
		getContentPane().add(verticalBox, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		verticalBox.add(panel);

		JLabel lblNewLabel_6 = new JLabel("Choose Stock:  ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel_6);

		JComboBox<String> comboBoxStock = new JComboBox<String>();
		comboBoxStock.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxStock.setModel(new DefaultComboBoxModel(STOCKS));
		stockOptions = comboBoxStock;
		panel.add(comboBoxStock);

		JButton btnProcess = new JButton("Process");
		btnProcess.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProcess.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnProcess.addActionListener(patternParser);
		verticalBox.add(btnProcess);

		Box verticalBox_1 = Box.createVerticalBox();
		getContentPane().add(verticalBox_1, BorderLayout.CENTER);

		JSeparator separator = new JSeparator();
		verticalBox_1.add(separator);

		Box horizontalBox = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox);

		Box verticalBox_2 = Box.createVerticalBox();
		horizontalBox.add(verticalBox_2);

		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_3);

		JLabel lblNewLabel = new JLabel("Pattern:  ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		horizontalBox_3.add(lblNewLabel);

		JLabel lblPtrn1 = new JLabel("...");
		lblPtrn1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPattern1 = lblPtrn1;
		horizontalBox_3.add(lblPtrn1);

		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox_2.add(horizontalBox_4);

		JLabel lblNewLabel_7 = new JLabel("Match degree:  ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		horizontalBox_4.add(lblNewLabel_7);

		JLabel lblBestMatch1 = new JLabel("0");
		lblBestMatch1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMatch1 = lblBestMatch1;
		horizontalBox_4.add(lblBestMatch1);

		JSeparator separator_1 = new JSeparator();
		verticalBox_1.add(separator_1);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_1);

		Box verticalBox_3 = Box.createVerticalBox();
		horizontalBox_1.add(verticalBox_3);

		Box horizontalBox_5 = Box.createHorizontalBox();
		verticalBox_3.add(horizontalBox_5);

		JLabel lblNewLabel_9 = new JLabel("Pattern:  ");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		horizontalBox_5.add(lblNewLabel_9);

		JLabel lblPtrn2 = new JLabel("...");
		lblPtrn2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPattern2 = lblPtrn2;
		horizontalBox_5.add(lblPtrn2);

		Box horizontalBox_6 = Box.createHorizontalBox();
		verticalBox_3.add(horizontalBox_6);

		JLabel lblNewLabel_11 = new JLabel("Match degree:  ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		horizontalBox_6.add(lblNewLabel_11);

		JLabel lblBestMatch2 = new JLabel("0");
		lblBestMatch2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMatch2 = lblBestMatch2;
		horizontalBox_6.add(lblBestMatch2);

		JSeparator separator_2 = new JSeparator();
		verticalBox_1.add(separator_2);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox_1.add(horizontalBox_2);

		Box verticalBox_4 = Box.createVerticalBox();
		horizontalBox_2.add(verticalBox_4);

		Box horizontalBox_7 = Box.createHorizontalBox();
		verticalBox_4.add(horizontalBox_7);

		JLabel lblNewLabel_4 = new JLabel("Pattern:  ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		horizontalBox_7.add(lblNewLabel_4);

		JLabel lblPtrn3 = new JLabel("...");
		lblPtrn3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPattern3 = lblPtrn3;
		horizontalBox_7.add(lblPtrn3);

		Box horizontalBox_8 = Box.createHorizontalBox();
		verticalBox_4.add(horizontalBox_8);

		JLabel lblNewLabel_2 = new JLabel("Match degree:  ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		horizontalBox_8.add(lblNewLabel_2);

		JLabel lblBestMatch3 = new JLabel("0");
		lblBestMatch3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMatch3 = lblBestMatch3;
		horizontalBox_8.add(lblBestMatch3);
	}
}
