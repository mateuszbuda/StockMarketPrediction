package pl.edu.pw.mini.msi.patterns;

import java.util.ArrayList;

import pl.edu.pw.mini.msi.utils.StockPrice;
import pl.edu.pw.mini.msi.utils.Type;

public class BullishShootingStar implements Pattern 
{
	private final double propTrend = 0.2;
	private final double propCandle = 0.5;
	
	@Override
	public double matchData(ArrayList<StockPrice> data)
	{
		if(data.size()<5)
			return 0;
		// we're looking for following upward trend
		double trend = PatternMatcher.upwardLeadingTrend(data.subList(2, 5));
		double candle = PatternMatcher.whiteCandle(data.get(1));
		StockPrice top = data.get(0);
		double stick = ((top.upperShadow()-top.lowerShadow())/(2*Math.abs(top.body())));
		double result = trend*propTrend+ candle*propCandle + (1-propTrend-propCandle)*stick;
		if (result<0) result = 0;
		if (result>1) result = 1;
		return result;
	}

	@Override
	public String name()
	{
		return "Bullish Shooting Star";
	}

	@Override
	public Type type()
	{
		return Type.BULLISH;
	}
}
