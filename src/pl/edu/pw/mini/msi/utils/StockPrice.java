package pl.edu.pw.mini.msi.utils;

public class StockPrice {
	public double open;
	public double high;
	public double low;
	public double close;

	public StockPrice(double open, double high, double low, double close) {
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
	}

	public StockPrice(String open, String high, String low, String close) {
		this.open = Double.valueOf(open);
		this.high = Double.valueOf(high);
		this.low = Double.valueOf(low);
		this.close = Double.valueOf(close);
	}

	public boolean isBlack() {
		return body() < 0;
	}

	public boolean isWhite() {
		return body() > 0;
	}

	public double body() {
		return close - open;
	}

	public double upperShadow() {
		return high - Math.max(open, close);
	}

	public double lowerShadow() {
		return Math.min(open, close) - low;
	}

}
