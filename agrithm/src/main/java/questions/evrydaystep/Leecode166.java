package questions.evrydaystep;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Leecode166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long donominatorLong = (long) denominator;
        long numeratorLong =numerator;
        long bigPart = numeratorLong / donominatorLong;
        long smallPart = Math.abs( numeratorLong % donominatorLong);
        if(smallPart==0){
            return String.valueOf(bigPart);
        }


        String symbol ="";
        if((numeratorLong^donominatorLong)<0){
            symbol="-";
        }
        StringBuffer sb = new StringBuffer();
        sb.append(symbol).append(Math.abs(bigPart)).append(".");

        StringBuffer tmp = getSmallResult(donominatorLong, smallPart);

        sb.append(tmp);
        return sb.toString();

    }

    public StringBuffer getSmallResult(long donominatorLong, long smallPart) {

        StringBuffer tmp = new StringBuffer();
        Map<Long,Integer> map = new LinkedHashMap<>();
        int index=0;

        while (smallPart !=0 && !map.containsKey(smallPart)){
            map.put(smallPart,index++);
            smallPart *=10;
            long tt = Math.abs(donominatorLong);
            tmp.append(smallPart /tt);
            smallPart %=tt;

        }

        if(smallPart !=0){
            int insertIndex = map.get(smallPart);
            tmp.insert(insertIndex,"(");
            tmp.append(")");
        }
        return tmp;
    }

    public static void main(String[] args) {
        //-1
        //-2147483648
       int numerator = -2147483648;
       int denominator = 1;
        Leecode166 leecode166 = new Leecode166();
     //   System.out.println(leecode166.fractionToDecimal(numerator,denominator));
        int a=4;
        int b=333;
        long smallPart = Math.abs( a % b);
        leecode166.fractionToDecimal(a,b);
    }
}
