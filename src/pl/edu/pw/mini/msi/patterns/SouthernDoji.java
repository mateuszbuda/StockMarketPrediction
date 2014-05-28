package pl.edu.pw.mini.msi.patterns;

import java.util.ArrayList;

import pl.edu.pw.mini.msi.utils.StockPrice;
import pl.edu.pw.mini.msi.utils.Type;

public class SouthernDoji implements Pattern {
	@Override
	public double matchData(ArrayList<StockPrice> data) {
		if (data.size() < 4)
			return 0;

		double match = 0;

		if (Math.abs(data.get(0).upperShadow() / data.get(0).lowerShadow()) > 1.6)
			return 0;

		double shadow = (data.get(0).upperShadow() + data.get(0).lowerShadow()) / 2;

		if (Math.abs(data.get(0).body()) > 0.1 * shadow)
			return 0;

		match = 1 - (Math.abs(data.get(0).body()) / shadow);

		// falling trend leading to the pattern
		double leadingTrend = PatternMatcher.downwardLeadingTrend(data.subList(
				1, 4));

		return Math.max(0, match + Math.log10(leadingTrend));
	}

	@Override
	public String name() {
		return "Southern Doji";
	}

	@Override
	public Type type() {
		return Type.BULLISH;
	}

}
