package com.rubberdroid.droidsweeper;

public class Pair {
	public static final Pair NOT_VALID = new Pair(9999, 9999);
	private int a;
	private int b;

	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int a() {
		return a;
	}

	public int b() {
		return b;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Pair) {
			Pair other = (Pair) o;
			return a == other.a && b == other.b;
		}
		return false;
	}
}
