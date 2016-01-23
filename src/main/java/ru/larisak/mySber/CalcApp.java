package ru.larisak.mySber;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class CalcApp {

	public static void main(String[] args) throws Exception {

		String fileName = "inputData.txt";
		try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
			System.out.println("Начинается обработка файла " + fileName);
			System.out.println("------------------------------------- ");
			String calcString;
			try {
				while ((calcString = input.readLine()) != null) {
					System.out.print(calcString + " = ");
					try {
						float result = LineCalculator.doCalculate(calcString);
						System.out.println(result);
					} catch (Exception e) {
						System.out.println("Error");
					}
				}
				System.out.println("------------------------------------- ");
				System.out.println("Обработка файла закончена");
			} catch (IOException e) {
				System.out.println("Ошибка чтения из файла");
			} finally {
				input.close();

			}
		} catch (FileNotFoundException e) {
			System.err.println("File \"" + fileName + "\" not found");
			e.printStackTrace();
		}
	}
}
