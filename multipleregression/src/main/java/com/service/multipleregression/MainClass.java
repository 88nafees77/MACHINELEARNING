package com.service.multipleregression;

public class MainClass {

	double[][] x = { { 1, 10, 20 }, { 1, 20, 40 }, { 1, 40, 15 }, { 1, 80, 100 }, { 1, 160, 23 }, { 1, 200, 18 } };
	double[] y = { 243, 483, 508, 1503, 1764, 2129 };
	GradientDescent descent = new GradientDescent(0.005f, 1000);
	LinearRegression linearRegression = new LinearRegression(descent);

}
