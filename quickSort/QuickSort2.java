package quickSort;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class QuickSort2 {
	int count;

	/**
	 * @param a
	 * @param start
	 *            排序开始位，以0开始计数
	 * @param end
	 *            没能实现， 因为 派到最后几位会出问题 比如
	 */
	public void random_partition(int[] a, int start, int end) {
		if (start < end) {
			count++;
			Random r = new Random();
			int poirt_index = r.nextInt(end - start) + start;
			// int poirt_index = start;
			System.out.println("start:" + start + " end：" + end
					+ " poirt_index：" + poirt_index);
			// 把基数方最后
			swap(a, poirt_index, end);
			// i指针指向交换的位置
			int i = start;
			// 把所有比基数小的数放左边
			// 从第start+1位开始比较，到倒数第二位结束 这里的i必须从第一个开始，那样如果开头遇到小的就没有变顺序，i指针作用是确定每个左边的值都比基数小
			for (int j = start; j < end; j++) {
				if (a[end] > a[j]) {
					// 从strat的第二位开始交换
					swap(a, i++, j);
				}
			}
			// 基数位置确定，把位于最后的基数换回来
			swap(a, i, end);
			random_partition(a, start, i - 1);
			random_partition(a, i + 1, end);
		}
	}

	public void swap(int[] a, int i, int j) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		System.out.println(Arrays.toString(a));
	};

	@Test
	public void testQuicksort() {
		// i++ 是先判断 在加1
		// int[] a = { 24, 5, 1, 2, 5, 7, 8, 5, 3, 7, 63, 9, 0, 42, 3, 8, 24, 1
		// };
		int[] a = { 5, 4, 3, 2, 1 };
		long start = System.currentTimeMillis();
		random_partition(a, 0, a.length - 1);
		long end = System.currentTimeMillis();
		System.out.println(Arrays.toString(a));
		System.out.println("嵌套次数：" + count + "用时" + (end - start));
	}

	@Test
	public void test_random() {
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			// nextInt(2)表示随机数的范围 默认从0开始不超过给定的数
			System.out.println(r.nextInt(2));
		}

	}

}
