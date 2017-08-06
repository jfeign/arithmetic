package heapSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author Administrator
 *
 *         堆排序
 */
public class HeapSort {
	/****************************************************/
	public int[] heapSort(int[] a) {
		int n = a.length;//定义堆的长度为数组长度
		int[] b = new int[n];// 创建一个数组用来存放排序好的元素
		// 建立堆
		for (int i = (n / 2); i > 0; i--) {
			sortDown(a, a.length, i);
		}
		// 删除顶元素,放入新数组中
		for (int i = 0; i < a.length; i++) {
			b[i] = a[0];
			if (n > 0) {
				a[0] = a[--n];// 把最末的数放到堆首位, 用--n 是因为数组的下标和堆不一样，要先少1
				sortDown(a, n, 1);
			}
		}
		return b;
	}

	/**
	 * @param a
	 *            堆所在的数组
	 * @param n
	 *            堆的长度
	 * @param i
	 *            需要调整的序号
	 */
	private void sortDown(int[] a, int n, int i) {
		// t用来记录当前的最大的节点数
		int t = i;
		// 如果i存在左子节点
		while ((i * 2) <= n) {
			t = a[i - 1] < a[2 * i - 1] ? i : (2 * i);
			// 如果存在右子节点
			if ((2 * i + 1) <= n) {
				t = a[t - 1] < a[2 * i] ? t : (2 * i + 1);
			}
			if (t != i) {
				int temp = a[i - 1];
				a[i - 1] = a[t - 1];
				a[t - 1] = temp;
				// 继续向下调整
				i = t;
			} else {
				return;
			}
		}
	}
	/****************************************************/

	/**
	 * 要排序的数组
	 */
	private int[] a;
	/**
	 * 默认堆的长度，从0 到n
	 */
	private int n;
	/**
	 * 存储排序好的数组
	 */
	private List<Integer> b = new ArrayList<Integer>();

	/**
	 * 堆排序
	 */
	public List<Integer> heapsort(int[] a) {
		this.a = a;
		n = a.length;
		creatHeap();
		for (int i = 0; i < a.length; i++) {
			deleteFirst();
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = b.get(i);
		}
		return b;
	}

	/**
	 * 删除最小元素
	 * 
	 * @param a
	 * @param n
	 * 
	 */
	private void deleteFirst() {
		b.add(a[0]);
		// 把最末的数放到堆首位
		// 用--n 是因为数组的下标和堆不一样，默认长度-1
		if (n > 0) {
			a[0] = a[--n];
			sortDown(1);
		}
	}

	/**
	 * @param i
	 *            传来开始向下调整的序号 向下调整 为最小堆
	 * 
	 *            分析： i的 左子节点 2i 右子节点 2i+1
	 */
	private void sortDown(int i) {
		// t用来记录当前的最大的节点数
		int t = i;
		// 如果i存在左子节点
		while ((i * 2) <= n) {
			t = a[i - 1] < a[2 * i - 1] ? i : (2 * i);
			// 如果存在右子节点
			if ((2 * i + 1) <= n) {
				t = a[t - 1] < a[2 * i] ? t : (2 * i + 1);
			}
			if (t != i) {
				swap(a, i - 1, t - 1);
				// 继续向下调整
				i = t;
			} else {
				return;
			}
		}
	}

	/**
	 * n为堆的边界
	 *  创建堆
	 */
	private void creatHeap() {
		for (int i = (n / 2); i > 0; i--) {
			sortDown(i);
		}
	}

	private void swap(int[] a, int i, int j) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	@Test
	public void test() {
		// i++ 是先判断 在加1
		int[] a = { 24, 5, 1, 2, 24, 5, 1, 2, 5, 7, 8, 5, 3, 7, 63, 9, 0, 42,
				3, 8, 24, 1 };
		// int[] a = { 5, 4, 3, 2, 1 };
		long start = System.currentTimeMillis();
		System.out.println(Arrays.toString(heapSort(a)));
		long end = System.currentTimeMillis();
		System.out.println("用时:" + (end - start));
	}
}
