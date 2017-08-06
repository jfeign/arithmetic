package duotai;

import org.junit.Test;

public class TestIndexFunction {
	@Test
	public void testIndex() throws Exception {
		// 目的 求 2的 多少次方第一次超过一万
		int count = 1;
		/*
		 * while((index(2,count)<10000)){ count++; } System.out.println(count);
		 * System.out.println(index(2,14));
		 */

		if (index(2, count) < 10000) {
			count++;
		}
		System.out.println(count);
	}

	/**
	 * 指数函数
	 * 
	 * @param di
	 *            底数
	 * @param zhi
	 *            指数
	 * @return
	 */
	private static long index(int di, int zhi) {
		long result = 1;
		for (int i = 0; i < zhi; i++) {
			result = result * di;
		}
		return result;
	}

}
