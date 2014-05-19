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

		// / one of candlesticks is not black
		if (data.get(0).body() > 0 || data.get(1).body() > 0
				|| data.get(2).body() > 0)
			return 0;

		// closing price is not falling
		if (data.get(0).close > data.get(1).close
				|| data.get(1).close > data.get(2).close
				|| data.get(2).close > data.get(3).close)
			return 0;

		// how much black candlesticks match to black crows from the pattern
		double match = 0;
		match = getCrowMatch(data.get(0));
		match = (match + getCrowMatch(data.get(1))) / 2;
		match = (match + getCrowMatch(data.get(2))) / 2;

		// match of the trend leading to the pattern
		if (data.get(3).close < data.get(4).close
				|| data.get(4).close < data.get(5).close
				|| data.get(5).close < data.get(6).close)
			match /= 2;

		return match;
	}

	private double getCrowMatch(StockPrice stockPrice) {
		if (stockPrice.upperShadow() < Math.abs(stockPrice.body()) / 2
				&& stockPrice.lowerShadow() < Math.abs(stockPrice.body()) / 2)
			return 1;
		else if (stockPrice.upperShadow() < Math.abs(stockPrice.body()) / 2
				&& stockPrice.lowerShadow() < Math.abs(stockPrice.body()))
			return 0.85;
		else if (stockPrice.upperShadow() < Math.abs(stockPrice.body())
				&& stockPrice.lowerShadow() < Math.abs(stockPrice.body()) / 2)
			return 0.6;
		else if (stockPrice.upperShadow() < Math.abs(stockPrice.body())
				&& stockPrice.lowerShadow() < Math.abs(stockPrice.body()))
			return 0.7;
		else
			return 0.3;
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
