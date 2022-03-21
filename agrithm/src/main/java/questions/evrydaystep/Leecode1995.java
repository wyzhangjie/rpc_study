package questions.evrydaystep;

import java.util.HashMap;
import java.util.Map;

public class Leecode1995 {
    public int countQuadruplets(int[] nums) {
        int ans=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int c=nums.length-2;c>1;c--){
            map.put(nums[c+1],map.getOrDefault(nums[c+1],0)+1);
            for(int b=c-1;b>0;b--){
                for(int a=b-1;a>=0;a--){
                    ans+= map.getOrDefault(nums[a]+nums[b]+nums[c],0);
                }
            }

        }
        return ans;
    }
}
