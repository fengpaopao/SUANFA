/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/24 14:27
 * 4
 */


class Res {

    public String name;
    public String sex;
    public boolean flag = false;//用来设置两个线程之间的你写，在读的顺序

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

class Incse extends Thread {
    private Res res;

    public Incse(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (res) {//通过synchronized通知来解决线程安全问题

                if (res.flag) {
                    try {
                        res.wait();//通知线程沉睡，并且会释放锁，
                        //sleep他不要会释放锁
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
                res.notify();//用来唤醒其他线程

            }
        }


    }
}

class GetThread extends Thread {
    private Res res;

    public GetThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (res) {

                if (!res.flag) {
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("姓名" + res.getName() + "性别" + res.getSex());
                res.flag = false;
                res.notify();
            }
        }

    }
}

public class Thrdeadtoxin {

    public static void main(String[] args) {
        Res res = new Res();
        Incse incse = new Incse(res);
        GetThread getThread = new GetThread(res);
        incse.start();
        getThread.start();

    }
}
