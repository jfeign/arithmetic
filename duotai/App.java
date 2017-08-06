package duotai;

import org.junit.Test;

public class App {

	public static void main(String args[]) {
		Father f = new SonA();
		// 此处调用 已重写的 子方法
		f.method();
		f = new SonB();
		f.method();
		f.methodFather();
		f = (Father) f;
		// 此处底层还是调用的是 sonB;
		f.method();
	}

	@Test
	public void testSizeof() {
		boolean a;
		byte b;
		char c;
		short d;
		int e;
		float f;
		long g;
		double h;
		System.out.println(Byte.SIZE / 8);
		System.out.println(Short.SIZE / 8);
		System.out.println(Character.SIZE / 8);
		System.out.println(Integer.SIZE / 8);
		System.out.println(Float.SIZE / 8);
		System.out.println(Long.SIZE / 8);
		System.out.println(Double.SIZE / 8);
	}
}
