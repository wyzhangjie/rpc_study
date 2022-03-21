package questions.evrydaystep;/**
 * ClassName Leecode599
 * Description
 * Create by jie.zhang02
 * Date 2022/3/14 10:47 上午
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jie.zhang
 * @date 2022年03月14日 10:47 上午
 */
public class Leecode599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        int index = list2.length + 1+list1.length;
        int count = 0;
        List<String> sb = new ArrayList<>();
        if (list1.length > list2.length) {
            findRestaurant(list2, list1);
        }
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])){
                if(i+map.get(list2[i])==index){
                    sb.add(list2[i]);
                    count++;
                }
                if(i+map.get(list2[i])<index){
                    sb=new ArrayList();
                    sb.add(list2[i]);
                    index=i+map.get(list2[i]);
                    count=1;
                }
            }
        }
        return sb.toArray(new String[sb.size()]);

    }

    public static void main(String[] args) {
      String[]  list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        Leecode599 leecode599 = new Leecode599();
        String[] result = leecode599.findRestaurant(list1,list2);
        for(String a:result){
            System.out.println(a);
        }

    }
}
