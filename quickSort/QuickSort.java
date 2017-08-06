package quickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class QuickSort {
	static int count;

	/**
	 * 测试堆排序和快排的用时 测试结果： 80000个int随机数，堆排16ms（有时跳到31ms），快排最低31ms
	 * 800000个int随机数，堆排188ms，快排93ms， 8000000个int随机数，堆排4102ms，快排951ms，
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 1、生成随随机数列
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Random r = new Random(1);
		for (int i = 0; i < 10000; i++) {
			arr.add(r.nextInt());
//		    arr.add(0);
		}
		Object[] a = arr.toArray();
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = (int) a[i];
		}
		long start = System.currentTimeMillis();
		// heapSort(b);
		quicksort(b, 0, b.length - 1);// 数组长度:100000用时:16
		// selectSort(b); //，数组长度:100000用时:8346
		long end = System.currentTimeMillis();
		long time = end - start;
		// 遇过 bug，是因为 把长度填错了 填成 a.length-1 啦
		System.out.println("排序后，数组长度:" + b.length + "用时:" + time);
		// for (int i : b) {
		// System.out.print(i+",");
		// }
	}

	@Test
	public void testQuicksort() {
		// i++ 是先判断 在加1
		// int[] a = { 24, 5, 1, 2, 5, 7, 8, 5, 3, 7, 63, 9, 0, 42, 3, 8, 24, 1
		// };
		int[] a = { 0, 0, 0, 0, 0, 0, 0, 0 };
		List<Integer> l = new ArrayList<Integer>();

		for (int i = 0; i < 10000; i++) {
			l.add(0);
		}
		long start = System.currentTimeMillis();
		quicksort(a, 0, a.length - 1);
		long end = System.currentTimeMillis();
		System.out.println(Arrays.toString(a));
		System.out.println("嵌套次数：" + count + "用时" + (end - start));
	}

	/**
	 * 快排实现简洁版
	 * 
	 * @param n
	 * @param left
	 * @param right
	 */
	static void quicksort(int[] n, int left, int right) {
		// System.out.println("QuickSort.quicksort()" + (++count));
		count++;
		if (left < right) {
			// 换一个新变量来暂时存储 i表示左指针，j表示右指针
			int i = left, j = right;
			/* 确定一个基准数，并将数按大小置于基准数两边 ** */
			// 1。pivot：基准数， 以左边第一个数为基准数
			int pivot = n[left];// 调用25次 说明从中间开始会 减少空间复杂读
			// int pivot = n[(right-left)>>1];// 以中间位为基准数
			// QuickSort.quicksort()21 调用21次
			while (i < j) {
				// 2。从右开始搜索，比其小的数，
				while (i < j && n[j] >= pivot)
					j--;
				if (i < j)
					// 将其放于基准位
					n[i++] = n[j];
				// 3。再从左向右搜索，比其大的数
				while (i < j && n[i] <= pivot)
					i++;
				if (i < j)
					// 放置右边的坑位
					n[j--] = n[i];
			}
			// 4。搜索完 左右指针相等，将基准数放于该位置。
			n[i] = pivot;
			/* 至此完成一次，把数分于基准数两旁。 以下进行分治，以基准位为分界点，两边的数 递归调用排序 */
			quicksort(n, left, i - 1);
			quicksort(n, i + 1, right);
		}
	}

	/**
	 * @param a
	 *            需要排序的堆
	 * 
	 */
	private static void heapSort(int[] a) {
		// 这里的 b还是引用的 a 所以需要 new一个
		int[] b = new int[a.length];
		// 1.建立堆,从最后一曾开始调整
		for (int i = (a.length >> 1); i >= 1; i--) {
			siftDown(a, i, a.length);
		}
		// 2.开始取数并且调整
		for (int i = a.length - 1; i >= 0; i--) {
			// 第一个数是最大的,取出第一个数
			b[i] = a[0];
			// 把最后一个数放到 根节点，并且重新调整
			a[0] = a[i];
			siftDown(a, 1, i);
		}
		// 再把b里面的值还给 a
		for (int i = 0; i < a.length; i++) {
			a[i] = b[i];
		}
	}

	/**
	 * 向下调整
	 * 
	 * @param a
	 *            需要调整的数组
	 * @param i
	 *            从地i个开始调整
	 * @param n
	 *            定义堆的长度 传入一个需要向下调整的标号 将第i个节点，调整为堆 他的 左子节点为2（i） 右子节点为 2*i+1 ， 先
	 *            从 n/2 开始检查
	 */
	private static void siftDown(int[] a, int i, int n) {
		int t = i;// 存储最大值的 编号
		// 当i节点有子节点时向下执行，
		while (i * 2 <= n) { // 注意，此处应该有等号，否则排序会漏掉最后一个
			// 判断左子节点，t取大的节点 建立最大堆
			if (a[i - 1] < a[i * 2 - 1]) {
				t = i * 2;
			}
			// 如果有右子节点,t取大的节点
			if ((i * 2 + 1) <= n) {
				t = (a[t - 1] > a[i * 2]) ? t : (i * 2 + 1);
			}
			// 如果t等于其本身则，说明已经调整完毕
			if (t == i) {
				break;
			} else {
				// 否则交换，并且 把t给i 继续向下调整
				a[i - 1] = a[t - 1] + a[i - 1];
				a[t - 1] = a[i - 1] - a[t - 1]; // 此时 a[t]就是a[i]
				a[i - 1] = a[i - 1] - a[t - 1];
				i = t;
			}
		}
	};

	/**
	 * @param values
	 * @param left
	 * @param right
	 */
	public static void quicksort2(int[] values, int left, int right) {
		// 基准数
		count++;
		if (left < right) {
			// 基准数
			int dp = partition2(values, left, right);
			quicksort2(values, left, dp - 1);
			quicksort2(values, dp + 1, right);
		}

	}

	/**
	 * 确定基准数
	 * 
	 * @param values
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partition2(int[] values, int left, int right) {

		int pivot = values[left]; // 右移位相当于除法
		System.out.println("基准数=" + pivot);
		int db = left; // 基准位
		while (left < right) {
			// 先从右边开始 ，直到遇到比基准数小的
			while (left < right && values[right] >= pivot) {
				right--;
			}
			// 再从左边开始 ，遇到比基准数大的
			while (left < right && values[left] <= pivot) {
				left++;
			}
			if (left < right) {
				// 两数交换
				System.out.println("left:" + left + "right:" + right);
				int temp = values[right];
				values[right] = values[left];
				values[left] = temp;
			}
		}
		// 此时left=right
		System.out.println("此时两边相等，left:" + left + "right:" + right);
		// 将基准位与 left交换
		int temp2 = values[left];
		values[left] = values[db];
		values[db] = temp2;

		return left;
	}

	static int partition(int n[], int left, int right) {
		int pivot = n[left];
		while (left < right) {
			while (left < right && n[right] >= pivot)
				right--;
			if (left < right)
				n[left++] = n[right];
			while (left < right && n[left] <= pivot)
				left++;
			if (left < right)
				n[right--] = n[left];
		}
		n[left] = pivot;
		return left;
	}

	static int AdjustArray(int s[], int l, int r) // 返回调整后基准数的位置
	{
		int i = l, j = r;
		int x = s[l]; // s[l]即s[i]就是第一个坑
		while (i < j) {
			// 从右向左找小于x的数来填s[i]
			while (i < j && s[j] >= x)
				j--;
			if (i < j) {
				s[i] = s[j]; // 将s[j]填到s[i]中，s[j]就形成了一个新的坑
				i++;
			}

			// 从左向右找大于或等于x的数来填s[j]
			while (i < j && s[i] < x)
				i++;
			if (i < j) {
				s[j] = s[i]; // 将s[i]填到s[j]中，s[i]就形成了一个新的坑
				j--;
			}
		}
		// 退出时，i等于j。将x填到这个坑中。
		s[i] = x;

		return i;
	}

	/**
	 * 冒泡排序
	 * 
	 * @param values
	 */
	public static void paosort(int[] values) {
		for (int i = 0; i < values.length; i++) {
			for (int j = i + 1; j < values.length; j++) {
				if (values[i] > values[j]) {
					int temp = values[j];
					values[j] = values[i];
					values[i] = temp;
				}

			}
		}

	}

	public static void selectSort(int[] values) {

		int min_pos;
		for (int i = 0; i < values.length; i++) {
			min_pos = i;
			// 遍历找出 最小值，把最小值赋值给 tempMin
			for (int j = i + 1; j < values.length; j++) {
				if (values[j] < values[min_pos]) {
					min_pos = j;
				}
			}
			// 此时 temp_pos为最小值所在位置，让其与i交换
			// 如果顺序变了，则交换
			if (i != min_pos) {
				values[i] = values[i] + values[min_pos];
				values[min_pos] = values[i] - values[min_pos];// (values[i])
				values[i] = values[i] - values[min_pos];
			}
		}

	}

}
