package pl.edu.pw.mini.msi;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.OHLCDataItem;
import org.jfree.data.xy.XYDataset;

import pl.edu.pw.mini.msi.utils.StockPrice;

public class CandlestickChart extends JFrame {

	public CandlestickChart(String stockSymbol, List<StockPrice> data) {
		super(stockSymbol);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		DateAxis domainAxis = new DateAxis("Date");
		NumberAxis rangeAxis = new NumberAxis("Price");
		CandlestickRenderer renderer = new CandlestickRenderer();
		XYDataset dataset = getOHLCData(data);

		XYPlot mainPlot = new XYPlot(dataset, domainAxis, rangeAxis, renderer);

		renderer.setSeriesPaint(0, Color.BLACK);
		renderer.setDrawVolume(false);
		rangeAxis.setAutoRangeIncludesZero(false);

		JFreeChart chart = new JFreeChart(stockSymbol, null, mainPlot, false);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(600, 300));

		this.add(chartPanel);
		this.pack();
	}

	private AbstractXYDataset getOHLCData(List<StockPrice> data) {
		int n = data.size();
		OHLCDataItem[] dataset = new OHLCDataItem[n];

		long now = new Date().getTime();

		for (int i = 0; i < n; i++)
			dataset[i] = new OHLCDataItem(new Date(now
					- ((n - i) * 24 * 3600 * 1000)), data.get(n - i - 1).open,
					data.get(n - i - 1).high, data.get(n - i - 1).low,
					data.get(n - i - 1).close, 1);

		return new DefaultOHLCDataset("", dataset);
	}
}
