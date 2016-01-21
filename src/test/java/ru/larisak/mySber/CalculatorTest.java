package ru.larisak.mySber;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import ru.yandex.qatools.allure.annotations.Step;

@RunWith(Parameterized.class)
public class CalculatorTest {
	private BigDecimal inputNumber1;
	private BigDecimal inputNumber2;
	private String operation;
	private BigDecimal expectedResult;
	private int scale = 10;

	
	public CalculatorTest(BigDecimal inputNumber1, BigDecimal inputNumber2, String operation,
			BigDecimal expectedResult) {
		this.inputNumber1 = inputNumber1;
		this.inputNumber2 = inputNumber2;
		this.operation = operation;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection calcParams() {
		ArrayList aList = new ArrayList();

		String fileName = "inputData.txt";
		try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {

			String calcString;
			try {
				while ((calcString = input.readLine()) != null) {
					try {
						String[] params = calcString.trim().split(";");

						Object[] obj = { new BigDecimal(params[0]), new BigDecimal(params[1]), params[2],
								new BigDecimal(params[3]) };

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
		try {
		switch (operation) {
		case "+":
			assertEquals(expectedResult, Calculator.add(inputNumber1, inputNumber2));
			break;
		case "-":
			assertEquals(expectedResult, Calculator.sub(inputNumber1, inputNumber2));
			break;
		case "*":
			assertEquals(expectedResult, Calculator.mul(inputNumber1, inputNumber2));
			break;
		case "/":
			assertEquals(expectedResult, Calculator.div(inputNumber1, inputNumber2, scale));
			break;
		default:
			System.err.println("Недопустимая операция. ");
		}
		} catch (Exception e) {
			System.err.println("Calculation Exception");
		}
		
	}
	@Step("Calculate:  operand1 = {0}, operand2 = {1}, operation = {2}, expected result = {3}")
	private void print_params(BigDecimal inputNumber12, BigDecimal inputNumber22, String operation2,
			BigDecimal expectedResult2) {
		// для вывода параметров теста
		
	}
}