package com.rpc.common;

import io.netty.util.concurrent.Promise;
import lombok.Data;

@Data
public class MiniRcpFuture<T> {
    Promise<T> promise;
    private long timeout;

    public void MiniRcpFuture(Promise<T> promise ,long timeout){
     this.promise = promise;
     this.timeout = timeout;
    }
}
