package pl.edu.pw.mini.msi.patterns;

import java.util.ArrayList;

import pl.edu.pw.mini.msi.utils.StockPrice;
import pl.edu.pw.mini.msi.utils.Type;

public class BearishSeparatingLines implements Pattern {

	@Override
	public double matchData(ArrayList<StockPrice> data) {

		if (data.size() < 5) {
			return 0;
		}

		if (data.get(2).close > data.get(3).close
				|| data.get(3).close > data.get(4).close) {
			return 0;
		}

		if(data.get(1).isBlack() && data.get(0).isWhite()) {
			return 0;
		}

		//double bodyPercent = data.get(1).body()/data.get(1).
		
		return 1;
		
	}

	@Override
	public String name() {
		return "Bearish Separating Lines";
	}

	@Override
	public Type type() {
		return Type.BEARISH;
	}

}
