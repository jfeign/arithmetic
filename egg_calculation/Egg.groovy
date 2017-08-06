package egg_calculation

/**
 * Created by jiangfeng on 2017/7/8.
 * 问题描述：
 * 一筐鸡蛋：
 * 2个2个拿，还剩一个
 * 3个3个拿，正好拿完
 * 4个4个拿，还剩一个
 * 5个5个拿，还差一个
 * 6个6个拿，还剩三个
 * 7个7个拿，正好拿完
 * 8个8个拿，还剩一个
 * 9个9个拿，正好拿完
 *
 */
class Egg {
    public static void main(String[] args) {
//         println calculation()
      //  calculation2()
        println 1449%4
        println 1449%5
        println 1449%6
        println 1449%7
        println 1449%8
        println 1449%9
    }
    private static int calculation(){
        int count  = 0
        for (int i = 7 * 9; i < 1000000000; i = 3 * i) {
          //  println i
            boolean a = i % 2 == 1
            boolean c = i % 4 == 1
            boolean b = i % 5 == 4
            boolean d = i % 6 == 3
          //  boolean e = i % 7 == 0
            boolean f = i % 8 == 1
          //  println "a:"+a +" b:"+b+" d:"+d+" f:"+f
           // boolean g = i % 9 == 0
            if (a && b && c && d  && f ) {
                print i + " "
                count++
            }
        }
        return count
    }


    private static int calculation2(){
        int count  = 0
        for (int i = 1; i < 100000; i++) {
          //  println i
            boolean a = i % 2 == 1
            boolean b = i % 4 == 1
            boolean c = i % 5 == 4
            boolean d = i % 6 == 3
              boolean e = i % 7 == 0
            boolean f = i % 8 == 1
            //  println "a:"+a +" b:"+b+" d:"+d+" f:"+f
             boolean g = i % 9 == 0
            //println "c "+c +" f "+f
            if (b && c&& d &&e  && f&& g ) {
                print i + " "
                count++
            }
        }
    }
}