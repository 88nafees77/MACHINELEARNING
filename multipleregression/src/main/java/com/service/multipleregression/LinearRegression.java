package com.service.multipleregression;

public class LinearRegression {

	double[] beta;

	IOptimizer optimizer;

	public LinearRegression(IOptimizer optimizer) {
		this.optimizer = optimizer;
	}

	public void initializeCoefficients(double coefficients[]) {
		this.beta = coefficients;
	}

	public void training(double x[][], double y[]) {
		optimizer.optimize(beta, x, y);
	}

	public double[] getCoefficients() {
		return this.beta;
	}

}
