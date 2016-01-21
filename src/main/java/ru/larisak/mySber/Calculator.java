package ru.larisak.mySber;

import java.math.BigDecimal;

public final class Calculator {
	public static BigDecimal add(BigDecimal a, BigDecimal b){
		return a.add(b); 
	}
	public static BigDecimal sub(BigDecimal a, BigDecimal b){
		return a.subtract(b);
	}
	public static BigDecimal mul(BigDecimal a, BigDecimal b){
		return a.multiply(b);
	}
	public static BigDecimal div(BigDecimal a, BigDecimal b, int accuracy) throws ArithmeticException{
		//будет exception, если b = 0
		return a.divide(b, accuracy, BigDecimal.ROUND_HALF_UP);
	}
}