package selftest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 传统BIO编程模型的弊端总结:
 *     <1> 一个客户端的连接必然会导致一次accept系统调用, 对一个客户端的read操作同样也会触发一次read系统调
 *         用, 当并发量大的情况下, 频繁的进程切换会对整个服务器造成影响(整个服务器不仅仅指当前项目)
 *     <2> accept和read操作都是阻塞操作, 一旦调用, 那么调用该方法的线程就会陷入阻塞, 无法执行其他任务, 直
 *         到客户端有连接过来或者有发送数据为止
 *
 * 作者：zhongshenglong
 * 链接：https://juejin.cn/post/6864103342244397070
 * 来源：掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * */
public class ServerIO {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel =
                ServerSocketChannel.open().bind( new InetSocketAddress(8080) );

        while ( true ) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            ByteBuffer buffer = ByteBuffer.allocate( 1024 );
            //accept以及read方法都是阻塞的, 当阻塞的情况下, 该I/O操作的线程就不能执行其他
            //任务,如果将read的动作放到另一个线程去执行，又控制不住线程数量，消耗大量系统资源，文件描述符是有限的，耗尽服务就基本不可用了
            long totalLength = 0;
            long byteLength = 0;
            while ( byteLength != -1 ) {
                byteLength = socketChannel.read( buffer );
                if ( byteLength != -1 )
                    totalLength += byteLength;

                buffer.clear();
            }

            System.out.println( "总共读到的字节数为: " + totalLength );
        }
    }


}
