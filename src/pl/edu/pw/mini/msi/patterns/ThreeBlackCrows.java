package pl.edu.pw.mini.msi.patterns;

import java.util.ArrayList;

import pl.edu.pw.mini.msi.utils.StockPrice;
import pl.edu.pw.mini.msi.utils.Type;

public class ThreeBlackCrows implements Pattern {
	@Override
	public double matchData(ArrayList<StockPrice> data) {
		// three days for trend leading to the pattern
		// and tree days for the pattern itself
		if (data.size() < 6)
			return 0;

		// one of candlesticks is not black
		if (data.get(0).body() > 0 || data.get(1).body() > 0
				|| data.get(2).body() > 0)
			return 0;

		// how much black candlesticks match to black crows from the pattern
		double match = 0;
		match = PatternMatcher.blackCandle(data.get(0));
		match = (match + PatternMatcher.blackCandle(data.get(1))) / 2;
		match = (match + PatternMatcher.blackCandle(data.get(2))) / 2;

		// match of the trend leading to the pattern
		match *= PatternMatcher.upwardLeadingTrend(data.subList(3, 6));

		return match;
	}

	@Override
	public String name() {
		return "Three Black Crows";
	}

	@Override
	public Type type() {
		return Type.BEARISH;
	}

}
