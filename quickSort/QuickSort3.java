package quickSort;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class QuickSort3 {
	int count;

	/**
	 * 最简洁版，面试推荐
	 * 
	 * @param a
	 * @param left
	 * @param right
	 */
	public void quickSort1(int[] a, int left, int right) {
		if (left >= right) {
			return;
		}
		int i = left;
		int pivot = a[right];
		for (int j = left; j < right; j++) {
			if (pivot > a[j]) {
				swap(a, i++, j);
			}
		}
		swap(a, i, right);
		quickSort1(a, left, i - 1);
		quickSort1(a, i + 1, right);
	}

	private void swap(int[] a, int i, int j) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * 随机快速排序
	 * 
	 * @param a
	 * @param left
	 * @param right
	 */
	public void quickSort2(int[] a, int left, int right) {
		if (left >= right) { // 先判断边界，要排序的数组长度最少为2
			return;
		}
		count++;
		// 在排序前，先随机换一下基准值，基准值位置默认为最右边
		Random r = new Random();
		int index = (r.nextInt(right - left)) + left;
		swap(a, index, right);

		int i = left; // 左指针，所指元素 都是已经确定好比基准值小。极端情况基准值选了个最小值，也会与第一个值交换
		int pivot = a[right];// 以最右边的值为基准值
		// 遍历，将比基准值小的数都一次放最左边
		for (int j = left; j < right; j++) {
			if (pivot > a[j]) {
				swap(a, i++, j); // i++ 移动指针
			}
		}
		swap(a, i, right); // 遍历完成后，则确认好了基准值的位置为i，让基准值归位
		quickSort1(a, left, i - 1); // 递归，分治
		quickSort1(a, i + 1, right);
	}

	/**
	 * 啊哈磊版 两个指针交换
	 * 
	 * @param a
	 *            需要排序的目标数组
	 * @param left
	 *            左边界
	 * @param right
	 *            右边界
	 */
	public void quickSort3(int[] a, int left, int right) {
		// 先判断边界，要排序的数组长度最少为2
		if (left >= right) {
			return;
		}
		// 以左边第一个数为基准值
		int pivot = a[left];
		// 创建左右两个指针
		int i = left, j = right;
		// 跳出循环时i=j，说明找到基准数的位置
		while (i < j) {
			// 因为基准值确定为左边第一个位置，所以要先从右边向左边找比基准值小的数，跳出循环有两种情况，1 ：找到了这个数，2： i=j
			while (a[j] >= pivot && i < j) {
				j--;
			}
			// 再从左边找
			while (a[i] <= pivot && i < j) {
				i++;
			}
			if (i < j) {
				// 交换位置
				swap(a, i, j);
			}
		}
		// 跳出循环说明i=j,指针碰到一起，也就确定好了基准值的位置，让基准值归位
		swap(a, i, left);
		// 递归调用，分治
		quickSort3(a, left, i - 1);
		quickSort3(a, i + 1, right);
	}
	
	/**
	 * 快排更高效版
	 * @param a
	 * @param left
	 * @param right
	 */
	public void quickSort4(int[] a,int left,int right){
		if(left>=right){
			return;
		}
		int i=left,j=right;
		int pivot=a[left];
		while(i<j){
			while(a[j]>=pivot&&i<j){
				j--;
			}
			if(i<j){
				a[i++]=a[j];
			}
			while(a[i]<=pivot&&i<j){
				i++;
			}
			if(i<j){
				a[j--]=a[i];
			}
		}
		a[i]=pivot;
		quickSort4(a,left,i-1);
		quickSort4(a,i+1,right);
	}

	@Test
	public void testQuicksort() {
		// i++ 是先判断 在加1
		int[] a = { 24, 5, 1, 2, 24, 5, 1, 2, 5, 7, 8, 5, 3, 7, 63, 9, 0, 42, 3, 8, 24, 1 };
		// int[] a = { 5, 4, 3, 2, 1 };
		long start = System.currentTimeMillis();
		quickSort4(a, 0, a.length - 1);
		long end = System.currentTimeMillis();
		System.out.println(Arrays.toString(a));
		System.out.println("嵌套次数：" + count + "用时" + (end - start));
	}
}
