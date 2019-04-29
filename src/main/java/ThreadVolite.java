import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/25 10:30
 * 4
 */

class vloite extends Thread {

    public  volatile   boolean flag = true;//Volatile关键字将解决线程之间可见性, 强制线程每次读取该值的时候都去“主内存”中取值
    @Override
    public void run() {
        System.out.println("开始执行子线程....");
        while (flag) {
        }
        System.out.println("线程停止");
    }
    public void setRuning(boolean flag) {
        this.flag = flag;
    }


}
 class VolatileNoAtomic extends Thread {
     private static volatile int counts;
     private static Object sd = new Object();

      private static AtomicInteger count = new AtomicInteger(0);

     private static void addCount() {

     }
     @Override
     public void run() {
         for (int i = 0; i < 1000; i++) {

             count.incrementAndGet();
         }
         System.out.println(count);
     }
 }

public class ThreadVolite {
    public static void main(String[] args) throws InterruptedException {
//        vloite vloite = new vloite();
//        Thread thread = new Thread(vloite);
//
//
//        thread.start();
//        Thread.sleep(1000);
//        System.out.println("设为false");
//        vloite.setRuning(false);
//        Thread.sleep(1000);
//        System.out.println("停止了");


        //原子性
        // 初始化10个线程
        VolatileNoAtomic[] volatileNoAtomic = new VolatileNoAtomic[10];
        for (int i = 0; i < 10; i++) {
            // 创建
            volatileNoAtomic[i] = new VolatileNoAtomic();
        }
        for (int i = 0; i < volatileNoAtomic.length; i++) {
            volatileNoAtomic[i].start();
        }



    }

}
