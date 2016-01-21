package ru.larisak.mySber;

import java.math.BigDecimal;

public final class LineCalculator {
	public static int accuracy = 10;

	public static BigDecimal doCalculate(String calcString) throws Exception {
		String[] params = calcString.trim().split(";");
		if (params.length < 3)
			throw new Exception("Недостаточное количество аргументов");
		BigDecimal number1 = new BigDecimal(params[0]);
		BigDecimal number2 = new BigDecimal(params[1]);
		switch (params[2]) {
		case "+":
			return Calculator.add(number1, number2);
		case "-":
			return Calculator.sub(number1, number2);
		case "*":
			return Calculator.mul(number1, number2);
		case "/":
			return Calculator.div(number1, number2, accuracy);
		default:
			System.out.print("Недопустимая операция. ");
			throw new Exception("Недопустимая операция");

		}
	}

}
