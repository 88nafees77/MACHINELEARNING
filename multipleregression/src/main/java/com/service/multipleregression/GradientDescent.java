package com.service.multipleregression;

public class GradientDescent implements IOptimizer {

	double learningRate;

	int epoch;

	public GradientDescent(double learningRate, int epoch) {

		this.learningRate = learningRate;

		this.epoch = epoch;
	}

	public void optimize(double beta[], double x[][], double y[]) {

		double betanew[] = new double[beta.length];

		for (int j = 0; j < beta.length; j++) {

			betanew[j] = beta[j];
		}

		for (int i = 0; i < epoch; i++) {

			for (int k = 0; k < beta.length; k++) {

				beta[k] = betanew[k];

			}
			// System.out.println("cost Value " + costFunction(beta, x, y));

			for (int k = 0; k < beta.length; k++) {

				betanew[k] = beta[k] - learningRate * betaUpdate(y, x, beta, k);

			}

		}

	}

	public double yPredict(double x[][], double beta[], int i) {

		double sum = beta[0];

		for (int j = 1; j < x[0].length; j++) {
			sum = sum + beta[j] * x[i][j];
		}

		return sum;

	}

	public double costFunction(double[] beta, double[][] x, double[] y) {
		// TODO Auto-generated method stub

		double len = (double) y.length;

		double sum = 0;

		for (int i = 0; i < len; i++) {

			float value = (float) Math.pow((yPredict(x, beta, i) - y[i]), 2);

			sum = sum + value;
		}

		return sum / (2 * len);

	}

	public double betaUpdate(double y[], double x[][], double beta[], int j) {

		double sum = 0;

		double len = (double) y.length;

		for (int i = 0; i < len; i++) {

			sum = sum + ((yPredict(x, beta, i) - y[i]) * x[i][j]);
		}

		return sum / len;

	}

}
