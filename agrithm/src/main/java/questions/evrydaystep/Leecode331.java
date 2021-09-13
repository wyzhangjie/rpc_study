package questions.evrydaystep;

import java.nio.charset.StandardCharsets;

public class Leecode331 {
    public boolean isValidSerialization(String preorder) {
        char[] a = preorder.toCharArray();
        int slot=1;
        for(int i=0;i<a.length;i++){
            if(slot==0){
                return false;
            }

            if(a[i]==','){
                continue;
            }
            if(a[i]=='#'){
                slot--;

            }
            if(Character.isDigit(a[i])){
                while (i<a.length && Character.isDigit(a[i])){
                    i++;
                }
                i--;
              slot++;
            }


        }
        return slot==0;
    }

    public static void main(String[] args) {
        String preorder ="9,3,4,#,#,1,#,#,2,#,6,#,#";
        Leecode331 leecode331 = new Leecode331();
        System.out.println(leecode331.isValidSerialization(preorder));

    }
}
