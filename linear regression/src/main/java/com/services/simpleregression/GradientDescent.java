package com.services.simpleregression;

public class GradientDescent implements IOptimizer {

	float learningRate;

	int epoch;

	public GradientDescent(float learningRate, int epoch) {

		this.learningRate = learningRate;

		this.epoch = epoch;
	}

	public void optimize(float coefficients[], float x[], float y[]) {

		float betanew[] = new float[coefficients.length];

		for (int j = 0; j < coefficients.length; j++) {

			betanew[j] = coefficients[j];
		}

		for (int i = 0; i < epoch; i++) {

			coefficients[0] = betanew[0];

			coefficients[1] = betanew[1];

			betanew[0] = coefficients[0] - learningRate * beta0Update(y, x, coefficients);

			betanew[1] = coefficients[1] - learningRate * beta1Update(y, x, coefficients);

		}

	}

	public float yPredict(float x, float coefficients[]) {

		return coefficients[0] + coefficients[1] * x;

	}

	public void costFunction(float[] coefficients, float[] x, float[] y) {
		// TODO Auto-generated method stub

		float len = (float) y.length;

		float sum = 0;

		for (int i = 0; i < len; i++) {

			float value = (float) Math.pow((yPredict(x[i], coefficients) - y[i]), 2);

			sum = sum + value;
		}

		// return sum / (2 * len);

	}

	public float beta0Update(float y[], float x[], float coefficients[]) {

		float sum = 0;

		for (int i = 0; i < y.length && i < x.length; i++) {

			sum = sum + (yPredict(x[i], coefficients) - y[i]);
		}

		return sum / (float) y.length;
	}

	public float beta1Update(float y[], float x[], float coefficients[]) {

		float sum = 0;

		float len = (float) y.length;

		for (int i = 0; i < len; i++) {

			sum = sum + ((yPredict(x[i], coefficients) - y[i]) * x[i]);
		}

		return sum / len;

	}

}
