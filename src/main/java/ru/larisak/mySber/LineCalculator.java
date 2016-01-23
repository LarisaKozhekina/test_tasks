package ru.larisak.mySber;

import java.math.BigDecimal;

public final class LineCalculator {

	public static float doCalculate(String calcString) throws Exception {
		String[] params = calcString.trim().split(";");
		if (params.length < 3) {
			System.out.print("Недостаточное количество аргументов. ");
			throw new Exception("Недостаточное количество аргументов");
		}
		int number1;
		int number2;
		try {
			number1 = Integer.parseInt(params[0]);
		} catch (NumberFormatException e ){
			System.out.print("1ый операнд - не целое число или ");
			System.out.print("не удовлетворяет условиям: -2147483648 <= number <= 2147483647. ");
			throw new Exception(e);
		} finally {}
		try {
			number2 = Integer.parseInt(params[1]);
		} catch (NumberFormatException e ){
			System.out.print("2-ой операнд - не целое число или ");
			System.out.print("не удовлетворяет условиям: -2147483648 <= number <= 2147483647. ");
			throw new Exception(e);
		} finally {}
		switch (params[2]) {
		case "+":
			return Calculator.add(number1, number2);
		case "-":
			return Calculator.sub(number1, number2);
		case "*":
			return Calculator.mul(number1, number2);
		case "/":
			try {
				return Calculator.div(number1, number2);
			} catch (ArithmeticException e) {
				System.out.print("Деление на 0. ");
				throw new Exception(e);
			}
		default:
			System.out.print("Недопустимая операция. ");
			throw new Exception("Недопустимая операция");

		}
	}

}
