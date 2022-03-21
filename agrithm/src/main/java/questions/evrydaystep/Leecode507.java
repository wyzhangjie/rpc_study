package questions.evrydaystep;

public class Leecode507 {
    public boolean checkPerfectNumber(int num) {
        int sum=1;
        for(int i=2;i<num/i;i++){
            if(num%i==0){
                sum+=i+num/i;
            }
        }
        return sum==num;

    }

    public static void main(String[] args) {
        int num=2;
        Leecode507 leecode507 = new Leecode507();
        System.out.println(
                leecode507.checkPerfectNumber(num)
        );
    }
}
