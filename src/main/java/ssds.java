/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/3/27 10:38
 * 4
 */
public class ssds {

   //创建资源
    private static volatile  Object resourceA = new Object ();
    public static void main( String[] args) throws InterruptedException {
//创建线程
        Thread threadA =new Thread(new Runnable() {


            public void run() {
                //获取resourceA共享资源的监视器锁
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA lock");
                    try {
                        System.out.println(" threadA begi wait");
                        resourceA.wait();
                        System.out.println(" threadA end wait");

                    }catch(InterruptedException e){

                            e.printStackTrace();
                        }
                    }
                }
            });
//创建线程
        Thread threadB =new Thread(new Runnable() {

            public void run() {
                synchronized (resourceA) {
                    System.out.println(" threadB get resou rceA lock");
                    try {
                        System.out.println(" threadB begin wait");
                        resourceA.wait();
                        System.out.println(" threadB end wa ");
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            }
        }
 );
// 创建线程
        Thread threadC =new Thread(new Runnable() {

            public void run() {
                synchronized (resourceA) {
                    System.out.println(" threadC begin not fy");
                    resourceA . notify ();

                }
            }
        }
        );


// 启动线程
                                        threadA .start ();
                                        threadB .start ();

                                        Thread.sleep(1000);

                                        threadC .start () ;
//等待线程结束
                                        threadA. join () ;
                                        threadB. join () ;
                                        threadC . join () ;
                                        System .out.println("ma over" );
                                    }
                                }
