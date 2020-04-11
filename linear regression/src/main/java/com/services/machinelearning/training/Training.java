package com.services.machinelearning.training;

public class Training {

	float beta0, beta1;

	float alpha;

	float y_pred[];

	public Training(float beta0, float beta1, float alpha) {
		this.beta0 = beta0;

		this.beta1 = beta1;

		this.alpha = alpha;
	}

	MathOperation operation = new MathOperation();

	public void training(float x[], float y[]) {

		for (int i = 0; i < 10; i++) {

			y_pred = operation.matrixMultiply(beta0, x);

			y_pred = operation.matrixAddition(beta1, y_pred);

			System.out.println("jBita " + Jbeta(y));

			beta0 = beta0 - alpha * beta0Update(y, x);

			beta1 = beta1 - alpha * beta1Update(y, x);

		}
		System.out.println("bita0 " + beta0);

		System.out.println("bita1 " + beta1);

		evaluate(y);

	}

	public void yPredict(float x[]) {
		y_pred = operation.matrixMultiply(beta0, x);

		y_pred = operation.matrixAddition(beta1, y_pred);

	}

	public float Jbeta(float y[]) {

		float n = 2 * (float) y.length;

		float sum = 0;

		for (int i = 0; i < y.length; i++) {

			float value = (float) Math.pow((y_pred[i] - y[i]), 2);

			sum = sum + value;
		}

		return sum / n;
	}

	public float beta0Update(float y[], float x[]) {

		float sum = 0;

		float n = (float) x.length;

		for (int i = 0; i < x.length; i++) {

			sum = sum + (y_pred[i] - y[i]);
		}

		return sum / n;
	}

	public float beta1Update(float y[], float x[]) {

		float sum = 0;

		float n = (float) x.length;

		for (int i = 0; i < x.length; i++) {

			sum = sum + ((y_pred[i] - y[i]) * x[i]);
		}

		return sum / n;

	}

	public float calculateRMSE(float y[]) {

		float sum = 0;

		float n = (float) y.length;

		for (int i = 0; i < y.length; i++) {

			sum = (float) (sum + Math.pow((y_pred[i] - y[i]), 2));
		}

		return (float) Math.sqrt(sum / n);
	}

	public void evaluate(float y[]) {

		float sst = (float) Math.pow((operation.sumOfInput(y) - (operation.sumOfInput(y) / (float) y.length)), 2);
		float ssr = (float) Math.pow((operation.sumOfInput(y_pred) - operation.sumOfInput(y)), 2);
		System.out.println("rmse	" + calculateRMSE(y));
		System.out.println("sst	" + sst);
		System.out.println("ssr	" + ssr);
		System.out.println("r-sqr " + (1 - (ssr / sst)));
	}
}
