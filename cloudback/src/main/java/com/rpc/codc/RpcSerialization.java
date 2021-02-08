package com.rpc.codc;

import java.io.IOException;

public interface RpcSerialization {
    <T> byte[] serialize(T data) throws Exception;

    <T> T deserialize(byte[] data, Class<T> kind) throws IOException;
}
