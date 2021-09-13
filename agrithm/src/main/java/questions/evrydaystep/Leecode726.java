package questions.evrydaystep;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
/**
 * 726. 原子的数量
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 *
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 *
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 *
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 *
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 *
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 *
 * 示例 1:
 *
 * 输入:
 * formula = "H2O"
 * 输出: "H2O"
 * 解释:
 * 原子的数量是 {'H': 2, 'O': 1}。
 * 示例 2:
 *
 * 输入:
 * formula = "Mg(OH)2"
 * 输出: "H2MgO2"
 * 解释:
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 * 示例 3:
 *
 * 输入:
 * formula = "K4(ON(SO3)2)2"
 * 输出: "K4N2O14S4"
 * 解释:
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 * */
public class Leecode726 {
    int i=0;
    String formular;
    int n=0;
    public String countOfAtoms(String formula1) {
        StringBuffer result = new StringBuffer();
        formular=formula1;
        n=formular.length();
        //设计一个队列
        Deque<Map<String,Integer>> stack = new LinkedList<>();
        stack.push(new HashMap<>());
        while (i<n){
            char ch = formular.charAt(i);
            if(ch=='('){
                i++;
                stack.push(new HashMap<String,Integer>());
            }else if(ch==')'){
                i++;
                int num = getDegit();
                Map<String,Integer> pop = stack.pop();
                Map<String,Integer> peek =stack.peek();
                for(Map.Entry<String,Integer> entry:pop.entrySet()){
                    String key = entry.getKey();
                    Integer v= entry.getValue();
                    peek.put(key,peek.getOrDefault(key,0)+v*num);
                }
            }else {
                String delpha = getAlphaBet();
                int num = getDegit();
                Map<String,Integer> peek =stack.peek();
                peek.put(delpha,peek.getOrDefault(delpha,0)+num);

            }
        }
        Map<String,Integer> map = stack.pop();
        TreeMap<String,Integer> treeMap = new TreeMap<>(map);
        for(Map.Entry<String,Integer> entry:treeMap.entrySet()){
            String key = entry.getKey();
            Integer v= entry.getValue();
            result.append(key);
            if(v>1){
                result.append(v);
            }
        }
        return result.toString();


        //设计一个栈

        //设计
    }

    int getDegit(){
        int temp=0;
        if(i==n || !Character.isDigit(formular.charAt(i))){
            return 1;
        }else {
            while (i<n &&Character.isDigit(formular.charAt(i))){
                temp=temp*10+formular.charAt(i++)-'0';
            }
            return temp;
        }


    }

    String getAlphaBet(){
    StringBuffer sb = new StringBuffer();
    sb.append(formular.charAt(i++));
    while (i<n&& Character.isLowerCase(formular.charAt(i))){
        sb.append(formular.charAt(i++));
    }

    return sb.toString();
    }

    public static void main(String[] args) {
    String formula = "Be32";
        Leecode726 leecode726 = new Leecode726();
        System.out.println(leecode726.countOfAtoms(formula));
    }
}
