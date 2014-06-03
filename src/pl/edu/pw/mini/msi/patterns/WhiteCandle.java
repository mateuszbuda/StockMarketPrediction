package pl.edu.pw.mini.msi.patterns;

import java.util.ArrayList;

import pl.edu.pw.mini.msi.utils.StockPrice;
import pl.edu.pw.mini.msi.utils.Type;

public class WhiteCandle implements Pattern {

	@Override
	public double matchData(ArrayList<StockPrice> data) {
		return PatternMatcher.whiteCandle(data.get(0));
	}

	@Override
	public String name() {
		return "White Candle";
	}

	@Override
	public Type type() {
		return Type.NEUTRAL;
	}

}
