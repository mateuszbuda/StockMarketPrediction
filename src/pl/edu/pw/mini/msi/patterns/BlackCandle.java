package pl.edu.pw.mini.msi.patterns;

import java.util.ArrayList;

import pl.edu.pw.mini.msi.utils.StockPrice;
import pl.edu.pw.mini.msi.utils.Type;

public class BlackCandle implements Pattern {

	@Override
	public double matchData(ArrayList<StockPrice> data) {
		StockPrice top = data.get(0);
		// Checks if candle is not black
		if (top.isWhite())
			return 0;
		if (Math.abs(top.body())>top.upperShadow() && 
				Math.abs(top.body())>top.lowerShadow())
			return getMatch(top);
		return 0;
	}

	private double getMatch(StockPrice top) {
		return ((Math.abs(top.body()*2) - top.upperShadow()
				- top.lowerShadow()))/Math.abs(top.body()*2);
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
