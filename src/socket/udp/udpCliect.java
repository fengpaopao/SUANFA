package udp;

import java.io.IOException;
import java.net.*;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/26 16:33
 * 4
 */
public class udpCliect {
    public static void main(String[] args) {
        System.out.println("udp 发送数据");
        //创建一个连接
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        String str = "客户端发送数据....";
        //每次传输的大小
        byte[] strByte = str.getBytes();

        //连接服务器的信息
        DatagramPacket dp = null;
        try {
            dp = new DatagramPacket(strByte, strByte.length, InetAddress.getByName("192.168.126.1"), 8080);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            //发送
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ds.close();

    }


}
