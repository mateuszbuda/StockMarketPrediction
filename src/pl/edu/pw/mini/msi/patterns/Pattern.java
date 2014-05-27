package pl.edu.pw.mini.msi.patterns;

import java.util.ArrayList;

import pl.edu.pw.mini.msi.utils.StockPrice;
import pl.edu.pw.mini.msi.utils.Type;

/**
 * Base interface for all patterns
 * @author budam
 */
public interface Pattern {
	/**
	 * Checks how much the patter fits to data.
	 * 
	 * @return value of match from range [0, 1]
	 */
	public abstract double matchData(ArrayList<StockPrice> data);

	/**
	 * Gets name of pattern
	 * 
	 * @return name of pattern
	 */
	public String name();

	/**
	 * Gets information if pattern predicts rise or fall of stock price
	 * 
	 * @return type of pattern
	 */
	public Type type();
}
