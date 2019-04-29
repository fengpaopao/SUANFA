/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/26 14:18
 * 4   单列模式 懒汉式
 */
class gets{
    public static void main(String[] args) {
        Singleton getdanl = Singleton.getdanl();
        Singleton getdan2 = Singleton.getdanl();
        System.out.println(getdan2==getdanl);
    }

}

public class Singleton {
    private static Singleton singleton;

    synchronized  public static Singleton getdanl(){
        if(singleton==null){
            singleton  =new Singleton();
        }
        return singleton;
    }



}
