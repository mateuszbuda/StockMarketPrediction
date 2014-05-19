package pl.edu.pw.mini.msi.patterns;

import java.util.ArrayList;

import pl.edu.pw.mini.msi.utils.StockPrice;
import pl.edu.pw.mini.msi.utils.Type;

public class ThreeWhiteSoldiers implements Pattern {
	@Override
	public double matchData(ArrayList<StockPrice> data) {
		// three days for trend leading to the pattern
		// and tree days for the pattern itself
		if (data.size() < 6)
			return 0;

		// one of candlesticks is not white
		if (data.get(0).body() < 0 || data.get(1).body() < 0
				|| data.get(2).body() < 0)
			return 0;

		// closing price is not rising
		if (data.get(0).close < data.get(1).close
				|| data.get(1).close < data.get(2).close
				|| data.get(2).close < data.get(3).close)
			return 0;

		// how much white candlesticks match to soldiers from the pattern
		double match = 0;
		match = getSoldierMatch(data.get(0));
		match = (match + getSoldierMatch(data.get(1))) / 2;
		match = (match + getSoldierMatch(data.get(2))) / 2;

		// match of the trend leading to the pattern
		if (data.get(3).close < data.get(4).close
				|| data.get(4).close < data.get(5).close
				|| data.get(5).close < data.get(6).close)
			match /= 3;

		return match;
	}

	private double getSoldierMatch(StockPrice stockPrice) {
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
		return "Three White Soldiers";
	}

	@Override
	public Type type() {
		return Type.BULLISH;
	}

}
