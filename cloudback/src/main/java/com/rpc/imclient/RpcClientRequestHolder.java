package com.rpc.imclient;

import com.rpc.common.MiniRcpFuture;
import com.rpc.common.MiniRpcResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class RpcClientRequestHolder {
   public final static AtomicLong REQUEST_ID_GEN = new AtomicLong(0);
   public static final Map<Long, MiniRcpFuture<MiniRpcResponse>>  holder = new HashMap<>();
}
