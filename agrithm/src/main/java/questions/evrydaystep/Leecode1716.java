package questions.evrydaystep;

public class Leecode1716 {
    public int totalMoney(int n) {
        int first = (1+7)*7/2;
        int num = n/7;
        int left=n%7;
        int sum=0;
        for(int i=0;i<num;i++){
            sum+=first+7*i;
        }
        for(int i=0;i<left;i++){
            num++;
            sum+=num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n=20;
        Leecode1716 leecode1716 = new Leecode1716();
        System.out.println(leecode1716.totalMoney(n));
    }
}
