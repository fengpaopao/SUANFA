package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/26 17:24
 * 4
 */
public class TcpService {
    public static void main(String[] args) throws IOException {
        System.out.println("socket服务器端启动....");
        //101.204.77.86
        ServerSocket serverSocket = new ServerSocket(8083);
        //获取客户端对象
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] buf= new byte[1024];
        int len=inputStream.read(buf);
        String str =new String(buf,0,len);
        System.out.println("str:"+str);
        serverSocket.close();
    }


}
