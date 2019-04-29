import java.util.concurrent.*;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/25 15:51
 * 4
 */
public class ExcetorsThread {


    public static void main(String[] args) {
        //定义一个线程池
        ExecutorService ex = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;  //因为在类不类里面引用外部的变量必须声明为final类型的，而在Java1.8中则进行了优化，只要内部类里面引用外外面变量只要这个变量没有进行改变，则就可以不用声明final
            ex.execute(new Runnable() {

                public void run() {
                    System.out.println(Thread.currentThread().getName() + "---" + index);

                }

            });
            if (index == 9) {
                ex.shutdown();//关闭线程池
            }
        }
    }

//    ThreadLo
//    (1)corePoolSize： 线程池维护线程的最少数量 （core : 核心）
//            (2)maximumPoolSize： 线程池维护线程的最大数量
//            (3)keepAliveTime： 线程池维护线程所允许的空闲时间
//            (4)unit： 线程池维护线程所允许的空闲时间的单位
//            (5)workQueue： 线程池所使用的缓冲队列
//            (6)handler： 线程池对拒绝任务的处理策略
//  private static int produceTaskSleepTime = 5;
//    private static int consumeTaskSleepTime = 5000;
//    private static int produceTaskMaxNumber = 20; //定义最大添加10个线程到线程池中
//    public static void main(String[] args) {
//        //构造一个线程池
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 3,
//                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
//                new ThreadPoolExecutor.DiscardOldestPolicy());
//    }
//    threadPool.
}
