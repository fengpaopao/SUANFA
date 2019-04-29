import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/25 11:04
 * 4
 */
public class VolatileNoAtomics extends Thread {

    static int count =0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            //等同于i++
            atomicInteger.incrementAndGet();
        }
        System.out.println(Thread.currentThread().getName()+""+atomicInteger);
    }

    public static void main(String[] args) {
        // 初始化10个线程
        VolatileNoAtomics [] volatileNoAtomic = new VolatileNoAtomics[10];
        for (int i = 0; i < 10; i++) {
            // 创建
            volatileNoAtomic[i] = new VolatileNoAtomics();
        }
        for (int i = 0; i < volatileNoAtomic.length; i++) {
            volatileNoAtomic[i].start();
        }
    }

}
