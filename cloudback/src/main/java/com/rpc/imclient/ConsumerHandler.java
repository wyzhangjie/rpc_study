package com.rpc.imclient;

import com.rpc.codc.SmallRpcProtocol;
import com.rpc.common.MiniRcpFuture;
import com.rpc.common.MiniRpcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ConsumerHandler extends SimpleChannelInboundHandler<SmallRpcProtocol<MiniRpcResponse>> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, SmallRpcProtocol<MiniRpcResponse> response) throws Exception {
        long requestId= response.getSmallHeader().getMessageId();
        MiniRcpFuture<MiniRpcResponse> future =  RpcClientRequestHolder.holder.remove(requestId);
        future.getPromise().setSuccess(response.getData());
    }
}
