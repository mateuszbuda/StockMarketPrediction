package pl.edu.pw.mini.msi.patterns;

import java.util.List;

import pl.edu.pw.mini.msi.utils.StockPrice;

public class PatternMatcher {

	private PatternMatcher() {
	}

	public static double doji(StockPrice stock) {
		// TODO
		return 0;
	}

	public static double downwardLeadingTrend(List<StockPrice> stocks) {
		double first = ((stocks.get(0).close + stocks.get(0).open) + (stocks
				.get(0).low + stocks.get(0).high) / 2) / 3;
		double second = ((stocks.get(1).close + stocks.get(1).open) + (stocks
				.get(1).low + stocks.get(1).high) / 2) / 3;
		double third = ((stocks.get(2).close + stocks.get(2).open) + (stocks
				.get(2).low + stocks.get(2).high) / 2) / 3;

		double x = 1.5;
		double y = (second + third) / 2;

		double a = (y - first) / x;

		if (a > 0)
			return 0;

		return Math.abs(a) > 1 ? 1 : Math.abs(a);
	}

	public static double upwardLeadingTrend(List<StockPrice> stocks) {
		double first = ((stocks.get(0).close + stocks.get(0).open) + (stocks
				.get(0).low + stocks.get(0).high) / 2) / 3;
		double second = ((stocks.get(1).close + stocks.get(1).open) + (stocks
				.get(1).low + stocks.get(1).high) / 2) / 3;
		double third = ((stocks.get(2).close + stocks.get(2).open) + (stocks
				.get(2).low + stocks.get(2).high) / 2) / 3;

		double x = 1.5;
		double y = (second + third) / 2;

		double a = (y - first) / x;

		if (a < 0)
			return 0;

		return a > 1 ? 1 : a;
	}

	public static double blackCandle(StockPrice stock) {
		if (stock.body() > 0)
			return 0;

		double body = Math.abs(stock.body());

		double upperMatch = body / (body + stock.upperShadow());
		double lowerMatch = body / (body + stock.lowerShadow());

		upperMatch = upperMatch < 0.5 ? upperMatch / 2 : upperMatch;
		upperMatch = upperMatch > 0.8 ? upperMatch = 1 : upperMatch;

		lowerMatch = lowerMatch < 0.5 ? lowerMatch / 2 : lowerMatch;
		lowerMatch = lowerMatch > 0.8 ? lowerMatch = 1 : lowerMatch;

		return (upperMatch + lowerMatch) / 2;
	}

	public static double whiteCandle(StockPrice stock) {
		if (stock.body() < 0)
			return 0;

		double body = Math.abs(stock.body());

		double upperMatch = body / (body + stock.upperShadow());
		double lowerMatch = body / (body + stock.lowerShadow());

		upperMatch = upperMatch < 0.5 ? upperMatch / 2 : upperMatch;
		upperMatch = upperMatch > 0.8 ? upperMatch = 1 : upperMatch;

		lowerMatch = lowerMatch < 0.5 ? lowerMatch / 2 : lowerMatch;
		lowerMatch = lowerMatch > 0.8 ? lowerMatch = 1 : lowerMatch;

		return (upperMatch + lowerMatch) / 2;
	}
}
