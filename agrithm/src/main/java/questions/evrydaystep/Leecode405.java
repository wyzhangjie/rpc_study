package questions.evrydaystep;

public class Leecode405 {

    public String toHex(int num) {
        if(num==0) return "0";
        long numLong=(long)num;
    StringBuffer temp = new StringBuffer();
    if(num<0){
        numLong=(long)(Math.pow(2,32)+num);
    }
    while (numLong!=0){
        long a= numLong%16;
        char tempA= (char)(a+'0');
        if(a>9){
            tempA=(char)( a-10+'a');
        }
        temp.append(tempA);
        numLong=numLong/16;
    }
    return temp.reverse().toString();
    }

    public static void main(String[] args) {
        int a=26;
        Leecode405 leecode405 = new Leecode405();
        System.out.println(
                leecode405.toHex(-1)
        );
    }
}
