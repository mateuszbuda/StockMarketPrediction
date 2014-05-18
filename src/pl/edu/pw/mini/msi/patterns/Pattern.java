package pl.edu.pw.mini.msi.patterns;

import java.util.ArrayList;

import pl.edu.pw.mini.msi.utils.StockPrice;
import pl.edu.pw.mini.msi.utils.Type;

public interface Pattern {
	public abstract double matchData(ArrayList<StockPrice> data);

	public String name();

	public Type type();
}
