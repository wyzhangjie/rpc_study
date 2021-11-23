package questions.evrydaystep;

import sun.tools.jstat.Jstat;

import java.util.HashMap;
import java.util.Map;

/**
 * 677. 键值映射
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 *
 * 示例：
 *
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *
 *
 * 提示：
 *
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 * 通过次数
 * */
public class MapSum {
    TrieNode1 trie;
    public MapSum() {
        trie = new TrieNode1();
    }

    public void insert(String key, int val) {
        TrieNode1 temp = trie;
        for(int i=0;i<key.length();i++){
            int pos = key.charAt(i)-'a';
            if(temp.childs[pos]==null){
                temp.childs[pos]=new TrieNode1();
            }
            temp = temp.childs[pos];
        }
        temp.value=val;
    }

    public int sum(String prefix) {
        TrieNode1 temp = trie;
        for(int i=0;i<prefix.length();i++){
            int pos = prefix.charAt(i)-'a';
            if(temp.childs[pos]==null){
                return 0;
            }
            temp = temp.childs[pos];
        }
        return dfs(temp);
    }

    private int dfs(TrieNode1 temp) {
        if(temp==null){
            return 0;
        }
        int sum = 0;
        if(temp.value!=0){
            sum+=temp.value;
        }
        for(TrieNode1 child :temp.childs){
            sum+=dfs(child);
        }
        return sum;
    }

    private   class TrieNode1{
        TrieNode1[] childs= new TrieNode1[26];
         int value;
    }


    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple",3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }
}
