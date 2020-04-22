package grabage;

import java.util.Arrays;
import java.util.List;

import org.jfree.chart.renderer.category.LineRenderer3D;

import com.services.simpleregression.DataInput;
import com.services.simpleregression.GradientDescent;
import com.services.simpleregression.LinearRegression;
import com.services.simpleregression.ReadFromFile;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

//		ReadFromFile readFromFile = new ReadFromFile("/home/nafees-abdullah/Desktop/data.csv");
//		DataInput input = new DataInput(readFromFile);
//		List<String[]> list = input.inputReader(",");
//		float x[] = new float[list.size()];
//		float y[] = new float[list.size()];
//		int i = 0;
//		for (String str[] : list) {
//			x[i] = Float.parseFloat(str[0]);
//			y[i] = Float.parseFloat(str[1]);
//			i++;
//
//		}
		int i = 0;

		float x[] = { 1, 2, 3, 4, 5, 6 };
		float y[] = { 1, 2, 4, 5, 4, 6 };
		GradientDescent optimizer = new GradientDescent(0.0001f, 10000);
		LinearRegression linearRegression = new LinearRegression(optimizer);
		float beta[] = new float[2];
		for (i = 0; i < beta.length; i++) {
			// beta[i] = (float) Math.random();
			beta[i] = 1f;
		}
		linearRegression.initializeCoefficients(beta);
		linearRegression.training(x, y);
		System.out.println(beta[0] + " " + beta[1]);

		// y=beta[0]+beta[1]*x

		// System.out.println("y" = "beta[0]" "+" "beta[1]" * "x");

	}
}