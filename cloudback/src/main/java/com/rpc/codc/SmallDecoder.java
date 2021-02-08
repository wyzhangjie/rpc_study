package com.rpc.codc;

import com.alibaba.fastjson.JSON;
import com.rpc.common.Common;
import com.rpc.common.MiniRpcRequest;
import com.rpc.common.MiniRpcResponse;
import com.rpc.common.MsgType;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class SmallDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> list) throws Exception {
        //1、判断读缓存当中的数据是否大于一个报文头的长度
        if(in.readableBytes()< Common.ENCODELEN){
            return;
        }
        //首先记录读指针，方便在后面读取数据不足一个报文的时候回滚指针
        in.markReaderIndex();
 /*
 +---------------------------------------------------------------+
 | 魔数 2byte | 协议版本号 1byte | 序列化算法 1byte | 报文类型 1byte  |
 +---------------------------------------------------------------+
 | 状态 1byte |        消息 ID 8byte     |      数据长度 4byte     |
 +---------------------------------------------------------------+
 */
        //校验magic
        Short magic = in.readShort();
        if(Common.MAGEIC!=magic){
            throw new IllegalArgumentException("magic number is illegal, " + magic);
        }
        Byte version = in.readByte();

        Byte serializeAlg = in.readByte();

        Byte msgType = in.readByte();

        Byte status = in.readByte();

        Long messageId = in.readLong();

        int dataLen = in.readInt();
        if(in.readableBytes()<dataLen){
            in.resetReaderIndex();
            return;
        }
        //  把数据放入byte数组当中
        byte[] data = new byte[dataLen];
        in.readBytes(data);

        //还原header
        SmallHeader smallHeader = new SmallHeader();
        smallHeader.setDataLen(dataLen);
        smallHeader.setMagic(magic);
        smallHeader.setMessageId(messageId);
        smallHeader.setStatus(status);
        smallHeader.setMsgType(msgType);
        smallHeader.setSerialAlg(serializeAlg);
        smallHeader.setVersion(version);
        MsgType type = MsgType.findByType(msgType);
        RpcSerialization rpcSerialization = SerializationFactory.getRpcSerialization(serializeAlg);
        switch (type){
            case REQUEST:
                MiniRpcRequest request = rpcSerialization.deserialize(data, MiniRpcRequest.class);
                if (request != null) {
                    SmallRpcProtocol<MiniRpcRequest> protocol = new SmallRpcProtocol<>();
                    protocol.setSmallHeader(smallHeader);
                    protocol.setData(request);
                    list.add(protocol);
                    System.out.println(JSON.toJSONString(protocol));
                }

                break;
            case RESPONSE:
                MiniRpcResponse response = rpcSerialization.deserialize(data,MiniRpcResponse.class);
                if(response!=null){
                    SmallRpcProtocol<MiniRpcResponse> protocol = new SmallRpcProtocol<>();
                    protocol.setSmallHeader(smallHeader);
                    protocol.setData(response);
                    list.add(protocol);
                    System.out.println(JSON.toJSONString(protocol));
                }
                break;

        }













    }
}
