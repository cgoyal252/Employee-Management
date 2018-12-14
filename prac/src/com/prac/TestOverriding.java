package com.prac;

class A
{
	private void demo1()
	{
		System.out.println("AA");
	}
	protected void demo2()
	{
		System.out.println("AA");
	}
}

public class TestOverriding extends A {

	private void demo()
	{
		System.out.println("Test");
	}
	
	public static void main(String[] args) {
		TestOverriding a=new TestOverriding();
		a.demo();
	}
	
}
