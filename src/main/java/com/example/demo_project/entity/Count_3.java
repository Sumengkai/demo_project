package com.example.demo_project.entity;

public class Count_3 {
	private float number1;
	private float number2;
	private String sign;

	public Count_3() {
	}
	public Count_3(float number1,String sign,float number2) {
		this.number1 = number1;
		this.sign = sign;
		this.number2 = number2;
	}

	public float getNumber1() {
		return number1;
	}
	
	public float setNumber1(double number1) {
		return this.number1 = (float) number1;
	}
	
	public float getNumber2() {
		return number2;
	}
	
	public float setNumber2(double number2) {
		return this.number2 = (float) number2;
	}
	
	public String getSign() {
		return sign;
	}
	
	public String setSign(String sign) {
		return this.sign = sign;
	}
	
	public String Add() {
		String a = number1 + "+" + number2 + "=" + (number1 + number2);
		return a;
	}

	public String Minus() {
		String a = number1 + " - " + number2 + " = " + (number1 - number2);
		return a;
	}

	public String Multi() {
		String a = number1 + " * " + number2 + " = " + (number1 * number2);
		return a;
	}

	public String Division() {
		String a = number1 + " กา " + number2 + " = " + (number1 / number2);
		return a;
	}

	public String Mod() {
		String a = number1 + " กา " + number2 + " พlผฦ = " + (number1 % number2);
		return a;
	}
}
