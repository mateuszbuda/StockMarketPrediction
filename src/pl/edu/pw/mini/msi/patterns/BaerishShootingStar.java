package pl.edu.pw.mini.msi.patterns;

import java.util.ArrayList;

import pl.edu.pw.mini.msi.utils.StockPrice;
import pl.edu.pw.mini.msi.utils.Type;

public class BaerishShootingStar implements Pattern
{
	private final double propTrend = 0.5;
	
	@Override
	public double matchData(ArrayList<StockPrice> data)
	{
		if(data.size()<4)
			return 0;
		// we're looking for following upward trend
		double trend = PatternMatcher.upwardLeadingTrend(data.subList(1, 4));
		StockPrice top = data.get(0);
		double result = trend*propTrend+(1-propTrend)*((top.upperShadow()-top.lowerShadow())/(2*Math.abs(top.body())));
		if (result<0) result = 0;
		if (result>1) result = 1;
		return result;
	}

	@Override
	public String name()
	{
		return "Baerish Shooting Star";
	}

	@Override
	public Type type()
	{
		return Type.BEARISH;
	}
}
