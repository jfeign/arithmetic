package shellSort;

import org.codehaus.groovy.runtime.powerassert.SourceText;

import java.util.*;

/**
 * 插入排序
 * Created by jiangfeng on 2016/9/17.
 */
public class InsertSort {
    public static void main(String[] args) {
        //int[] a={3,8,6,1,8,8,8,4,1,4};
        int n=1000;
        int[] a=new int[n];
        Random r =new Random();
        for(int i=0;i<n;i++){
            a[i]=r.nextInt(n);
        }
         printlnArr(a);
        //selectSort(a)
        Long start=System.currentTimeMillis();
        insertSort1(a);
        System.out.println(System.currentTimeMillis()-start);
        printlnArr(a);
    }
    /**
     * 插入排序(自己实现)
     */
    public static List<Integer> insertSort1(int[] a){
        LinkedList<Integer> b=new LinkedList<Integer>();
        b.add(a[0]);
        //先放两个元素
        if(a[1]<b.getFirst()){
            b.addFirst(a[1]);
        }else {
            b.addLast(a[1]);
        }
        //index 表示变量到哪个元素，和当前集合内有的元素个数
        //循环啊，取到a的每个元素
        for (int index=2;index<a.length;index++){
            //循环b中已有的元素 用迭代器循环效率高
            ListIterator<Integer> iter = b.listIterator(b.size());
            while (iter.hasPrevious()){
                //大于此元素就去下一个循环  逆序遍历
                int i=iter.previous();
                if(a[index]<i){
                    //小于此元素就去下一个循环
                    //是否到头
                    if (!iter.hasPrevious()) {
                        b.addFirst(a[index]);
                    }

                }else {
                    //大于等于他,放其后面
                    iter.next();
                    iter.add(a[index]);
                    break;
                }
            }

        }
        //排序好了，重新赋给a
        int k=0;
        for(int j:b){
            a[k++]=j;
        }
        return b;
    }

    public static List<Integer> insertSort2(int[] a){
        LinkedList<Integer> b=new LinkedList<Integer>();
        b.add(a[0]);
        if(a[1]<b.getFirst()){
            b.addFirst(a[1]);
        }else {
            b.addLast(a[1]);
        }
        //index 表示变量到哪个元素，和当前集合内有的元素个数
        //循环啊，取到a的每个元素
        for (int index=2;index<a.length;index++){
            for (int i = b.size()-1; i >= 0; i--) {
                //拿a的
                if (a[index] < b.get(i)) {
                    //小于此元素就去下一个循环
                    //是否到头
                    if (i == 0) {
                        b.addFirst(a[index]);
                    }
                } else {
                    //大于等于他,放其后面
                    b.add(i + 1, a[index]);
                    break;
                }
            }
        }
        //排序好了，重新赋给a
        int k=0;
        for(int j:b){
            a[k++]=j;
        }
        return b;
    }


    /**
     * 插入排序较好方式！！
     */
    public static void insertSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            int position = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > currentValue) {
                    array[j + 1] = array[j];
                    position -= 1;
                } else {
                    break;
                }
            }
            array[position] = currentValue;
        }
    }
    public static void printlnArr(int[] a){
        for (int i:a){
            println(i);
        }
        System.out.println();
    }
    public static void println(Object a){
        System.out.print(a);
        System.out.print(",");
    }



}
