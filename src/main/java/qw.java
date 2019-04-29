
/**
 * 分析一下这个程序的输出
 * @author Jcon
 *
 */
public class qw implements Runnable{

    private int count = 10;

    @Override
    public synchronized void run(){
        count --;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        qw demo05 = new qw();
        for (int i = 0; i < 5; i++) {
            new Thread(demo05,"THREAD" + i).start();
        }
    }
}
