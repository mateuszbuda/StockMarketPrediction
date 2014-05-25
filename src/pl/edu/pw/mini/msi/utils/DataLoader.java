package pl.edu.pw.mini.msi.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import pl.edu.pw.mini.msi.CandlestickChart;

public class DataLoader {
	private static final int DAY = 24 * 3600 * 1000;
	private static final int PERIOD = 21;

	CandlestickChart chart;
	ArrayList<StockPrice> data = new ArrayList<>();

	public ArrayList<StockPrice> loadData(String stockSymbol) {
		data.clear();
		Calendar from = Calendar.getInstance(), to = Calendar.getInstance();
		from.setTimeInMillis(to.getTimeInMillis() - PERIOD * DAY);

		try {
			String strUrl = "http://ichart.finance.yahoo.com/table.csv?s="
					+ stockSymbol + "&a=" + from.get(Calendar.MONTH) + "&b="
					+ from.get(Calendar.DAY_OF_MONTH) + "&c="
					+ from.get(Calendar.YEAR) + "&d=" + to.get(Calendar.MONTH)
					+ "&e=" + to.get(Calendar.DAY_OF_MONTH) + "&f="
					+ to.get(Calendar.YEAR) + "&g=d&ignore=.csv";
			URL url = new URL(strUrl);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream()));
			DateFormat df = new SimpleDateFormat("y-M-d");

			String inputLine;
			in.readLine();
			while ((inputLine = in.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(inputLine, ",");

				Date date = df.parse(st.nextToken()); // ignored
				double open = Double.parseDouble(st.nextToken());
				double high = Double.parseDouble(st.nextToken());
				double low = Double.parseDouble(st.nextToken());
				double close = Double.parseDouble(st.nextToken());
				double volume = Double.parseDouble(st.nextToken()); // ignored

				StockPrice item = new StockPrice(open, high, low, close);
				data.add(item);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		chart = new CandlestickChart(stockSymbol, data);
		chart.setVisible(true);

		return data;
	}
}
