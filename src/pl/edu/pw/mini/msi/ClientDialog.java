package pl.edu.pw.mini.msi;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import pl.edu.pw.mini.msi.patterns.Pattern;
import pl.edu.pw.mini.msi.utils.DataLoader;
import pl.edu.pw.mini.msi.utils.PatternParser;
import pl.edu.pw.mini.msi.utils.StockPrice;

public class ClientDialog extends JFrame {
	private static final long serialVersionUID = 1;
	JButton btnDeduce;
	JLabel lblPattern;
	JLabel lblAnswer;
	JLabel lblMatch;
	JTextArea textData;
	PatternParser patternParser;

	public ClientDialog() throws HeadlessException {
		setTitle("Stock Market Prediction");

		JTextArea textData = new JTextArea();
		textData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textData.setEditable(false);

		JScrollPane scroll = new JScrollPane(textData,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		getContentPane().add(scroll, BorderLayout.CENTER);
		this.textData = textData;

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		getContentPane().add(splitPane, BorderLayout.SOUTH);

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane.setLeftComponent(splitPane_1);

		JLabel lblPatternTitle = new JLabel("Recognised pattern: ");
		splitPane_1.setLeftComponent(lblPatternTitle);

		JLabel lblPattern = new JLabel("");
		splitPane_1.setRightComponent(lblPattern);
		this.lblPattern = lblPattern;
		
		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_4);
		splitPane_4.setBorder(new EmptyBorder(splitPane_4.getInsets()));
		
				JSplitPane splitPane_2 = new JSplitPane();
				splitPane_4.setLeftComponent(splitPane_2);
				
						JLabel lblAnswerTitle = new JLabel("Answer: ");
						splitPane_2.setLeftComponent(lblAnswerTitle);
						
								JLabel lblAnswer_1 = new JLabel("");
								splitPane_2.setRightComponent(lblAnswer_1);
								this.lblAnswer = lblAnswer_1;
								
								JSplitPane splitPane_5 = new JSplitPane();
								splitPane_4.setRightComponent(splitPane_5);
								
								JLabel lblMatchTitle = new JLabel("Match: ");
								splitPane_5.setLeftComponent(lblMatchTitle);
								
								JLabel lblMatch_1 = new JLabel("");
								splitPane_5.setRightComponent(lblMatch_1);
								this.lblMatch = lblMatch_1;

		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		getContentPane().add(splitPane_3, BorderLayout.NORTH);

		JButton btnLoadData = new JButton("Load data");
		btnLoadData.addActionListener(new DataLoader(this));
		splitPane_3.setLeftComponent(btnLoadData);

		JButton btnDeduce = new JButton("Deduce");
		patternParser = new PatternParser(this, null);
		btnDeduce.addActionListener(patternParser);
		btnDeduce.setEnabled(false);
		splitPane_3.setRightComponent(btnDeduce);
		this.btnDeduce = btnDeduce;
	}

	public void displayData(ArrayList<StockPrice> data) {
		StringBuilder dataStr = new StringBuilder("open,high,low,close\n");
		for (StockPrice stockPrice : data) {
			dataStr.append(stockPrice.open).append(",");
			dataStr.append(stockPrice.high).append(",");
			dataStr.append(stockPrice.low).append(",");
			dataStr.append(stockPrice.close).append('\n');
		}
		textData.setText(dataStr.toString());
		patternParser.setData(data);
		btnDeduce.setEnabled(true);
	}

	public void displayAnswer(Pattern pattern, double match) {
		lblPattern.setText(pattern.name());
		lblAnswer.setText(pattern.type().getAction());
		lblMatch.setText(String.format("%3.2f%%", match*100));
	}

	public void exception(String msg) {
		textData.setText(msg);
	}
}
