package pl.edu.pw.mini.msi.patterns;

import java.util.ArrayList;

import pl.edu.pw.mini.msi.utils.StockPrice;
import pl.edu.pw.mini.msi.utils.Type;

public class BullishSeparatingLines implements Pattern {

	private static final String PATTERN_NAME = "Bullish Separating Lines";

	@Override
	public double matchData(ArrayList<StockPrice> data) {
		if (data.size() < 5) {
			return 0;
		}

		if (data.get(2).close < data.get(3).close
				|| data.get(3).close < data.get(4).close) {
			return 0;
		}

		if (data.get(1).isWhite() || data.get(0).isBlack()) {
			return 0;
		}

		double bodyPercent = data.get(1).body()
				/ (data.get(1).high - data.get(1).low);
		double match;

		if (bodyPercent >= 0.8 && bodyPercent <= 0.9) {
			match = 1.0;
		} else {
			match = 1.0 - ((bodyPercent < 0.8) ? 0.8 - bodyPercent
					: bodyPercent - 0.9);
		}

		bodyPercent = data.get(0).body() / (data.get(0).high - data.get(1).low);

		if (bodyPercent >= 0.8 && bodyPercent <= 0.9) {
			match = (match + 1.0) / 2;
		} else {
			match = (match + 1.0 - ((bodyPercent < 0.8) ? 0.8 - bodyPercent
					: bodyPercent - 0.9)) / 2;
		}

		return 0;
	}

	@Override
	public String name() {
		return PATTERN_NAME;
	}

	@Override
	public Type type() {
		return Type.BULLISH;
	}

}
