package quickSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.junit.Test;

public class QuickSort1 {
	int count = 0;

	@Test
	public void testQuicksort() {
		// i++ 是先判断 在加1
		int[] a = { 24, 5, 1, 2, 5, 7, 8, 5, 3, 7, 63, 9, 0, 42, 3, 8, 24, 1 };
		long start = System.currentTimeMillis();
		quicksort2(a, 0, a.length - 1);
		long end = System.currentTimeMillis();
		System.out.println(Arrays.toString(a));
		System.out.println("嵌套次数：" + count + "用时" + (end - start));
	}

	/**
	 * @param a
	 *            目标数组
	 * @param left
	 *            左边界
	 * @param right
	 *            右边界
	 */
	public void quicksort(int[] a, int left, int right) {
		count++;
		// 进来就先判断
		if (left < right) {
			// 把左右边界分别交个新变量，方便更改
			int i = left, j = right;
			// 定义为基准位为左边第一个,将基准值保存起来
			int piot = a[i];
			// 找完一遍就重新开始找，直到i=j
			while (i < j) {
				// 先从右边开始，找比基准数小的数，注意不能相等，相等换的话就会多出几个比较
				// 跳出循环只有两种情况，要么i=j 要么找到比基数小的数
				while (piot >= a[j] && i < j) {
					j--;
				}
				// 找到了，把这个数放入基准位,赋值前先判断，排除 i=j的情况
				if (i < j) {
					a[i++] = a[j]; // 用i++ 则下一次循环会少一个比较，优化了
				}
				// 再从左边开始找比基准数大的数
				// 跳出循环只有两种情况，要么i=j 要么找到比基数大的数
				while (piot <= a[i] && i < j) {
					i++;
				}
				// 找到了，把这个数放入基准位,赋值前先判断，排除 i=j的情况
				if (i < j) {
					a[j--] = a[i];
				}
			}
			// 跳出循环了 说明i=j 了，已经找到基准数的位置了 ，把他给
			a[i] = piot;// or a[j]=poit
			quicksort(a, left, i - 1);
			quicksort(a, i + 1, right);
		}
	}

	public int findPivot(int[] a, int left, int right) {
		// 定义为基准位为左边第一个,将基准值保存起来
		// int index = (left + right) / 2;
		int index = left;
		// int index=(new Random().nextInt(right-left))+left;
		// 要随机的话，只需把第一个元素，与 left和right中随机一个元素 换位置;
		int piot = a[index];
		// 找完一遍就重新开始找，直到i=j
		while (left < right) {
			// 先从右边开始，找比基准数小的数，注意不能相等，
			// 跳出循环只有两种情况，要么i=j 要么找到比基数小的数
			while (a[right] >= piot && left < right) {
				right--;
			}
			// 再从左边开始找比基准数大的数
			// 跳出循环只有两种情况，要么i=j 要么找到比基数大的数
			while (a[left] <= piot && left < right) {
				left++;
			}
			// 找到了，把这个两个位置调换,赋值前先判断，排除 i=j的情况
			if (left < right) {
				swap(a, left, right);
				System.out.println(count + ":index" + index + " left:" + left
						+ " right:" + right + Arrays.toString(a));
			}
		}
		// 跳出循环说明两个指针相等，将基准位放入次位置
		// a[index] = piot;
		// a[left]=piot;
		swap(a, index, left);
		System.out.println(count + "定 left:" + left + "index:" + index
				+ Arrays.toString(a));
		return left;
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private void quicksort2(int[] a, int left, int right) {
		count++;
		// 进来就先判断
		if (left < right) {
			int pivot = findPivot(a, left, right);
			quicksort2(a, left, pivot - 1);
			quicksort2(a, pivot + 1, right);
		}
	}
}