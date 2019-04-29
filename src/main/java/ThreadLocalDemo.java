/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/25 14:21
 * 4
 */
class Resst {
    private ThreadLocal<Integer> count = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {

            return 0;
        }

        ;

    };

    public Integer getNum() {
        int integer = count.get() + 1;
        this.count.set(integer);
        return integer;
    }


}

public class ThreadLocalDemo extends Thread {
    private Resst ress;

    public ThreadLocalDemo(Resst ress) {
        this.ress = ress;
    }


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread() + "序号" + i + "" + ress.getNum());
        }

    }

    public static void main(String[] args) {
        Resst res = new Resst();
        ThreadLocalDemo threadLocaDemo1 = new ThreadLocalDemo(res);
        ThreadLocalDemo threadLocaDemo2 = new ThreadLocalDemo(res);
        ThreadLocalDemo threadLocaDemo3 = new ThreadLocalDemo(res);
        threadLocaDemo1.start();
        threadLocaDemo2.start();
        threadLocaDemo3.start();

    }


}
