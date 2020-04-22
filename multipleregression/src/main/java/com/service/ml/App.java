package com.service.ml;

import com.service.multipleregression.GradientDescent;
import com.service.multipleregression.LinearRegression;

public class App {

	public static void main(String args[]) {
		// double[][] x = { { 1, 10, 20 }, { 1, 20, 40 }, { 1, 40, 15 }, { 1, 80, 100 },
		// { 1, 160, 23 }, { 1, 200, 18 } };
		// double[] y = { 243, 483, 508, 1503, 1764, 2129 };

		double x[][] = { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 6 } };
		double[] y = { 1, 2, 4, 5, 4, 6 };
		double[] beta = new double[x[0].length];

		System.out.println(x[0].length);
		for (int i = 0; i < beta.length; i++) {
			// beta[i] = Math.random();
			beta[i] = 1f;
		}
		GradientDescent descent = new GradientDescent(0.0001f, 10000);
		LinearRegression regression = new LinearRegression(descent);
		regression.initializeCoefficients(beta);
		regression.training(x, y);
		for (int i = 0; i < beta.length; i++) {
			System.out.println(beta[i]);
		}
	}

}
