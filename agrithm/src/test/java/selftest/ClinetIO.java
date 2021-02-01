package selftest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class ClinetIO {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));

        FileChannel fileChannel = new FileInputStream(
                "E:\\old G\\Client.txt")
                .getChannel();

        System.out.println("文件大小为: " + fileChannel.size());
        long sendLength = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("发送的数据大小为: " + sendLength);
        socketChannel.close();
        fileChannel.close();
    }
}


