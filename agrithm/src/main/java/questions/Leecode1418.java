package questions;

import com.alibaba.fastjson.JSON;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 1418. 点菜展示表
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 *
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 *
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
 * 输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
 * 解释：
 * 点菜展示表如下所示：
 * Table,Beef Burrito,Ceviche,Fried Chicken,Water
 * 3    ,0           ,2      ,1            ,0
 * 5    ,0           ,1      ,0            ,1
 * 10   ,1           ,0      ,0            ,0
 * 对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
 * 而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
 * 餐桌 10：Corina 点了 "Beef Burrito"
 * 示例 2：
 *
 * 输入：orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
 * 输出：[["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
 * 解释：
 * 对于餐桌 1：Adam 和 Brianna 都点了 "Canadian Waffles"
 * 而餐桌 12：James, Ratesh 和 Amadeus 都点了 "Fried Chicken"
 * 示例 3：
 *
 * 输入：orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
 * 输出：[["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
 *
 *
 * 提示：
 *
 * 1 <= orders.length <= 5 * 10^4
 * orders[i].length == 3
 * 1 <= customerNamei.length, foodItemi.length <= 20
 * customerNamei 和 foodItemi 由大小写英文字母及空格字符 ' ' 组成。
 * tableNumberi 是 1 到 500 范围内的整数。
 * 通过次数13,738提交次数19,457
 * */
public class Leecode1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
    Set<String> menu = new TreeSet<>();
        List<List<String>> ans =new LinkedList<>();
    //桌号，《餐品，次数》
    Map<Integer, Map<String,Integer>> tables = new TreeMap<>();
     //orders[i]=[customerNamei,tableNumberi,foodItemi]
        orders.stream().forEach((a)->{
            menu.add(a.get(2));
            Map<String,Integer> tep = tables.getOrDefault(Integer.valueOf(a.get(1)),new TreeMap<>());
            tep.put(a.get(2),tep.getOrDefault(a.get(2),0)+1);
            tables.put(Integer.valueOf(a.get(1)),tep);
        });

        int n = menu.size() + 1, m = tables.size() + 1;
        // 构造 title
        List<String> title = new LinkedList<>();
        title.add("Table");
        title.addAll(menu);
        ans.add(title);
        // 构造内容
        for (int tidx : tables.keySet()) {
            Map<String, Integer> map = tables.get(tidx);
            List<String> cur = new LinkedList<>();
            cur.add(tidx + "");
            for (String food : menu) {
                cur.add(map.getOrDefault(food, 0) + "");
            }
            ans.add(cur);
        }
        return ans;
    }

    public static void main(String[] args) {
        //orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
       //[["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],
        // ["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
        List<List<String>> orders = new LinkedList<>();
        List<String> a = new LinkedList<>();
        a.add("David");
        a.add("3");
        a.add("Ceviche");
        List<String> b = new LinkedList<>();
        b.add("Corina");
        b.add("10");
        b.add("Beef Burrito");
        List<String> c = new LinkedList<>();
        c.add("David");
        c.add("3");
        c.add("Fried Chicken");
        orders.add(a);
        orders.add(b);
        orders.add(c);

        List<String> d = new LinkedList<>();
        d.add("Carla");
        d.add("5");
        d.add("Water");

        List<String> e = new LinkedList<>();
        e.add("Carla");
        e.add("5");
        e.add("Ceviche");


        List<String> f = new LinkedList<>();
        f.add("Rous");
        f.add("3");
        f.add("Ceviche");
        orders.add(d);
        orders.add(e);
        orders.add(f);
        Leecode1418 leecode1418 = new Leecode1418();
        System.out.println(JSON.toJSONString(leecode1418.displayTable(orders)));
    }
}
