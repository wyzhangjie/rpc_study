package questions.evrydaystep;

public class Leecode1009 {
    public int findComplement(int n) {
        int bigOnePos = 0;
        for (int i = 0; i <= 30; i++) {
            if (n >= 1 << i) {
                bigOnePos = i;
            } else {
                break;
            }
        }
        int mask = bigOnePos == 30 ? 0X7fffffff : (1 << (bigOnePos + 1)) - 1;
        return n ^ mask;
    }

    public static void main(String[] args) {
        int n = 5;
        Leecode1009 leecode1009 = new Leecode1009();
        System.out.println(leecode1009.findComplement(10));
    }
}
