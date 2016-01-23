package ru.larisak.mySber;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import ru.yandex.qatools.allure.annotations.Step;

@RunWith(Parameterized.class)
public class CalculatorTest {
	private int inputNumber1;
	private int inputNumber2;
	private String operation;
	private String expectedResult;

	public CalculatorTest(int inputNumber1, int inputNumber2, String operation, String expectedResult) {
		this.inputNumber1 = inputNumber1;
		this.inputNumber2 = inputNumber2;
		this.operation = operation;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> calcParams() {
		ArrayList<Object[]> aList = new ArrayList<Object[]>();

		String fileName = "inputData.txt";
		try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {

			String calcString;
			try {
				while ((calcString = input.readLine()) != null) {
					try {
						String[] params = calcString.trim().split(";");

						Object[] obj = { Integer.parseInt(params[0]), Integer.parseInt(params[1]), params[2],
								params[3] };

						aList.add(obj);
					} catch (Exception e) {
						System.out.println("Некорректные данные");
					}
				}
			} catch (IOException e) {
				System.out.println("Ошибка чтения из файла");
			} finally {
				input.close();

			}
		} catch (IOException e) {
			System.err.println("File \"" + fileName + "\" not found");
			e.printStackTrace();
		}

		return aList;
	}

	@Test
	public void testCalculator() {
		print_params(inputNumber1, inputNumber2, operation, expectedResult);
		switch (operation) {
		case "+":
			assertEquals(Float.parseFloat(expectedResult), Calculator.add(inputNumber1, inputNumber2), 0.000001);
			break;
		case "-":
			assertEquals(Float.parseFloat(expectedResult), Calculator.sub(inputNumber1, inputNumber2), 0.000001);
			break;
		case "*":
			assertEquals(Float.parseFloat(expectedResult), Calculator.mul(inputNumber1, inputNumber2), 0.000001);
			break;
		case "/":
			try {
				Calculator.div(inputNumber1, inputNumber2);
				assertEquals(Float.parseFloat(expectedResult), Calculator.div(inputNumber1, inputNumber2), 0.000001);
			} catch (ArithmeticException e) {
				assertEquals(expectedResult, "Error");
			}
			break;
		default:
			System.err.println("Недопустимая операция. ");
		}

	}

	@Step("Calculate:  operand1 = {0}, operand2 = {1}, operation = {2}, expected result = {3}")
	private void print_params(int inputNumber11, int inputNumber22, String operation2, String expectedResult2) {
		// для вывода параметров теста

	}
}