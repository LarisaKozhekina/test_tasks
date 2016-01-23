package ru.larisak.mySber;

public final class Calculator {
	public static float add(int a, int b){
		return a+b; 
	}
	public static float sub(int a, int b){
		return a-b;
	}
	public static float mul(int a, int b){
		return a*b;
	}
	public static float div(int a, int b) throws ArithmeticException{
		if( b == 0 ) {
			throw new ArithmeticException();
		}		
		return (float)a/b;
	}
}