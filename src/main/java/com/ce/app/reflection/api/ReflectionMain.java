package com.ce.app.reflection.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionMain {

	public static void main(String[] args) throws Exception {
		ReflectionMain main = new ReflectionMain();
//		main.test1();
//		main.test2();
		main.test3();
	}

	private void test3() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, NoSuchFieldException {
		Class<Sample> clz = (Class<Sample>) Class.forName("com.ce.app.reflection.api.Sample");
		Sample sample = clz.getDeclaredConstructor(int.class, String.class).newInstance(123, "wow~");
		
		Field num = clz.getDeclaredField("num");
		
		num.setAccessible(true);
		
		Object value = num.get(sample);
		System.out.println(value);
		
		System.out.println(num);
		System.out.println(sample);
	}

	private void test2() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<Sample> clz = Sample.class;
		Method[] methods = clz.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println(method);
		}
		
		Sample sample = clz.getDeclaredConstructor(null).newInstance(null); // 기본생성자
		
		Method setNum = clz.getDeclaredMethod("setNum", int.class);			// Sample의 setNum, 매개인자
		Object returnValue = setNum.invoke(sample, 123); // sample 객체의 setNum에 123을 대입해라!
		
		Method getNum = clz.getDeclaredMethod("getNum");
		returnValue = getNum.invoke(sample);
		
		System.out.println(returnValue);
		System.out.println(sample);
	}

	private void test1() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Sample s1 = new Sample();
		
		Class<Sample> clz1 = Sample.class;
		Class<Sample> clz2 = (Class<Sample>) s1.getClass();
		Class<Sample> clz3 = (Class<Sample>) Class.forName("com.ce.app.reflection.api.Sample");
		
		System.out.println(clz1 == clz2);
		System.out.println(clz2 == clz3);
		
		// 기본 생성자
		Constructor<Sample> const1 = clz1.getDeclaredConstructor(null);
		Sample s2 = const1.newInstance(null);
		System.out.println(s2);
		
		// 파라미터 생성자
		Class[] paremterTypes = {int.class, String.class};
		Constructor<Sample> const2 = clz2.getDeclaredConstructor(paremterTypes); // int, String을 받는 생성자
		Object[] initArgs = {100, "helloworld"};
		Sample s3 = const2.newInstance(initArgs);
		System.out.println(s3);
	}

}
