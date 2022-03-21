package questions.evrydaystep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leecode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        result.add(0);
        Boolean[] booleans = new Boolean[n];
        deep(n,result,booleans);
        return  result;
    }

    private void deep(int n, List<Integer> result, Boolean[] booleans) {
        if(result.size()==n){
            return;
        }
        for(int  i=1;i<n;i++){
            if(booleans[i]==false){
                if(check(result.get(result.size()-1),i)){
                    booleans[i]=true;
                    result.add(i);
                    deep(n,result,booleans);
                    result.remove(result.get(result.size()-1));
                    booleans[result.get(result.size()-1)]=false;
                }

            }
        }
    }

    private boolean check(Integer a1, int a2) {
        return  false;
    }


}
