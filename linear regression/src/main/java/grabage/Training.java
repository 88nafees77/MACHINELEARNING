package grabage;

import org.jfree.ui.RefineryUtilities;

public class Training {

	// GNU plot

	float alpha;

	float y_pred[];

	public Training(float alpha) {

		this.alpha = alpha;
	}

	public void training(float x[], float y[], float beta[]) {

		float betanew[] = new float[beta.length];

		for (int j = 0; j < beta.length; j++) {

			betanew[j] = beta[j];
		}

		for (int i = 0; i < 1000; i++) {

			beta[0] = betanew[0];

			beta[1] = betanew[1];

			betanew[0] = beta[0] - alpha * beta0Update(y, x, beta);

			betanew[1] = beta[1] - alpha * beta1Update(y, x, beta);

		}

	}

	public float yPredict(float x, float beta[]) {

		return beta[0] + beta[1] * x;

	}

	public float Jbeta(float y[], float x[], float beta[]) {

		float len = (float) y.length;

		float sum = 0;

		for (int i = 0; i < len; i++) {

			float value = (float) Math.pow((yPredict(x[i], beta) - y[i]), 2);

			sum = sum + value;
		}

		return sum / (2 * len);
	}

	public float beta0Update(float y[], float x[], float beta[]) {

		float sum = 0;

		float len = (float) y.length;

		for (int i = 0; i < len; i++) {

			sum = sum + (yPredict(x[i], beta) - y[i]);
		}

		return sum / len;
	}

	public float beta1Update(float y[], float x[], float beta[]) {

		float sum = 0;

		float len = (float) y.length;

		for (int i = 0; i < len; i++) {

			sum = sum + ((yPredict(x[i], beta) - y[i]) * x[i]);
		}

		return sum / len;

	}

//	public float calculateRMSE(float y[]) {
//
//		float sum = 0;
//
//		float n = (float) y.length;
//
//		for (int i = 0; i < y.length; i++) {
//
//			sum = (float) (sum + Math.pow((yPredict(y[i]) - y[i]), 2));
//		}
//
//		return (float) Math.sqrt(sum / n);
//	}

//	public void evaluate(float y[]) {
//
//		float sst = (float) Math.pow((operation.sumOfInput(y) - (operation.sumOfInput(y) / (float) y.length)), 2);
//		float ssr = (float) Math.pow((operation.sumOfInput(y_pred) - operation.sumOfInput(y)), 2);
//		System.out.println("rmse	" + calculateRMSE(y));
//		System.out.println("sst	" + sst);
//		System.out.println("ssr	" + ssr);
//		System.out.println("r-sqr " + (1 - (ssr / sst)));
//	}
}
