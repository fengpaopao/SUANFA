package tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/4/26 17:24
 * 4
 */
public class TcpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("socket启动....");
        Socket s = new Socket("101.204.77.86", 8083);
        OutputStream outputStream = s.getOutputStream();
        outputStream.write("我是客戶端....".getBytes());
        s.close();


    }
}
