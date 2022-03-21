package questions.evrydaystep.weekcompetation;/**
 * ClassName Leecode2182_new
 * Description
 * Create by jie.zhang02
 * Date 2022/2/24 12:02 下午
 */

/**
 * @author jie.zhang
 * @date 2022年02月24日 12:02 下午
 */
public class Leecode2182_new {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] indexs = new int[26];
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            indexs[s.charAt(i) - 'a']++;
        }
        int left=-1;
        int right=-1;
        for(int i=25;i>=0;i--){
            if(indexs[i]>0){
                if(right==-1){
                    right=i;
                }else if(left==-1) {
                    left=i;
                    break;
                }

            }
        }
            while (true){
                while (indexs[right]!=0){
                    int count=0;
                    while (indexs[right]!=0 && count<repeatLimit){
                        insertChars(1,right,sb);
                        count++;
                        indexs[right]--;
                    }
                    if(count==repeatLimit && indexs[right]!=0){
                        //次大字母全部用完了，跳出去。
                        if(left==-1){
                            break;
                        }

                        insertChars(1,left,sb);
                        indexs[left]--;
                        //次大字母部分用完了，可以换下一个了
                        if(indexs[left]==0){
                            left= findNext(left,indexs);
                        }
                    }
                }
                //跳出来有俩情况，第一种正常跳出来了，转换最大字母和次大字母，继续循环
                right=left;
                left=findNext(left,indexs);
                //跳出来的第二种情况，left用尽，仍然有俩情况
                if(left==-1){
                    //最大字母个数还没耗尽
                    if(right!=-1 && indexs[right]!=0){
                        if(indexs[right]> repeatLimit){
                            insertChars(repeatLimit,right,sb);
                        }else {
                            insertChars(indexs[right],right,sb);
                        }
                    }
                    //最大字母也耗尽了，次大也没了，跳出去。
                    break;
                }
            }


        return sb.toString();
    }
    private void insertChars(int num,int index, StringBuffer sb) {
        for (int j = 0; j < num; j++) {
            sb.append((char)( 'a' + index));
        }
    }

    private int findNext(int left,int[] indexs){
        if(left==0){
            return -1;
        }
        for(int i=left-1;i>=0;i--){
            left=-1;
            if(indexs[i]!=0){
                left=i;
                break;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        //String s = "xyutfpopdynbadwtvmxiemmusevduloxwvpkjioizvanetecnuqbqqdtrwrkgt";
        //"aababab"
        //2
        int repeatLimit = 3;
     //   String s= "xyutfpopdynbadwtvmxiemmusevduloxwvpkjioizvanetecnuqbqqdtrwrkgt";
        String s="cczazcc";
        //"aababab"
        //2

        Leecode2182_new leecode2182 = new Leecode2182_new();
        System.out.println(leecode2182.repeatLimitedString(s,repeatLimit));

    }
}
