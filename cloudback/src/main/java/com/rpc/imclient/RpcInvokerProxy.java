package com.rpc.imclient;

import com.rpc.codc.*;
import com.rpc.common.*;
import com.rpc.spring.registry.RegistryService;
import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultPromise;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class RpcInvokerProxy implements InvocationHandler {

    private final String serviceVersion;
    private final long timeout;
    private final RegistryService registryService;


    public  RpcInvokerProxy(String serviceVersion,long timeout, RegistryService registryService){
        this.serviceVersion=serviceVersion;
        this.timeout=timeout;
        this.registryService=registryService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SmallRpcProtocol<MiniRpcRequest> protocol = new SmallRpcProtocol<>();
        SmallHeader smallHeader = new SmallHeader();
        long requestId=RpcClientRequestHolder.REQUEST_ID_GEN.incrementAndGet();
        smallHeader.setMagic(Common.MAGEIC);
        smallHeader.setMessageId(requestId);
        smallHeader.setVersion(Common.VERSION);
        smallHeader.setMsgType((byte)MsgType.REQUEST.getType());
        smallHeader.setSerialAlg((byte)SerializationTypeEnum.JSON.getType());
        protocol.setSmallHeader(smallHeader);
        MiniRpcRequest request = new MiniRpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParams(args);
        request.setParameterTypes(method.getParameterTypes());
        request.setServiceVersion(this.serviceVersion);
        RpcSerialization serialization = SerializationFactory.getRpcSerialization(smallHeader.getSerialAlg());
        byte[] body = serialization.serialize(request);
        smallHeader.setDataLen(body.length);
        protocol.setData(request);
        RpcConsumer rpcConsumer = new RpcConsumer();
        MiniRcpFuture<MiniRpcResponse> future = new MiniRcpFuture<>(new DefaultPromise<>(new DefaultEventLoop()), timeout);
        RpcClientRequestHolder.holder.put(requestId, future);
        rpcConsumer.sendRequest(protocol, this.registryService);
        return future.getPromise().get(future.getTimeout(), TimeUnit.MILLISECONDS).getData();
    }
}
