package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.SQLOutput;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/26 16:33
 * 4
 */
public class udpService {

    public static void main(String[] args) throws IOException {
        System.out.println("udp服户端已经启动了");
        //服务端要监听的端口号
        DatagramSocket datagramSocket = new DatagramSocket(8080);
        byte[] bytes = new byte[1024];

        //接受的数据
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);

        //阻塞效果
        datagramSocket.receive(dp);

        //接受客户端的信息
        System.out.println("来源"+dp.getAddress().getHostAddress()+""+dp.getPort());

        //接受客户端得数据
        String s= new String(dp.getData(),0,dp.getLength());
        System.out.println(s);
        datagramSocket.close();


    }


}
