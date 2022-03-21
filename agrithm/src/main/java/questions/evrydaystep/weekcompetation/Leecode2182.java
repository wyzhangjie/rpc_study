package questions.evrydaystep.weekcompetation;/**
 * ClassName Leecode2182
 * Description
 * Create by jie.zhang02
 * Date 2022/2/23 2:05 下午
 */

/**
 * @author jie.zhang
 * @date 2022年02月23日 2:05 下午
 */
public class Leecode2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] indexs = new int[26];
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            indexs[s.charAt(i) - 'a']++;
        }
        int left=0;
        int right=0;
       for(int i=25;i>=0;i--){
           if(indexs[i]>0){
               if(right==0){
                   right=i;
               }else if(left==0) {
                    left=i;
                    break;
               }

           }
       }

       while (left!=right){
           while (indexs[right]!=0){
                    if(indexs[right]-repeatLimit>=0){
                        insertChars(repeatLimit,right,sb);
                        indexs[right]-=repeatLimit;

                        if(indexs[left]==0){
                            left=-2;
                            break;
                        }
                        insertChars(1,left,sb);
                        indexs[left]--;
                        if(indexs[left]==0){

                            for(int i=left-1;i>=0;i--){
                                left=-1;
                                if(indexs[i]!=0){
                                    left=i;
                                    break;
                                }
                            }
                            if(left==-1){
                                break;
                            }
                        }
                    }else {
                        insertChars(indexs[right],right,sb);
                        indexs[right]=0;
                    }


           }
           if(indexs[right]!=0){
               if(left==-1){
                   insertChars(indexs[right],right,sb);
               }
               break;
           }
           System.out.println("left+"+left+"right"+right);
           if(left>=0){
               right=left;
               for(int i=left-1;i>=0;i--){
                   if(indexs[i]!=0){
                       left=i;
                       break;
                   }
               }

           }


       }

        return sb.toString();

    }

    private void insertChars(int num,int index, StringBuffer sb) {
        for (int j = 0; j < num; j++) {
            sb.append((char)( 'a' + index));
        }
    }

    public static void main(String[] args) {
       //String s = "xyutfpopdynbadwtvmxiemmusevduloxwvpkjioizvanetecnuqbqqdtrwrkgt";
        //"aababab"
        //2
       int repeatLimit = 1;
       String s= "xyutfpopdynbadwtvmxiemmusevduloxwvpkjioizvanetecnuqbqqdtrwrkgt";
        Leecode2182 leecode2182 = new Leecode2182();
        System.out.println(leecode2182.repeatLimitedString(s,repeatLimit));

    }
}
