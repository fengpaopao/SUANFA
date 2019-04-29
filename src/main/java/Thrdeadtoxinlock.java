import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/24 14:27
 * 4
 */


class Ress extends Thread {

    public String name;
    public String sex;
    public boolean flag = false;//用来设置两个线程之间的你写，在读的顺序
    public Lock locksa = new ReentrantLock();//这是java1.5中引入的一个java并发包
    //他与synchrionizedd的主要区别是：lock是要自己手动获取锁，和释放锁
    //而synchrioniezed则是自动释放锁
    Condition conditions = locksa.newCondition();


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

class Incses extends Thread {
    private Ress res;

    public Incses(Ress res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {

            try {
                res.locksa.lock();//表示上锁
                if (res.flag) {
                    try {
                        res.conditions.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                if (count == 0) {
                    res.name = "大炮";
                    res.sex = "男";
                } else {
                    res.name = "小紅";
                    res.sex = "女";
                }

                count = (count + 1) % 2;
                res.flag = true;
                res.conditions.signal();

            } catch (Exception e) {


            } finally {

                res.locksa.unlock();//表示释放锁
            }

        }
    }
}

class GetThreads extends Thread {
    private Ress res;

    public GetThreads(Ress res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {

            try {
                res.locksa.lock();//上锁
                if (!res.flag) {
                    try {
                        res.conditions.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("姓名" + res.getName() + "性别" + res.getSex());
                res.flag = false;
                res.conditions.signal();


            } catch (Exception e) {
            } finally {
                res.locksa.unlock();
                ;//手动释放锁
            }
        }
    }

}


public class Thrdeadtoxinlock {

    public static void main(String[] args) {
        Ress res = new Ress();
        Incses incse = new Incses(res);
        GetThreads getThread = new GetThreads(res);
        incse.start();
        getThread.start();

    }
}
