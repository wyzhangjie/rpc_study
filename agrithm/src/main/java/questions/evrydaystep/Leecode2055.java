package questions.evrydaystep;/**
 * ClassName Leecode2055
 * Description
 * Create by jie.zhang02
 * Date 2022/3/8 10:11 上午
 */


import java.util.Stack;

/**
 * @author jie.zhang
 * @date 2022年03月08日 10:11 上午
 */
public class Leecode2055 {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] sum=new int[queries.length];
        /*for(int i=0;i<queries.length;i++){
            sum[i]= getSum(queries[i],s);
        }*/
        int[] poses = new int[s.length()];
        int index=0;
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)=='|'){
                poses[index++]=i;
            }
        }

        for(int i=0;i<queries.length;i++){
            int left=0;
            int right=1;
          //  while (left<poses.length && right<poses.length &&poses[left]<queries[i][0])
        }
        return sum;

    }

    private int getSum(int[] query, String s) {
        Stack<Character> stack= new Stack<>();
        int sum=0;
        boolean hasCandle=false;
        for(int i=query[0];i<=query[1];i++){
            if(!hasCandle && s.charAt(i)!='|'){
                continue;
            }else if(!hasCandle && s.charAt(i)=='|'){
                stack.push(s.charAt(i));
                hasCandle=true;
            }else if(s.charAt(i)=='*'){
                stack.push(s.charAt(i));
            }else if(s.charAt(i)=='|'){
                while (!stack.empty()){
                    if(stack.peek()=='|'){
                        break;
                    }
                    if(stack.pop()=='*'){
                       sum++;
                    }else  {
                        break;
                    }


                }
            }

        }
        return sum;
    }

    public static void main(String[] args) {
       String s = s = "***|**|*****|**||**|*";
       int[][] queries = {{1,17},{4,5},{14,17},{5,11},{15,16}};
        Leecode2055 leecode2055 = new Leecode2055();
        int[] result=(leecode2055.platesBetweenCandles(s,queries));
        for(int a:result){
            System.out.println(a);
        }
    }
}
