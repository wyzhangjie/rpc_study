package questions.evrydaystep;

import java.util.*;

/**
 * 692. 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 * <p>
 * <p>
 * 扩展练习：
 * <p>
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 */
public class Leecode692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        List<String> result = new LinkedList<>();
        map.entrySet().forEach((a)->result.add(a.getKey()));
        Collections.sort(result, (o1, o2) -> map.get(o1)==map.get(o2)?o1.compareTo(o2):map.get(o2)-map.get(o1));

        return result.subList(0,k);
    }

    public List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
       PriorityQueue<Map.Entry<String,Integer>> queue = new PriorityQueue<>((entry1, entry2) -> entry1.getValue()==entry2.getValue()?entry2.getKey().compareTo(entry1.getKey()):entry1.getValue()-entry2.getValue());
        map.entrySet().forEach((a)->{
            queue.offer(a);
            if(queue.size()>k){
                queue.poll();
            }
        });
        List<String> reverList = new LinkedList<>();
        while (queue.size()>0){
            reverList.add(queue.poll().getKey());
        }
        Collections.reverse(reverList);
        return reverList;

    }

    private boolean isNewFront(String a1, String a2) {
        for (int i = 0, j = 0; i < a1.length() & j < a2.length(); i++, j++) {
            if (a1.charAt(i) < a2.charAt(j)) {
                return true;
            }else {
                return false;
            }
        }
        if (a1.length() == a2.length()) {
            return false;
        }
        if (a1.length() > a2.length()) {
            return false;
        }
        return true;

    }


    public static void main(String[] args) {
        String[] a= new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        Leecode692 leecode692 = new Leecode692();
        System.out.println(leecode692.topKFrequent1(a,3));
        //["i", "love", "leetcode", "i", "love", "coding"]
        //1

        //["i", "love", "leetcode", "i", "love", "coding"]
        //3
    }

}

