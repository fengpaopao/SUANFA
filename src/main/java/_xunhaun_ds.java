import java.util.Scanner;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/3/6 9:02
 * 4
 */
public class _xunhaun_ds {

//    private int xsss;
//    final int sss;


    /**
    * @Author ffc
    * @Description  打印i到就 采用递归
    * @Date  2019/3/6
    * @Param  * @param args
    * @return
    **/

    static void f1(int i,int j){
        if(i>j){
            return;
        }
      

        System.out.println(i+"j");
        f1(i+1,j);

    }
    public static final String replaceSpace(String str) {

        String s = str.toString();
        String s1 = s.replaceAll(" ", "20%");
        return s1;

    }
    public static void main(String[] args) {

        int t1=2, t2=3, t3;

        t3=t1<t2 ?  t1:(t2+t1);
        System.out.println(t3);
    }


}
