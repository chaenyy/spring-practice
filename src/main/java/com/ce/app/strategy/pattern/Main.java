package com.ce.app.strategy.pattern;

public class Main {
	public static void main(String[] args) {
		Person p1 = new Person("철수", new Dog("구리구리"));
		Person p2 = new Person("영희", new Cat("두리두리"));
		
		System.out.println(p1);
		System.out.println(p2);
		
		// Person이 가질 수 있는 반려동물 Class 이후에 추가될 수 있음
		Person p3 = new Person("맹구", new Snake("쉬리릭"));
		System.out.println(p3);
	}
}
