package pl.edu.pw.mini.msi.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import pl.edu.pw.mini.msi.ClientDialog;
import au.com.bytecode.opencsv.CSVReader;

public class DataLoader implements ActionListener {
	ClientDialog context;

	public DataLoader(ClientDialog context) {
		this.context = context;
	}

	@SuppressWarnings("resource")
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(context);
		CSVReader reader = null;
		try {
			reader = new CSVReader(
					new FileReader(fileChooser.getSelectedFile()));
		} catch (FileNotFoundException e1) {
			context.exception("File not found.");
			return;
		}

		String[] nextLine;
		ArrayList<StockPrice> data = new ArrayList<StockPrice>();

		try {
			reader.readNext();
			while ((nextLine = reader.readNext()) != null) {
				data.add(new StockPrice(nextLine[1], nextLine[2], nextLine[3],
						nextLine[4]));
			}
		} catch (IndexOutOfBoundsException e2) {
			context.exception("Incorrect data format.");
			return;
		} catch (Exception e1) {
			context.exception("Error: " + e1.getMessage());
			return;
		}

		context.displayData(data);
	}
}
