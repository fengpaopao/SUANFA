/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/25 10:20
 * 4
 */
class Thread1 extends Thread{

    @Override
    public void run(){
        for(int i=0;i<2;i++){
            System.out.println("线程1"+i);
        }
    }

}
class Thread2 extends Thread{

    @Override
    public void run(){
        for(int i=0;i<4;i++){
            System.out.println("线程2"+i);
        }
    }

}

class Thread3 extends Thread{

    @Override
    public void run(){
        for(int i=0;i<6;i++){
            System.out.println("线程3"+i);
        }
    }

}


public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();
        Thread thread = new Thread(thread1);
        Thread thread4 = new Thread(thread2);
        Thread thread5 = new Thread(thread3);
        thread.start();
        thread.join();//这个方法是让当前线程执行完毕，让其他线程等待。

        thread4.start();
        thread4.join();


        thread5.start();



    }

}
