package com.rpc.codc;

import lombok.Data;

import java.io.Serializable;

@Data
public class SmallRpcProtocol<T> implements Serializable {

    private SmallHeader smallHeader;
    private T data;
}
