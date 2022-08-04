package com.ce.app.strategy.pattern;

public abstract class Pet {
	protected String name; // 반려동물 이름

	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pet(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String className = this.getClass().getName();
		return className.substring(className.lastIndexOf(".")+1) + " [name=" + name + "]";
	}
}
