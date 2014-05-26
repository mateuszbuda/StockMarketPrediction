package pl.edu.pw.mini.msi.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import pl.edu.pw.mini.msi.ClientDialog;
import pl.edu.pw.mini.msi.patterns.Pattern;
import pl.edu.pw.mini.msi.patterns.PatternSet;

public class PatternParser implements ActionListener {
	ClientDialog context;
	DataLoader dataLoader;
	ArrayList<StockPrice> data;

	public PatternParser(ClientDialog context) {
		this.context = context;
		dataLoader = new DataLoader();
	}

	private void findPatterns() {
		Pattern[] best = { null, null, null };
		double[] max = { -1, -1, -1 };

		for (Pattern pattern : PatternSet.instance()) {
			double tmp = pattern.matchData(data);
			if (tmp > max[0]) {
				max[2] = max[1];
				max[1] = max[0];
				max[0] = tmp;
				best[2] = best[1];
				best[1] = best[0];
				best[0] = pattern;
			} else if (tmp > max[1]) {
				max[2] = max[1];
				max[1] = tmp;
				best[2] = best[1];
				best[1] = pattern;
			} else if (tmp > max[2]) {
				max[2] = tmp;
				best[2] = pattern;
			}
		}

		DecimalFormat df = new DecimalFormat("0.00");
		if (best[0] != null) {
			context.lblPattern1.setText(best[0].name());
			context.lblMatch1.setText(df.format(max[0]));
		}
		if (best[1] != null) {
			context.lblPattern2.setText(best[1].name());
			context.lblMatch2.setText(df.format(max[1]));
		}
		if (best[2] != null) {
			context.lblPattern3.setText(best[2].name());
			context.lblMatch3.setText(df.format(max[2]));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		data = dataLoader.loadData((String) context.stockOptions
				.getSelectedItem());
		findPatterns();
	}
}
