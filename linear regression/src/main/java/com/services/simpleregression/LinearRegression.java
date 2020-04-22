package com.services.simpleregression;

public class LinearRegression {

	float[] coefficients;

	IOptimizer optimizer;

	public LinearRegression(IOptimizer optimizer) {
		this.optimizer = optimizer;
	}

	public void initializeCoefficients(float coefficients[]) {
		this.coefficients = coefficients;
	}

	public void training(float x[], float y[]) {
		optimizer.optimize(coefficients, x, y);
	}

	public float[] getCoefficients() {
		return this.coefficients;
	}

}
