package com.rpc.codc;

public class HessianSerialization implements RpcSerialization{
    @Override
    public <T> byte[] serialize(T data) throws Exception {
        return new byte[0];
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> kind) {
        return null;
    }
}
