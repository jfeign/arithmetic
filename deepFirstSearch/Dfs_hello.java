package deepFirstSearch;

import org.junit.Test;

/**
 * @author Administrator
 *
 *         深度优先搜索 用这个方法来做
 *
 *         ^^^+^^^=^^^的数学题 核心是：
 * 思想：
 *void dfs(int step){
 *      判断边界
 *      
 *      尝试每一种可能for(){
 *        继续下一步dfs(step+1)
 *      }
 *      
 *      return
 *}
 *
 *
 */
public class Dfs_hello {
	// 新建一个空盒子， 10个空间
	int[] a = new int[10];
	// 10张牌 用来标第i步的牌是否在已经 放入 ， 0表示未，1表示是
	int[] book = new int[10];
	int count = 0;

	@Test
	public void test() {
		dfs(1);
		System.out.println(count);
	}

	/**
	 * @param step
	 * 
	 */
	public void dfs(int step) {
		// 边界条件，如果进入这一步，说明前面三不已经完成
		if (step == 10) {
			// 打印出来看看
			if ((a[1] * 100 + a[2] * 10 + a[3] + a[4] * 100 + a[5] * 10 + a[6]) == (a[7]
					* 100 + a[8] * 10 + a[9])) {
				for (int i = 0; i < a.length; i++) {
					// 第一位不打印
					if (i == 0) {
						continue;
					}
					// 在第4为加一个+号
					if (i == 4) {
						System.out.print("+");
					}
					if(i==7){
						System.out.print("=");
					}
					System.out.print(a[i]);

				}
				count++;
				System.out.println();
				return;
			}
		}

		// 完成第step步的全部遍历
		for (int i = 1; i < a.length; i++) {
			// book[i]表示第step步时，i号牌是否在已经分配
			if (book[i] == 0) {

				// 完成第step步的动作
				a[step] = i;
				// 将第i号牌标记
				book[i] = 1;
				// 这一步完成，递归到下一步
				dfs(step + 1);
				book[i] = 0;// 把刚刚尝试的扑克牌收回
			}
		}
	}

}
