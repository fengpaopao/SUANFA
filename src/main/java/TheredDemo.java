/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/24 9:30
 * 4
 */
class ThreadDemo1 extends Thread {

    private int count = 100;
    private Object obj = new Object();

    @Override
    public void run() {

        while (count>0){
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj) {
                if(count>0) {

                    System.out.println(Thread.currentThread().getName() + "出售第几张票" + (100 - count + 1) + "票");
                    count--;
                }
            }

        }


    }


}


/**
 * @Author ffc
 * @Description 多线程的情况下同时强1000张火车票
 * @Date 2019/4/24
 * @Param * @param null
 * @return
 **/
public class TheredDemo {

    public static void main(String[] args) {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        new Thread(threadDemo1).start();
        new Thread(threadDemo1).start();


    }
}
