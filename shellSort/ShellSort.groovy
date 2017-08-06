package shellSort


/**
 *希尔排序
 */
class ShellSort {
//	public static void main(String[] args) {
//		List a=[];
//		Random r =new Random()
//		for(int i=0;i<10;i++){
//			a.add(r.nextInt(10))
//		}
//		println a
//		//selectSort(a)
//		insertSort(a)
//		println a
//	}
//	/**
//	 * 选择排序
//	 * @param a
//	 */
//	public static void selectSort(List a) {
//		for (int i = 0; i < a.size(); i++) {
//			for (int j = i+1; j < a.size(); j++) {
//				if(a[j]<a[i]){
//					// 交换
//					a[i] = a[i] + a[j]
//					a[j] = a[i] - a[j]
//					a[i] = a[i] - a[j]
//				}
//			}
//		}
//	}
//
//	/**
//	 * 插入排序
//	 */
//	public static void insertSort(List a){
//		LinkedList b=new LinkedList();
//		b.add(a[0]);
//		//index 表示变量到哪个元素，和当前集合内有的元素个数
//		int index = 1;
//		//循环啊，取到a的每个元素
//		while ((index - 1) < a.size()) {
//			//循环b中已有的元素，b的元素个数就是index
//			for(int i=index-1;i>=0;i--){
//				//拿a的
//				if(a[index]<b[i]){
//					//小于此元素就去下一个循环
//					//是否到头
//					if(i==0){
//						b.addFirst(a[index++]);
//					}
//				}else {
//					//大于等于他,放其后面
//					b.add(i+1,a[index++]);
//				}
//			}
//		}
//		println b
//		a = b;
//	}

	//i表示与b中第几个开始比，从后向前
//			for (int i = index-1; i >= 0; i--) {
//				// 找位置
//				if (a[index] < b[i]) { //小于当前集合的最后一个
//					//是否大于前面一个
//					if (b.get(i - 1)) {
//						//前面一个存在
//						if (a[index] >= b[i - 1]) { //大于等于前面
//							b.add(index++, a[index]);
//							break;
//						}
//
//					} else {
//						//前面一个不存在，就放最前面
//						b.addFirst(a[index++]);
//						break;
//					}
//				} else {  //大于等于当前集合的最后一个，直接在最后添加
//					b.addLast(a[index++])
//					break;
//				}
//			}
}
