import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/3/18 20:52
 * 4
 */
public class lan2 {
    
    /**
    * @Author ffc
    * @Description  字符串全排列
    * @Date  2019/3/21
    * @Param  * @param null
    * @return 
    **/

     static List<String> quan(String x){
         List<String> sd  =new ArrayList<String>();

         if(x.length()==1){
             sd.add(x);
             return sd;
         }
         for(int i=0;i<x.length();i++){
             char c = x.charAt(i);

             List<String> quan = quan(x.substring(0, i) + x.substring(i + 1));
             for(int k=0;k<quan.size();k++){

                 sd.add(c+quan.get(k));
             }

         }
         return sd;

     }

     //组合技术
    static int xy(int x,int y){
         if(y==0){
             return 1;
         }
         if(x==y){
             return 1;
         }
         return xy(x-1,y)+xy(x-1,y-1);

    }


    /**
     * @return
     * @Author ffc
     * @Description 数学家高斯很小的时候就天分过人。一次老师指定的算数题目是：1+2+...+100。
     * 高斯立即做出答案：5050!
     * 这次你的任务是类似的。但并非是把一个个的数字加起来，而是对该数字的每一个数位作累加。
     * 这样从1加到100的“和”是：901
     * 从10加到15是：21，也就是：1+0+1+1+1+2+1+3+1+4+1+5，这个口算都可以出结果的。
     * <p>
     * 按这样的“加法”，从1加到1000是多少呢？
     * @Date 2019/3/18
     * @Param * @param
     **/
    static void lan81() {
        int xy = 0;
        for (int i = 1; i <= 1000; i++) {
            String s = String.valueOf(i);

            if (s.length() > 1) {
                for (int x = 0; x < s.length(); x++) {
                    char c = s.charAt(x);

                    xy += Integer.valueOf(String.valueOf(c));
                }
            } else {
                xy += Integer.valueOf(s);
            }


        }
        System.out.println(xy);


    }

    /**
     * @return
     * @Author ffc
     * @Description 标题：外星日历
     * <p>
     * 某星系深处发现了文明遗迹。
     * <p>
     * 他们的计数也是用十进制。
     * 他们的文明也有日历。日历只有天数，没有年、月的概念。
     * 有趣的是，他们也使用了类似“星期”的概念，
     * 只不过他们的一个星期包含了9天，
     * 为了方便，这里分别记为: A,B,C....H,I
     * <p>
     * A B C D E F G H I
     * 从一些资料上看到，
     * 他们的23日是星期E
     * 他们的190日是星期A
     * 他们的343251日是星期I
     * <p>
     * 令人兴奋的是，他们居然也预见了“世界末日”的那天，
     * 当然是一个很大很大的数字
     * 651764141421415346185
     * <p>
     * 请你计算一下，这遥远的一天是该文明的星期几？
     * <p>
     * 你需要提交的是一个大写字母，表示该文明的星期几，
     * 不要填写任何多余的内容。
     * @Date 2019/3/19
     * @Param * @param
     **/
    static void lan811() {
        char[] c = {'I', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        BigInteger b1 = new BigInteger("651764141421415346185");
        BigInteger b2 = new BigInteger("9");
        BigInteger yu = b1.mod(b2);
        for (int i = 0; i < c.length; i++) {
            if (i == yu.intValue()) {
                System.out.println(c[i]);
            }


        }
    }
        /**
         * @Author ffc
         * @Description 在电子计算机普及以前，人们经常用一个粗略的方法来验算四则运算是否正确。
         *     比如：248 * 15 = 3720
         *     把乘数和被乘数分别逐位求和，如果是多位数再逐位求和，直到是1位数，得
         *     2 + 4 + 8 = 14 ==> 1 + 4 = 5;
         *     1 + 5 = 6
         *     5 * 6
         *     而结果逐位求和为 3
         *     5 * 6 的结果逐位求和与3符合，说明正确的可能性很大！！（不能排除错误）
         *
         *     请你写一个计算机程序，对给定的字符串逐位求和：
         *     输入为一个由数字组成的串，表示n位数(n<1000);
         *     输出为一位数，表示反复逐位求和的结果。
         *
         *     例如：
         *     输入：
         *     35379
         *        18+9=27
         *     程序应该输出：
         *     9
         *
         *     再例如：
         *     输入：
         *     7583676109608471656473500295825
         *
         *     程序应该输出：
         *     1
         *
         *
         *     资源约定：
         *     峰值内存消耗（含虚拟机） < 256M
         *     CPU消耗  < 1000ms
         *
         *
         *     请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
         *
         *     所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
         *     不要使用package语句。不要使用jdk1.7及以上版本的特性。
         *     主类的名字必须是：Main，否则按无效代码处理。
         * @Date 2019/3/19
         * @Param  * @param
         * @return
         **/
        static void lan97 (String i){
            String sd = String.valueOf(i);
            char[] chars = sd.toCharArray();

            while (true) {
                int x = 0;
                for (int v = 0; v < chars.length; v++) {
                    x += chars[v] - '0';

                }
                chars = String.valueOf(x).toCharArray();
                if (chars.length == 1) {
                    break;
                }

            }
            System.out.println(chars);


        }
        /**
         * @Author ffc
         * @Description w星球的长老交给小明一个任务：
         * 1,2,3...16 这16个数字分为两组。
         * 要求：
         * 这两组数字的和相同，
         * 并且，两组数字的平方和也相同，
         * 并且，两组数字的立方和也相同。
         * 请你利用计算机的强大搜索能力解决这个问题。
         * 并提交1所在的那个分组的所有数字。
         * 这些数字要从小到大排列，两个数字间用一个空格分开。
         *
         * 即类似：1 4 5 8 ...  这样的答案。
         *
         * 题目提示了两边都为8个数字
         * ---------------------
        ！
         * @Date 2019/3/19
         * @Param  * @param
         * @return
         **/
// static void lan82(){
//
//
        /**
        * @Author ffc
        * @Description 有奖猜谜
         *
         * 小明很喜欢猜谜语。
         * 最近，他被邀请参加了X星球的猜谜活动。
         *
         * 每位选手开始的时候都被发给777个电子币。
         * 规则是：猜对了，手里的电子币数目翻倍，
         * 猜错了，扣除555个电子币, 扣完为止。
         *
         * 小明一共猜了15条谜语。
         * 战果为：vxvxvxvxvxvxvvx
         * 其中v表示猜对了，x表示猜错了。
         *
         * 请你计算一下，小明最后手里的电子币数目是多少。
         *
         * 请填写表示最后电子币数目的数字。
         * 注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
         * --------------------- 
         * 作者：三毛码代码 
         * 来源：CSDN 
         * 原文：https://blog.csdn.net/u014543872/article/details/84111987 
         * 版权声明：本文为博主原创文章，转载请附上博文链接！
        * @Date  2019/3/20
        * @Param  * @param 
        * @return 
        **/



        static void lan61(){
            String sd = "vxvxvxvxvxvxvvx";
            char[] c = sd.toCharArray();
            int num = 777;
            for(int i=0;i<c.length;i++){

                if(c[i]=='v'){

                    num+=777;
                }
                if(c[i]=='x'){
                    num-=555;
                }


            }

        }
        /**
        * @Author ffc
        * @Description 我们知道，整数做除法时，有时得到有限小数，有时得到无限循环小数。
         * 如果我们把有限小数的末尾加上无限多个0，它们就有了统一的形式。
         * 本题的任务是：在上面的约定下，求整数除法小数点后的第n位开始的3位数。
         * 输入：
         *  一行三个整数：a b n，用空格分开。a是被除数，b是除数，n是所求的小数后位置（0<a,b,n<1000000000）
         * 输出：
         * 一行3位数字，表示：a除以b，小数后第n位开始的3位数字。
         * 比如：
         * 输入：
         * 1 8 1
         * 程序应该输出：
         * 125
         * 再比如：
         * 输入：
         * 1 8 3
         * 程序应该输出：
         * 500
         * 再比如：
         * 输入：
         *
         * 282866 999000 6
         *
         * 程序应该输出：
         *
         * 914
         * ---------------------
         * 作者：向前走别回头
         * 来源：CSDN
         * 原文：https://blog.csdn.net/weixin_39778570/article/details/80529266
         * 版权声明：本文为博主原创文章，转载请附上博文链接！
        * @Date  2019/3/20
        * @Param  * @param 
        * @return 
        **/
        static void lan3(){

            
        }

        public static void main(String[] args) {

//
//            int i=5;
//            int x = (i++);
//            System.out.println(x);




//            int s=(i++)+(++i)+(i--)+(--i);



        }


}
