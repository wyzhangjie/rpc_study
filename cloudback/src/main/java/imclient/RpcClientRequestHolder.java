package imclient;

import common.MiniRcpFuture;
import common.MiniRpcResponse;

import java.util.HashMap;
import java.util.Map;

public class RpcClientRequestHolder {

   public static final Map<Long, MiniRcpFuture<MiniRpcResponse>>  holder = new HashMap<>();
}
