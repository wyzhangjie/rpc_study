package codc;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class SmallEncoder extends MessageToByteEncoder<SmallRpcProtocol<Object>> {
    /*
 +---------------------------------------------------------------+
 | 魔数 2byte | 协议版本号 1byte | 序列化算法 1byte | 报文类型 1byte  |
 +---------------------------------------------------------------+
 | 状态 1byte |        消息 ID 8byte     |      数据长度 4byte     |
 +---------------------------------------------------------------+
 */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, SmallRpcProtocol<Object> objectSmallRpcProtocol, ByteBuf byteBuf) throws Exception {
        SmallHeader smallHeader = objectSmallRpcProtocol.getSmallHeader();
        byteBuf.writeShort(smallHeader.getMagic());
        byteBuf.writeByte(smallHeader.getVersion());
        byteBuf.writeByte(smallHeader.getSerialAlg());
        byteBuf.writeByte(smallHeader.getMsgType());
        byteBuf.writeByte(smallHeader.getStatus());
        byteBuf.writeLong(smallHeader.getMessageId());
        RpcSerialization serialization = SerializationFactory.getRpcSerialization(smallHeader.getSerialAlg());
        byte[] body = serialization.serialize(objectSmallRpcProtocol.getData());
        byteBuf.writeInt(body.length);
        byteBuf.writeBytes(body);
    }
}
