package com.services.machinelearning.training;

public class MathOperation {

	public float[] matrixMultiply(float m, float[] x) {

		float newarr[] = new float[x.length];
		for (int i = 0; i < x.length; i++) {
			newarr[i] = x[i] * m;
		}
		return newarr;

	}

	public float[] matrixAddition(float c, float Y_pred[]) {

		float newarr[] = new float[Y_pred.length];
		for (int i = 0; i < Y_pred.length; i++) {
			newarr[i] = Y_pred[i] + c;
		}
		return newarr;
	}

	public float sumOfInput(float input[]) {

		float sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum = sum + input[i];
		}
		return sum;

	}

	public float calculateMean(float value[]) {

		float sum = 0;
		for (int i = 0; i < value.length; i++) {
			sum = sum + value[i];
		}
		return sum / (float) value.length;
	}

}
