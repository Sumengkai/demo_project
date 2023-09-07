package com.example.demo_project.entity;

public class Count_5 {
	private int number1;
	private int number2;
	private String sign;

	public Count_5() {
	}
	public Count_5(int number1,String sign,int number2) {
		this.number1 = number1;
		this.sign = sign;
		this.number2 = number2;
	}

	

	public int getNumber1() {
		return number1;
	}
	public int setNumber1(int number1) {
		return this.number1 = number1;
	}
	public int getNumber2() {
		return number2;
	}
	public int setNumber2(int number2) {
		return this.number2 = number2;
	}
	public String getSign() {
		return sign;
	}
	public String setSign(String sign) {
		return this.sign = sign;
	}
//	public double Add() {
////		double f1 = (number1 - number2);
////		String a = "%d+%d=%d",number1,number2,f11;
////		return   a;
//	}

	public String Minus() {
		String a = number1 + " - " + number2 + " = " + (number1 - number2);
		return a;
	}

	public String Multi() {
		String a = number1 + " * " + number2 + " = " + (number1 * number2);
		return a;
	}

	public String Division() {
		String a = number1 + " กา " + number2 + " = " + ((double)number1 / (double)number2);
		return a;
	}

	public String Mod() {
		String a = number1 + " กา " + number2 + " พlผฦ = " + (number1 % number2);
		return a;
	}
}

