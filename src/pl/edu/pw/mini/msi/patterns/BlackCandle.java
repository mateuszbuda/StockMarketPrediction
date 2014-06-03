package pl.edu.pw.mini.msi.patterns;

import java.util.ArrayList;

import pl.edu.pw.mini.msi.utils.StockPrice;
import pl.edu.pw.mini.msi.utils.Type;

public class BlackCandle implements Pattern {

	@Override
	public double matchData(ArrayList<StockPrice> data) {
		return PatternMatcher.blackCandle(data.get(0));
	}

	@Override
	public String name() {
		return "Black Candle";
	}

	@Override
	public Type type() {
		return Type.NEUTRAL;
	}

}
