import java.util.Arrays;
import java.util.Scanner;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/3/6 9:02
 * 4
 *
 *
 * 描述
 * 小明刚刚看完电影《第K级台阶》，离开电影院的时候，他数了数礼堂前的台阶数，恰好是K级!
 *
 * 站在台阶前，他突然又想着一个问题：
 *
 * 如果我每一步只能迈上1个或2个台阶。先迈左脚，然后左右交替，最后一步是迈右脚，
 *
 * 也就是说一共要走偶数步。那么，上完K级台阶，有多少种不同的上法呢？
 *
 * 请你利用计算机的优势，帮助小明寻找答案。
 *
 * 输入
 * 一个整数K（10<=K<=20）
 *
 * 输出
 * 整数，走法的种数
 *
 * 样例输入
 * 10
 * 样例输出
 * 44
 */


public class _递归_d  {

    Scanner sc = new Scanner(System.in);


    /**
    * @Author ffc
    * @Description  打印i到就 采用递归
    * @Date  2019/3/6
    * @Param  * @param args
    * @return
    **/


    static int tizi(int i){
        if(i==0){
            return 0;
        }
        if(i==1){
            return 1;
        }
        if(i==2){
            return 2;
        }
        return tizi(i-1)+tizi(i-2);
    }

    static void f1(int i,int j){
        if(i>j){
            return;
        }


        System.out.println(i+"j");
        f1(i+1,j);

    }


//    static int f3(int ti,int j){
//
//
//
//    }

    /**
    * @Author ffc
    * @Description 加和
    * @Date  2019/3/6
    * @Param  * @param ti
     * @param j
    * @return
    **/
    static int f4(int[] date,int len) {

        if (date.length - 1 == len) {

            return len;
        }

        return date[len]+f4(date,len+1);
    }

/**
* @Author ffc
* @Description  字符串反转
* @Date  2019/3/6
* @Param  * @param date
 * @param len
* @return 
**/

static String f5(String src,int len){
    String substring =src.charAt(len)+"";
    System.out.println(substring);
    if(len==0){

//        System.out.println(len);
        return ""+src.charAt(len);


    }





    return src.charAt(len)+f5(src,len-1);
    }


    /**
    * @Author ffc
    * @Description  否波拿起书
     *
     * 1 1 2 3 5
    * @Date  2019/3/8
    * @Param  * @param args
    * @return
    **/

    static int fou(int i){

        if(i==1 || i==2){
            return 1;
        }
        return fou(i-1)+fou(i-2);
    }
    /**
    * @Author ffc
    * @Description  最大公约数
    * @Date  2019/3/8
    * @Param  * @param args
    * @return
    **/


    static int gong(int m ,int n){

        if(n==0){
            return m;
        }

        return gong(n,m%n);

    }
/**
* @Author ffc
* @Description 小明被不明势力劫持。后被扔到x星站再无问津。小明得知每天都有飞船飞往地球，但需要108元的船票，而他却身无分文。
 *     他决定在x星战打工。好心的老板答应包食宿，第1天给他1元钱。
 *     并且，以后的每一天都比前一天多2元钱，直到他有足够的钱买票。
 *     请计算一下，小明在第几天就能凑够108元，返回地球。
* @Date  2019/3/18
* @Param  * @param args
* @return
 *
 * 1 3 5 7 9
**/
static int xy =0;

    static int lan1(){
//
//        xy++;
//        if(x>=108){
//            return xy;
//        }
//
//        return  lan1(x-2)+lan1(x+2);

        int xs =1;
        int s=0;
        for(int i=1;i<100;i++){
            xs+=2;
            s+=xs;

            if(s>=108){
                 xy=i;
                 break;
            }
        }
        return xy+1;
    }

/**
* @Author ffc
* @Description  在两位数10,11，....，98,99中，把每个被7除以余2的数字，如16,23....等，改成1,6,2,3....，而其余的数不变。问经过这样的变化之后所有数的和是多少()
* @Date  2019/3/18
* @Param  * @param x
* @return
**/

static  int lan12(){

    int x = 0;
    for(int i=10;i<100;i++){
        if(i%7==2){



        }

    }
return x;
}

/**
* @Author ffc
* @Description 5只猴子是好朋友，在海边的椰子树上睡着了。这期间，有商船把一大堆香蕉忘记在沙滩上离去。
 *     第1只猴子醒来，把香蕉均分成5堆，还剩下1个，就吃掉并把自己的一份藏起来继续睡觉。
 *     第2只猴子醒来，重新把香蕉均分成5堆，还剩下2个，就吃掉并把自己的一份藏起来继续睡觉。
 *     第3只猴子醒来，重新把香蕉均分成5堆，还剩下3个，就吃掉并把自己的一份藏起来继续睡觉。
 *     第4只猴子醒来，重新把香蕉均分成5堆，还剩下4个，就吃掉并把自己的一份藏起来继续睡觉。
 *     第5只猴子醒来，重新把香蕉均分成5堆，哈哈，正好不剩！
 *
 *     请计算一开始最少有多少个香蕉。
* @Date  2019/3/18
* @Param  * @param 
* @return 
**/
static void lan2(){

    int b = 20;
    while (true) {
        if (b % 5 == 1) {
            // 余下的香蕉等于总数减去上次分的数目

            int c = b - (b-1) / 5;
            c=c-1;
            if (c % 5 == 2) {

                int d = c - (c-2) / 5;
                d=d-2;
                if (d % 5 == 3) {
                    int x = d - (d-3) / 5;
                    x=x-3;
                    if (x % 5 == 4) {
                        int o = x - (x-4) / 5;
                        o=o-4;
                        // 最后一次被整除结束循环
                        if (o % 5 == 0) {
                            System.out.println(b);
                            break;
                        }
                    }
                }
            }
        }
       b++;
    }



    }


    /**
    * @Author ffc
    * @Description
     *      到x星球旅行的游客都被发给一个整数，作为游客编号。
     *     x星的国王有个怪癖，他只喜欢数字3,5和7。
     *     国王规定，游客的编号如果只含有因子：3,5,7,就可以获得一份奖品。
     *
     *     我们来看前10个幸运数字是：
     *     3 5 7
     *     9 15 21
     *     25 27 35
     *     45
     *     因而第11个幸运数字是：49
     *
     *     小明领到了一个幸运数字 59084709587505，他去领奖的时候，人家要求他准确地说出这是第几个幸运数字，否则领不到奖品。
     *
     *     请你帮小明计算一下，59084709587505是第几个幸运数字。
    * @Date  2019/3/18
    * @Param  * @param args
    * @return
    **/


    static int  lan4(){

        long MAX =  59084709587505L;
        int count = 0;
        for ( long i = 0; Math.pow(3,i) < MAX; ++i) {
            for (long j = 0; Math.pow(5, j) < MAX; ++j) {
                for (long k = 0; Math.pow(7, k) < MAX; ++k) {
                    if (Math.pow(3, i) * Math.pow(5, j) * Math.pow(7, k) < MAX) {
                        count++;
                        System.out.println(count);
                    }
                }
            }
        }
      return count;


    }



    public static void main(String[] args) {
//f1(3,10);
//


        float[][] se = new float[6][];
//i
//       String sd = "abc";
////        String substring = sd.substring(1);
//        String abcd = f5(sd, sd.length()-1);
        //String classFile = "com.jd.". replaceAll(".", "/") + "MyClass.class";
        int i = lan4();

//        float x = 10/3+1;
        System.out.println();
    }
}
