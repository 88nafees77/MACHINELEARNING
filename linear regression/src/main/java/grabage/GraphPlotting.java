package grabage;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GraphPlotting extends ApplicationFrame {

	public GraphPlotting(String title) {
		super(title);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void createPlot(float x[], float y[]) {
		final XYSeries series = new XYSeries("Random Data");
		for (int i = 0; i < x.length; i++) {
			series.add(x[i], y[i]);
		}
		final XYSeriesCollection data = new XYSeriesCollection(series);
		final JFreeChart chart = ChartFactory.createXYLineChart("XY Series Demo", "X", "Y", data,
				PlotOrientation.VERTICAL, true, true, true);

		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);

	}

//****************************************************************************

	/**
	 * Starting point for the demonstration application.
	 *
	 * @param args ignored.
	 */
//	public static void main(final String[] args) {
//
//		final GraphPlotting demo = new GraphPlotting("Graph");
//		demo.pack();
//		RefineryUtilities.centerFrameOnScreen(demo);
//		demo.setVisible(true);
//
//	}

}
