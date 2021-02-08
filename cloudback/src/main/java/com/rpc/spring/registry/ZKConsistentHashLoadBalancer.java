package com.rpc.spring.registry;

import org.apache.curator.x.discovery.ServiceInstance;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ZKConsistentHashLoadBalancer {

    private static final int VERTUAL_NODE_NUMS=10;

    private static String SPLIT_NODE="#";

    public ServiceInstance<ServiceMeta> select(List<ServiceInstance<ServiceMeta>> serviceInstances, int hashCode) {
        //将传过来的serviceInstances放入到hashTree当中去(每一个服务都要有十个虚拟节点)
        TreeMap<Integer,ServiceInstance<ServiceMeta>> allVurtualNodes = new TreeMap<>();
       serviceInstances.forEach((a)->{
            for(int i=0;i<VERTUAL_NODE_NUMS;i++){
                Integer key = buildKey(i,a);
                allVurtualNodes.put(key,a);
            }
        });

        return allocateNode(allVurtualNodes,hashCode);
    }
    private ServiceInstance<ServiceMeta> allocateNode(TreeMap<Integer, ServiceInstance<ServiceMeta>> ring, int hashCode) {
        Map.Entry<Integer, ServiceInstance<ServiceMeta>> result = ring.ceilingEntry(hashCode);
        if(result==null){
            return ring.get(0);
        }
        return result.getValue();
    }

    private Integer buildKey(int i, ServiceInstance<ServiceMeta> a) {
        ServiceMeta payload =a.getPayload();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(payload.getServiceAddr());
        stringBuffer.append(":");
        stringBuffer.append(payload.getServicePort());
        stringBuffer.append(SPLIT_NODE);
        stringBuffer.append(i);
        return stringBuffer.hashCode();

    }
}
