package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;

public class Leecode1736 {
    public String maximumTime(String time) {
        Map<Integer,Character> map = new HashMap<>();
        map.put(0,'2');
        map.put(1,'3');
        map.put(3,'5');
        map.put(4,'9');
        char[] chars = time.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(i==0 && chars[i]=='?'&& chars[1]>='4'&& chars[1]!='?'){
                chars[i]='1';
                continue;
            }
            if(i==1 && chars[i]=='?' && (chars[i-1]=='0' ||chars[i-1]=='1') ){
                chars[i]='9';
            }else if(chars[i]=='?'){
                chars[i]=map.get(i);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Leecode1736 leecode1736 = new Leecode1736();
        System.out.println(leecode1736.maximumTime("2?:?0"));
    }
}
